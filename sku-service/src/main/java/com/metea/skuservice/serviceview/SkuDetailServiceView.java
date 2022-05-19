package com.metea.skuservice.serviceview;

import com.metea.skuservice.dto.SkuDetailReadDTO;
import com.metea.skuservice.dto.SkuDetailSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuDetailWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
public interface SkuDetailServiceView {
    SkuDetailReadDTO create(SkuDetailWriteDTO skuDetailWriteDTO);

    SkuDetailReadDTO update(Long id, SkuDetailWriteDTO skuDetailWriteDTO);

    SkuDetailReadDTO delete(Long id);

    SkuDetailReadDTO getById(Long id);

    Page<SkuDetailReadDTO> search(SkuDetailSearchCriteriaDTO filter, Pageable pageable);

}
