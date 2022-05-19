package com.metea.ordermanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
public class OrderDetailReadDTO extends OrderDetailWriteDTO{
    private Long id;
    private Boolean valid;
}
