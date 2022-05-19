package com.metea.skuservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
@Getter
@Setter
public class SkuReadDTO extends SkuWriteDTO {
    private Long id;
    private Boolean valid;
}
