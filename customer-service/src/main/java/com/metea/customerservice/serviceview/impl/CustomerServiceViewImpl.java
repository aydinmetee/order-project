package com.metea.customerservice.serviceview.impl;

import com.metea.customerservice.domain.Customer;
import com.metea.customerservice.dto.CustomerReadDTO;
import com.metea.customerservice.dto.CustomerSearchCriteriaDTO;
import com.metea.customerservice.dto.CustomerWriteDTO;
import com.metea.customerservice.service.CustomerService;
import com.metea.customerservice.serviceview.CustomerServiceView;
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
public class CustomerServiceViewImpl implements CustomerServiceView {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @Override
    public CustomerReadDTO create(CustomerWriteDTO customerWriteDTO) {
        return convertToDTO(customerService.create(customerWriteDTO));
    }

    @Override
    public CustomerReadDTO update(Long id, CustomerWriteDTO customerWriteDTO) {
        return convertToDTO(customerService.update(id, customerWriteDTO));
    }

    @Override
    public CustomerReadDTO delete(Long id) {
        return convertToDTO(customerService.delete(id));
    }

    @Override
    public Page<CustomerReadDTO> search(CustomerSearchCriteriaDTO filter, Pageable pageable) {
        return customerService.search(filter, pageable).map(this::convertToDTO);
    }

    private CustomerReadDTO convertToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerReadDTO.class);
    }
}
