package com.metea.ordermanagementservice.service;

import com.metea.ordermanagementservice.domain.OrderDetail;
import com.metea.ordermanagementservice.domain.OrderMaster;
import com.metea.ordermanagementservice.dto.OrderMasterCalculateDTO;
import com.metea.ordermanagementservice.dto.OrderMasterSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderMasterWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface OrderMasterService {
    OrderMaster create(OrderMasterWriteDTO orderMasterWriteDTO);

    OrderMaster delete(Long id);

    Page<OrderMaster> search(OrderMasterSearchCriteriaDTO filter, Pageable pageable);

    OrderMaster markAsComplete(Long id);

    OrderMaster getById(Long id);

    void calculateDetails(OrderMasterCalculateDTO orderMasterCalculateDTO);

    //TODO: Calculate Ekle detay create'den sonra çağır.
}
