package com.metea.ordermanagementservice.serviceview;

import com.metea.ordermanagementservice.dto.OrderDetailReadDTO;
import com.metea.ordermanagementservice.dto.OrderDetailSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderDetailWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface OrderDetailServiceView {
    OrderDetailReadDTO create(OrderDetailWriteDTO orderDetailWriteDTO);

    OrderDetailReadDTO delete(Long id);

    Page<OrderDetailReadDTO> search(OrderDetailSearchCriteriaDTO filter, Pageable pageable);
}
