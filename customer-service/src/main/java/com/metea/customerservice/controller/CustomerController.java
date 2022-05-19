package com.metea.customerservice.controller;

import com.metea.customerservice.dto.CustomerReadDTO;
import com.metea.customerservice.dto.CustomerSearchCriteriaDTO;
import com.metea.customerservice.dto.CustomerWriteDTO;
import com.metea.customerservice.serviceview.CustomerServiceView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceView customerServiceView;

    @PostMapping()
    public ResponseEntity<CustomerReadDTO> create(@RequestBody CustomerWriteDTO customerWriteDTO) {
        return ResponseEntity.ok(customerServiceView.create(customerWriteDTO));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerReadDTO> update(@PathVariable("customerId") Long customerId,
                                                  @RequestBody CustomerWriteDTO customerWriteDTO) {
        return ResponseEntity.ok(customerServiceView.update(customerId, customerWriteDTO));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<CustomerReadDTO> delete(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(customerServiceView.delete(customerId));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<CustomerReadDTO>> search(@RequestBody() CustomerSearchCriteriaDTO filter,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(customerServiceView.search(filter, PageRequest.of(page, size)));
    }
}
