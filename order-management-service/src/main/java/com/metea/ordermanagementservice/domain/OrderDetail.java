package com.metea.ordermanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "order_detail")
public class OrderDetail extends BaseEntity {
    @JoinColumn(name = "master_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderMaster orderMaster;
    @Column(name = "sku_id")
    private Long skuId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "value")
    private BigDecimal value;
}
