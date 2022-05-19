package com.metea.skuservice.service.impl;

import com.metea.skuservice.domain.Sku;
import com.metea.skuservice.dto.SkuSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuWriteDTO;
import com.metea.skuservice.repository.SkuRepository;
import com.metea.skuservice.service.SkuService;
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
public class SkuServiceImpl implements SkuService {

    private final SkuRepository skuRepository;
    private final ModelMapper modelMapper;

    @Override
    public Sku create(SkuWriteDTO skuWriteDTO) {
        final var sku = modelMapper.map(skuWriteDTO, Sku.class);
        sku.setValid(true);
        return skuRepository.save(sku);
    }

    @Override
    public Sku update(Long id, SkuWriteDTO skuWriteDTO) {
        final var updatedSku = skuRepository.getOne(id);
        updatedSku.setName(skuWriteDTO.getName());
        updatedSku.setCode(skuWriteDTO.getCode());
        return skuRepository.save(updatedSku);
    }

    @Override
    public Sku delete(Long id) {
        final var deletedSku = skuRepository.getOne(id);
        skuRepository.deleteById(id);
        return deletedSku;
    }

    @Override
    public Sku getById(Long id) {
        return skuRepository.getOne(id);
    }

    @Override
    public Page<Sku> search(SkuSearchCriteriaDTO filter, Pageable pageable) {
        return skuRepository.findAll(filter.SkuSearchCriteriaFieldMapper(filter), pageable);
    }
}
