package com.metea.customerservice.service;

import com.metea.customerservice.domain.Customer;
import com.metea.customerservice.dto.CustomerSearchCriteriaDTO;
import com.metea.customerservice.dto.CustomerWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface CustomerService {
    Customer create(CustomerWriteDTO customerWriteDTO);

    Customer update(Long id, CustomerWriteDTO customerWriteDTO);

    Customer delete(Long id);

    Page<Customer> search(CustomerSearchCriteriaDTO filter, Pageable pageable);

}
