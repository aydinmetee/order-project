package com.metea.ordermanagementservice.dto;

import com.metea.ordermanagementservice.domain.OrderDetail;
import com.metea.ordermanagementservice.domain.OrderMaster;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mete Aydin
 * @date 23.10.2021
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderMasterCalculateDTO {
    private OperationType type;
    private OrderDetail orderDetail;
    private OrderMaster orderMaster;

    public enum OperationType {
        CREATE,
        DELETE
    }
}
