package com.metea.customerservice.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
public class CustomerWriteDTO {
    private String name;
    private String surname;
    private Long legalId;
    private Long phone;
    private Boolean orderAuthorization;
}
