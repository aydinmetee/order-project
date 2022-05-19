package com.metea.ordermanagementservice.service;

import com.metea.ordermanagementservice.domain.OrderDetail;
import com.metea.ordermanagementservice.dto.OrderDetailSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderDetailWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface OrderDetailService {
    OrderDetail create(OrderDetailWriteDTO orderDetailWriteDTO);

    OrderDetail delete(Long id);

    Page<OrderDetail> search(OrderDetailSearchCriteriaDTO filter, Pageable pageable);
}
