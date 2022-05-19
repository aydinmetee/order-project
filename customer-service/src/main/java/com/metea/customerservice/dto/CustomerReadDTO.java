package com.metea.customerservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
public class CustomerReadDTO extends CustomerWriteDTO {
    private Long id;
    private Boolean valid;
}
