package com.metea.ordermanagementservice.dto;

import com.metea.ordermanagementservice.domain.OrderMaster;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
public class OrderMasterReadDTO extends OrderMasterWriteDTO {
    private Long id;
    private BigDecimal amount;
    private OrderMaster.OrderStatus status;
}
