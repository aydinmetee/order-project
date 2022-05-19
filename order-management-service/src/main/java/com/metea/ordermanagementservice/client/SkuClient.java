package com.metea.ordermanagementservice.client;

import com.metea.ordermanagementservice.dto.CustomerDTO;
import com.metea.ordermanagementservice.dto.SkuDTO;
import com.metea.ordermanagementservice.dto.SkuDetailDTO;
import com.metea.ordermanagementservice.util.RestResponsePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@FeignClient(value = "SKU-SERVICE")
public interface SkuClient {
    @GetMapping(value = "sku/{skuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    SkuDTO getSkuById(@PathVariable("skuId") Long skuId);

    @PostMapping(value = "/sku/detail/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponsePage<SkuDetailDTO> searchSkuDetail(@RequestBody SkuDetailDTO filter,
                                                   @RequestParam("page") int page,
                                                   @RequestParam("size") int size
    );
}
