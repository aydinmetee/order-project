package com.metea.ordermanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkuDTO {
    private Long id;
    private String name;
    private String code;
}
