package com.metea.skuservice.domain;

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
 * @date 17.10.2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "sku_det")
public class SkuDetail extends BaseEntity {
    @JoinColumn(name = "sku_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sku skuMaster;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "value")
    private BigDecimal value;
    @Column(name = "status")
    private SkuStatus status;


    public enum SkuStatus {
        DAMAGED,
        SCATHLESS
    }
}
