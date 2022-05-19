package com.metea.ordermanagementservice.serviceview.impl;

import com.metea.ordermanagementservice.domain.OrderDetail;
import com.metea.ordermanagementservice.dto.OrderDetailReadDTO;
import com.metea.ordermanagementservice.dto.OrderDetailSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderDetailWriteDTO;
import com.metea.ordermanagementservice.service.OrderDetailService;
import com.metea.ordermanagementservice.serviceview.OrderDetailServiceView;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Service
@RequiredArgsConstructor
public class OrderDetailServiceViewImpl implements OrderDetailServiceView {

    private final OrderDetailService orderDetailService;
    private final ModelMapper modelMapper;

    @Override
    public OrderDetailReadDTO create(OrderDetailWriteDTO orderDetailWriteDTO) {
        return convertToDTO(orderDetailService.create(orderDetailWriteDTO));
    }

    @Override
    public OrderDetailReadDTO delete(Long id) {
        return convertToDTO(orderDetailService.delete(id));
    }

    @Override
    public Page<OrderDetailReadDTO> search(OrderDetailSearchCriteriaDTO filter, Pageable pageable) {
        return orderDetailService.search(filter, pageable).map(this::convertToDTO);
    }

    private OrderDetailReadDTO convertToDTO(OrderDetail orderDetail) {
        final var readDTO = modelMapper.map(orderDetail, OrderDetailReadDTO.class);
        readDTO.setOrderMasterId(orderDetail.getOrderMaster().getId());
        return readDTO;
    }
}
