package com.metea.ordermanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "order_master")
public class OrderMaster extends BaseEntity {
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "status")
    private OrderStatus status;


    public enum OrderStatus {
        NEW,
        COMPLETED
    }

}
