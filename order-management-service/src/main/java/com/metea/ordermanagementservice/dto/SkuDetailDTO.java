package com.metea.ordermanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkuDetailDTO {
    private Long id;
    private Long skuMasterId;
    private Long quantity;
    private BigDecimal value;
}
