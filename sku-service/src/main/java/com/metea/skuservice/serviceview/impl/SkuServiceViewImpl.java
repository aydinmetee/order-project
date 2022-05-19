package com.metea.skuservice.serviceview.impl;

import com.metea.skuservice.domain.Sku;
import com.metea.skuservice.dto.SkuReadDTO;
import com.metea.skuservice.dto.SkuSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuWriteDTO;
import com.metea.skuservice.service.SkuService;
import com.metea.skuservice.serviceview.SkuServiceView;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Mete Aydin
 * @since 17.10.2021
 */
@Service
@RequiredArgsConstructor
public class SkuServiceViewImpl implements SkuServiceView {

    private final ModelMapper modelMapper;
    private final SkuService skuService;

    @Override
    public SkuReadDTO create(SkuWriteDTO skuWriteDTO) {
        return convertToDTO(skuService.create(skuWriteDTO));
    }

    @Override
    public SkuReadDTO update(Long id, SkuWriteDTO skuWriteDTO) {
        return convertToDTO(skuService.update(id, skuWriteDTO));
    }

    @Override
    public SkuReadDTO delete(Long id) {
        return convertToDTO(skuService.delete(id));
    }

    @Override
    public SkuReadDTO getById(Long id) {
        return convertToDTO(skuService.getById(id));
    }

    @Override
    public Page<SkuReadDTO> search(SkuSearchCriteriaDTO filter, Pageable pageable) {
        return skuService.search(filter, pageable).map(this::convertToDTO);
    }

    private SkuReadDTO convertToDTO(Sku sku) {
        return modelMapper.map(sku, SkuReadDTO.class);
    }
}
