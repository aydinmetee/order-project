package com.metea.ordermanagementservice.service.impl;

import com.metea.ordermanagementservice.client.SkuClient;
import com.metea.ordermanagementservice.dto.SkuDTO;
import com.metea.ordermanagementservice.dto.SkuDetailDTO;
import com.metea.ordermanagementservice.service.SkuClientService;
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
public class SkuClientServiceImpl implements SkuClientService {

    private final SkuClient skuClient;

    @Override
    public SkuDTO getSkuById(Long skuId) {
        return skuClient.getSkuById(skuId);
    }

    @Override
    public Page<SkuDetailDTO> searchSkuDetail(SkuDetailDTO filter, Pageable pageable) {
        return skuClient.searchSkuDetail(filter, pageable.getPageNumber(), pageable.getPageSize());
    }
}
