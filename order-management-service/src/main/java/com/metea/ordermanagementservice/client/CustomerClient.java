package com.metea.ordermanagementservice.client;

import com.metea.ordermanagementservice.dto.CustomerDTO;
import com.metea.ordermanagementservice.util.RestResponsePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@FeignClient(value = "CUSTOMER-SERVICE")
public interface CustomerClient {
    @PostMapping(value = "/customer/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponsePage<CustomerDTO> searchCustomer(@RequestBody CustomerDTO filter,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("size") int size
    );
}
