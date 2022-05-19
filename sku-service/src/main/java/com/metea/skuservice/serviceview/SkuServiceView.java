package com.metea.skuservice.serviceview;

import com.metea.skuservice.dto.SkuReadDTO;
import com.metea.skuservice.dto.SkuSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mete Aydin
 * @since 17.10.2021
 */
public interface SkuServiceView {
    SkuReadDTO create(SkuWriteDTO skuWriteDTO);

    SkuReadDTO update(Long id, SkuWriteDTO skuWriteDTO);

    SkuReadDTO delete(Long id);

    SkuReadDTO getById(Long id);

    Page<SkuReadDTO> search(SkuSearchCriteriaDTO filter, Pageable pageable);
}
