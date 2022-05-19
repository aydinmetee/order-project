package com.metea.skuservice.controller;

import com.metea.skuservice.dto.SkuDetailReadDTO;
import com.metea.skuservice.dto.SkuDetailSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuDetailWriteDTO;
import com.metea.skuservice.dto.SkuReadDTO;
import com.metea.skuservice.dto.SkuSearchCriteriaDTO;
import com.metea.skuservice.dto.SkuWriteDTO;
import com.metea.skuservice.serviceview.SkuDetailServiceView;
import com.metea.skuservice.serviceview.SkuServiceView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
@RestController
@RequestMapping("/sku")
@RequiredArgsConstructor
public class SkuController {
    private final SkuServiceView skuService;
    private final SkuDetailServiceView skuDetailServiceView;

    @PostMapping()
    public ResponseEntity<SkuReadDTO> create(@RequestBody SkuWriteDTO sku) {
        return ResponseEntity.ok(skuService.create(sku));
    }

    @PutMapping("/{skuId}")
    public ResponseEntity<SkuReadDTO> update(@PathVariable("skuId") Long skuId, @RequestBody SkuWriteDTO sku) {
        return ResponseEntity.ok(skuService.update(skuId, sku));
    }

    @GetMapping("/{skuId}")
    public ResponseEntity<SkuReadDTO> getById(@PathVariable("skuId") Long skuId) {
        return ResponseEntity.ok(skuService.getById(skuId));
    }

    @DeleteMapping("/{skuId}")
    public ResponseEntity<SkuReadDTO> delete(@PathVariable("skuId") Long skuId) {
        return ResponseEntity.ok(skuService.delete(skuId));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<SkuReadDTO>> search(@RequestBody() SkuSearchCriteriaDTO filter,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(skuService.search(filter, PageRequest.of(page, size)));
    }

    @PostMapping("/{skuId}/detail")
    public ResponseEntity<SkuDetailReadDTO> createDetail(@PathVariable("skuId") Long skuId,
                                                         @RequestBody SkuDetailWriteDTO skuDetailWriteDTO) {
        skuDetailWriteDTO.setSkuMasterId(skuId);
        return ResponseEntity.ok(skuDetailServiceView.create(skuDetailWriteDTO));
    }

    @PutMapping("/{skuId}/detail/{detailId}")
    public ResponseEntity<SkuDetailReadDTO> updateDetail(@PathVariable("skuId") Long skuId, @PathVariable("detailId") Long detailId,
                                                         @RequestBody SkuDetailWriteDTO skuDetailWriteDTO) {
        skuDetailWriteDTO.setSkuMasterId(skuId);
        return ResponseEntity.ok(skuDetailServiceView.update(detailId, skuDetailWriteDTO));
    }

    @GetMapping("/{skuId}/detail/{detailId}")
    public ResponseEntity<SkuDetailReadDTO> getDetailById(@PathVariable("skuId") Long skuId, @PathVariable("detailId") Long detailId) {
        return ResponseEntity.ok(skuDetailServiceView.getById(detailId));
    }

    @DeleteMapping("/{skuId}/detail/{detailId}")
    public ResponseEntity<SkuDetailReadDTO> deleteDetail(@PathVariable("skuId") Long skuId, @PathVariable("detailId") Long detailId) {
        return ResponseEntity.ok(skuDetailServiceView.delete(detailId));
    }

    @PostMapping("/detail/search")
    public ResponseEntity<Page<SkuDetailReadDTO>> searchDetails(@RequestBody() SkuDetailSearchCriteriaDTO filter,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(skuDetailServiceView.search(filter, PageRequest.of(page, size)));
    }
}
