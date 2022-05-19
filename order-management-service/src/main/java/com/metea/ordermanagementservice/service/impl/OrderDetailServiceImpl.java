package com.metea.ordermanagementservice.service.impl;

import com.metea.ordermanagementservice.domain.OrderDetail;
import com.metea.ordermanagementservice.domain.OrderMaster;
import com.metea.ordermanagementservice.dto.OrderDetailSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderDetailWriteDTO;
import com.metea.ordermanagementservice.dto.OrderMasterCalculateDTO;
import com.metea.ordermanagementservice.dto.SkuDetailDTO;
import com.metea.ordermanagementservice.repository.OrderDetailRepository;
import com.metea.ordermanagementservice.service.OrderDetailService;
import com.metea.ordermanagementservice.service.OrderMasterService;
import com.metea.ordermanagementservice.service.SkuClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final ModelMapper modelMapper;
    @Lazy
    private final OrderMasterService orderMasterService;
    private final SkuClientService skuClientService;

    @Override
    public OrderDetail create(OrderDetailWriteDTO orderDetailWriteDTO) {
        var orderDetail = modelMapper.map(orderDetailWriteDTO, OrderDetail.class);
        orderDetail.setOrderMaster(findOrderMaster(orderDetailWriteDTO.getOrderMasterId()));
        checkSku(orderDetailWriteDTO.getSkuId());
        checkSkuStock(orderDetailWriteDTO.getSkuId(), orderDetailWriteDTO.getQuantity());
        orderDetail.setValid(true);
        orderDetail = orderDetailRepository.save(orderDetail);
        calculateMaster(orderDetail, OrderMasterCalculateDTO.OperationType.CREATE);
        return orderDetail;
    }

    @Override
    public OrderDetail delete(Long id) {
        final var deletedOrderDetail = orderDetailRepository.getOne(id);
        orderDetailRepository.deleteById(id);
        calculateMaster(deletedOrderDetail, OrderMasterCalculateDTO.OperationType.DELETE);
        return deletedOrderDetail;
    }

    @Override
    public Page<OrderDetail> search(OrderDetailSearchCriteriaDTO filter, Pageable pageable) {
        return orderDetailRepository.findAll(filter.OrderDetailSearchCriteriaFieldMapper(filter), pageable);
    }

    private OrderMaster findOrderMaster(Long orderMasterId) {
        final var orderMaster = orderMasterService.getById(orderMasterId);
        if (Objects.isNull(orderMaster)) {
            throw new IllegalArgumentException("Detay eklemek istediğiniz sipariş bulunamadı.");
        }
        return orderMaster;
    }

    private void checkSku(Long skuId) {
        final var sku = skuClientService.getSkuById(skuId);
        if (Objects.isNull(sku)) {
            throw new IllegalArgumentException("Sipariş detayındaki ürün bulunamadı.");
        }
    }

    private void checkSkuStock(Long skuId, Long quantity) {
        final var filter = new SkuDetailDTO();
        filter.setSkuMasterId(skuId);
        final var skuList = skuClientService.searchSkuDetail(filter, PageRequest.of(0, 1)).getContent();
        if (skuList.isEmpty() || skuList.get(0).getQuantity() < quantity) {
            throw new IllegalArgumentException("Ürüne ait yeterli stok bulunamadı.");
        }
    }

    private void calculateMaster(OrderDetail orderDetail,
                                 OrderMasterCalculateDTO.OperationType type) {
        final var calculateDTO = new OrderMasterCalculateDTO();
        calculateDTO.setOrderDetail(orderDetail);
        calculateDTO.setOrderMaster(orderDetail.getOrderMaster());
        calculateDTO.setType(type);
        orderMasterService.calculateDetails(calculateDTO);
    }

}
