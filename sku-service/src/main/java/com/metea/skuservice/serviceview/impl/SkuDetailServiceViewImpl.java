package com.metea.skuservice.serviceview.impl;

import com.metea.skuservice.domain.SkuDetail;
import com.metea.skuservice.dto.SkuDetailReadDTO;
import com.metea.skuservice.dto.SkuDetailSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuDetailWriteDTO;
import com.metea.skuservice.service.SkuDetailService;
import com.metea.skuservice.serviceview.SkuDetailServiceView;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
@Service
@RequiredArgsConstructor
public class SkuDetailServiceViewImpl implements SkuDetailServiceView {

    private final ModelMapper modelMapper;
    private final SkuDetailService skuDetailService;

    @Override
    public SkuDetailReadDTO create(SkuDetailWriteDTO skuDetailWriteDTO) {
        return convertToDTO(skuDetailService.create(skuDetailWriteDTO));
    }

    @Override
    public SkuDetailReadDTO update(Long id, SkuDetailWriteDTO skuDetailWriteDTO) {
        return convertToDTO(skuDetailService.update(id, skuDetailWriteDTO));
    }

    @Override
    public SkuDetailReadDTO delete(Long id) {
        return convertToDTO(skuDetailService.delete(id));
    }

    @Override
    public SkuDetailReadDTO getById(Long id) {
        return convertToDTO(skuDetailService.getById(id));
    }

    @Override
    public Page<SkuDetailReadDTO> search(SkuDetailSearchCriteriaDTO filter, Pageable pageable) {
        return skuDetailService.search(filter, pageable).map(this::convertToDTO);
    }

    private SkuDetailReadDTO convertToDTO(SkuDetail skuDetail) {
        final var skuDetailReadDTO = modelMapper.map(skuDetail, SkuDetailReadDTO.class);
        skuDetailReadDTO.setSkuMasterId(skuDetail.getSkuMaster().getId());
        skuDetailReadDTO.setCode(skuDetail.getSkuMaster().getCode());
        skuDetailReadDTO.setName(skuDetail.getSkuMaster().getName());
        return skuDetailReadDTO;
    }
}
