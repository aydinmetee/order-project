package com.metea.skuservice.service;

import com.metea.skuservice.domain.Sku;
import com.metea.skuservice.dto.SkuSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
public interface SkuService {
    Sku create(SkuWriteDTO skuWriteDTO);

    Sku update(Long id, SkuWriteDTO skuWriteDTO);

    Sku delete(Long id);

    Sku getById(Long id);

    Page<Sku> search(SkuSearchCriteriaDTO filter, Pageable pageable);

}
