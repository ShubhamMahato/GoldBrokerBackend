package com.crm.broker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long customerId;

    @Column
    private String customerName;

    @Column
    private String customerMobileNo;

    @Column
    private String customerShopName;


    @Transient
    private String errorCode;

}
