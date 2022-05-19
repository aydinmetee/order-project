package com.metea.skuservice.dto;

import com.metea.skuservice.domain.SkuDetail;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
@Getter
@Setter
public class SkuDetailWriteDTO {
    private Long skuMasterId;
    private Long quantity;
    private BigDecimal value;
    private SkuDetail.SkuStatus status;
}
