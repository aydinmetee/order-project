package com.metea.ordermanagementservice.service;

import com.metea.ordermanagementservice.dto.SkuDTO;
import com.metea.ordermanagementservice.dto.SkuDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface SkuClientService {
    SkuDTO getSkuById(Long skuId);

    Page<SkuDetailDTO> searchSkuDetail(SkuDetailDTO filter, Pageable pageable);
}
