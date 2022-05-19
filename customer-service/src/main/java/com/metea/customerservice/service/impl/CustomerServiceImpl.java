package com.metea.customerservice.service.impl;

import com.metea.customerservice.domain.Customer;
import com.metea.customerservice.dto.CustomerSearchCriteriaDTO;
import com.metea.customerservice.dto.CustomerWriteDTO;
import com.metea.customerservice.repository.CustomerRepository;
import com.metea.customerservice.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Customer create(CustomerWriteDTO customerWriteDTO) {
        final var customer = modelMapper.map(customerWriteDTO, Customer.class);
        customer.setValid(true);
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, CustomerWriteDTO customerWriteDTO) {
        final var updatedCustomer = customerRepository.getOne(id);
        updatedCustomer.setName(customerWriteDTO.getName());
        updatedCustomer.setSurname(customerWriteDTO.getSurname());
        return customerRepository.save(updatedCustomer);
    }

    @Override
    public Customer delete(Long id) {
        final var customer = customerRepository.getOne(id);
        customerRepository.deleteById(id);
        return customer;
    }

    @Override
    public Page<Customer> search(CustomerSearchCriteriaDTO filter, Pageable pageable) {
        return customerRepository.findAll(filter.CustomerSearchCriteriaFieldMapper(filter), pageable);
    }
}
