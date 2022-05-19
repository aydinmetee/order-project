package com.metea.ordermanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
public class OrderDetailWriteDTO {
    private Long orderMasterId;
    private Long skuId;
    private Long quantity;
    private BigDecimal value;
}
