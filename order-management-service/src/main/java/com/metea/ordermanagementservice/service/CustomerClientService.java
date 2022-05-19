package com.metea.ordermanagementservice.service;

import com.metea.ordermanagementservice.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface CustomerClientService {
    Page<CustomerDTO> searchCustomer(CustomerDTO filter, Pageable pageable);
}
