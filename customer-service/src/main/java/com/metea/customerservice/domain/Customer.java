package com.metea.customerservice.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "customer")
public class Customer extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "legal_id")
    private Long legalId;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "order_authorization")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean orderAuthorization;

}
