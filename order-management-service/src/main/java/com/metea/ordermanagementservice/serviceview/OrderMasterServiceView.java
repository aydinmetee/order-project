package com.metea.ordermanagementservice.serviceview;

import com.metea.ordermanagementservice.dto.OrderMasterReadDTO;
import com.metea.ordermanagementservice.dto.OrderMasterSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderMasterWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface OrderMasterServiceView {
    OrderMasterReadDTO create(OrderMasterWriteDTO orderMasterWriteDTO);

    OrderMasterReadDTO delete(Long id);

    Page<OrderMasterReadDTO> search(OrderMasterSearchCriteriaDTO filter, Pageable pageable);

    OrderMasterReadDTO markAsComplete(Long id);
}
