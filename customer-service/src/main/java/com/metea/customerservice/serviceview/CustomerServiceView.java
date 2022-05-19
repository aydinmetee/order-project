package com.metea.customerservice.serviceview;

import com.metea.customerservice.dto.CustomerReadDTO;
import com.metea.customerservice.dto.CustomerSearchCriteriaDTO;
import com.metea.customerservice.dto.CustomerWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface CustomerServiceView {
    CustomerReadDTO create(CustomerWriteDTO customerWriteDTO);

    CustomerReadDTO update(Long id, CustomerWriteDTO customerWriteDTO);

    CustomerReadDTO delete(Long id);

    Page<CustomerReadDTO> search(CustomerSearchCriteriaDTO filter, Pageable pageable);

}
