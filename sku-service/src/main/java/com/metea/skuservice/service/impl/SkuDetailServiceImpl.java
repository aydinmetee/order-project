package com.metea.skuservice.service.impl;

import com.metea.skuservice.domain.SkuDetail;
import com.metea.skuservice.dto.SkuDetailSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuDetailWriteDTO;
import com.metea.skuservice.repository.SkuDetailRepository;
import com.metea.skuservice.service.SkuDetailService;
import com.metea.skuservice.service.SkuService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
@Service
@RequiredArgsConstructor
public class SkuDetailServiceImpl implements SkuDetailService {

    private final SkuDetailRepository skuDetailRepository;
    private final ModelMapper modelMapper;
    private final SkuService skuService;

    @Override
    public SkuDetail create(SkuDetailWriteDTO skuDetailWriteDTO) {
        final var skuDetail = modelMapper.map(skuDetailWriteDTO, SkuDetail.class);
        final var skuMaster = skuService.getById(skuDetailWriteDTO.getSkuMasterId());
        if (Objects.isNull(skuMaster)) {
            throw new IllegalArgumentException("SKU MASTER NOT FOUND");
        }
        if (StringUtils.isEmpty(skuDetail.getStatus())) {
            skuDetail.setStatus(SkuDetail.SkuStatus.SCATHLESS);
        }
        skuDetail.setValid(true);
        skuDetail.setSkuMaster(skuMaster);

        return skuDetailRepository.save(skuDetail);
    }

    @Override
    public SkuDetail update(Long id, SkuDetailWriteDTO skuDetailWriteDTO) {
        final var updatedSkuDetail = skuDetailRepository.getOne(id);
        updatedSkuDetail.setQuantity(skuDetailWriteDTO.getQuantity());
        updatedSkuDetail.setValue(skuDetailWriteDTO.getValue());
        return skuDetailRepository.save(updatedSkuDetail);
    }

    @Override
    public SkuDetail delete(Long id) {
        final var skuDetail = skuDetailRepository.getOne(id);
        skuDetailRepository.deleteById(id);
        return skuDetail;
    }

    @Override
    public SkuDetail getById(Long id) {
        return skuDetailRepository.getOne(id);
    }

    @Override
    public Page<SkuDetail> search(SkuDetailSearchCriteriaDTO filter, Pageable pageable) {
        return skuDetailRepository.findAll(filter.SkuDetailSearchCriteriaFieldMapper(filter), pageable);
    }
}
