package com.metea.ordermanagementservice.serviceview.impl;

import com.metea.ordermanagementservice.domain.OrderMaster;
import com.metea.ordermanagementservice.dto.OrderMasterReadDTO;
import com.metea.ordermanagementservice.dto.OrderMasterSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderMasterWriteDTO;
import com.metea.ordermanagementservice.service.OrderMasterService;
import com.metea.ordermanagementservice.serviceview.OrderMasterServiceView;
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
public class OrderMasterServiceViewImpl implements OrderMasterServiceView {

    private final OrderMasterService orderMasterService;
    private final ModelMapper modelMapper;

    @Override
    public OrderMasterReadDTO create(OrderMasterWriteDTO orderMasterWriteDTO) {
        return convertToDTO(orderMasterService.create(orderMasterWriteDTO));
    }

    @Override
    public OrderMasterReadDTO delete(Long id) {
        return convertToDTO(orderMasterService.delete(id));
    }

    @Override
    public Page<OrderMasterReadDTO> search(OrderMasterSearchCriteriaDTO filter, Pageable pageable) {
        return orderMasterService.search(filter, pageable).map(this::convertToDTO);
    }

    @Override
    public OrderMasterReadDTO markAsComplete(Long id) {
        return convertToDTO(orderMasterService.markAsComplete(id));
    }

    public OrderMasterReadDTO convertToDTO(OrderMaster orderMaster) {
        return modelMapper.map(orderMaster, OrderMasterReadDTO.class);
    }
}
