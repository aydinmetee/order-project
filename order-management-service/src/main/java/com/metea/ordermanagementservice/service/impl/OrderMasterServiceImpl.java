package com.metea.ordermanagementservice.service.impl;

import com.metea.ordermanagementservice.domain.OrderMaster;
import com.metea.ordermanagementservice.dto.CustomerDTO;
import com.metea.ordermanagementservice.dto.OrderMasterCalculateDTO;
import com.metea.ordermanagementservice.dto.OrderMasterSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderMasterWriteDTO;
import com.metea.ordermanagementservice.repository.OrderMasterRepository;
import com.metea.ordermanagementservice.service.CustomerClientService;
import com.metea.ordermanagementservice.service.OrderMasterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Service
@RequiredArgsConstructor
public class OrderMasterServiceImpl implements OrderMasterService {

    private final OrderMasterRepository orderMasterRepository;
    private final ModelMapper modelMapper;
    private final CustomerClientService customerClientService;

    @Override
    public OrderMaster create(OrderMasterWriteDTO orderMasterWriteDTO) {
        final var filter = new CustomerDTO();
        filter.setId(orderMasterWriteDTO.getCustomerId());
        final var customer = customerClientService.searchCustomer(filter, PageRequest.of(0, 1)).getContent().get(0);
        if (customer.getOrderAuthorization().equals(Boolean.FALSE)) {
            throw new IllegalArgumentException("Müşteri için sipariş yetkisi bulunmamaktadır.");
        }
        final var orderMaster = modelMapper.map(orderMasterWriteDTO, OrderMaster.class);
        orderMaster.setAmount(BigDecimal.ZERO);
        orderMaster.setValid(true);
        orderMaster.setStatus(OrderMaster.OrderStatus.NEW);
        return orderMasterRepository.save(orderMaster);
    }

    @Override
    public OrderMaster delete(Long id) {
        final var deletedOrderMaster = orderMasterRepository.getOne(id);
        orderMasterRepository.deleteById(id);
        return deletedOrderMaster;
    }

    @Override
    public Page<OrderMaster> search(OrderMasterSearchCriteriaDTO filter, Pageable pageable) {
        return orderMasterRepository.findAll(filter.OrderMasterSearchCriteriaFieldMapper(filter), pageable);
    }

    @Override
    public OrderMaster markAsComplete(Long id) {
        final var completedOrderMaster = orderMasterRepository.getOne(id);
        completedOrderMaster.setStatus(OrderMaster.OrderStatus.COMPLETED);
        return completedOrderMaster;
    }

    @Override
    public OrderMaster getById(Long id) {
        return orderMasterRepository.getOne(id);
    }

    @Override
    public void calculateDetails(OrderMasterCalculateDTO orderMasterCalculateDTO) {
        var calculatedAmount = orderMasterCalculateDTO.getOrderMaster().getAmount();
        if (OrderMasterCalculateDTO.OperationType.CREATE.equals(orderMasterCalculateDTO.getType())) {
            calculatedAmount = calculatedAmount.add(orderMasterCalculateDTO.getOrderDetail().getValue()
                    .multiply(BigDecimal.valueOf(orderMasterCalculateDTO.getOrderDetail().getQuantity())));
        } else {
            calculatedAmount = calculatedAmount.subtract(orderMasterCalculateDTO.getOrderDetail().getValue()
                    .multiply(BigDecimal.valueOf(orderMasterCalculateDTO.getOrderDetail().getQuantity())));
        }

        orderMasterCalculateDTO.getOrderMaster().setAmount(calculatedAmount);
        orderMasterRepository.save(orderMasterCalculateDTO.getOrderMaster());
    }

}
