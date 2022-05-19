package com.metea.ordermanagementservice.service.impl;

import com.metea.ordermanagementservice.client.CustomerClient;
import com.metea.ordermanagementservice.dto.CustomerDTO;
import com.metea.ordermanagementservice.service.CustomerClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Service
@RequiredArgsConstructor
public class CustomerClientServiceImpl implements CustomerClientService {

    private final CustomerClient customerClient;

    @Override
    public Page<CustomerDTO> searchCustomer(CustomerDTO filter, Pageable pageable) {
        return customerClient.searchCustomer(filter, pageable.getPageNumber(), pageable.getPageSize());
    }
}
