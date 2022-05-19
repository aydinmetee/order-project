package com.metea.skuservice.service;

import com.metea.skuservice.domain.SkuDetail;
import com.metea.skuservice.dto.SkuDetailSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuDetailWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
public interface SkuDetailService {
    SkuDetail create(SkuDetailWriteDTO skuDetailWriteDTO);

    SkuDetail update(Long id, SkuDetailWriteDTO skuDetailWriteDTO);

    SkuDetail delete(Long id);

    SkuDetail getById(Long id);

    Page<SkuDetail> search(SkuDetailSearchCriteriaDTO filter, Pageable pageable);

}
