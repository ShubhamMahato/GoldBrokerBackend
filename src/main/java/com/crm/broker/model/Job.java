package com.crm.broker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    @Column
    private String jobType;
    @Column
    private String jobMaterial;
    @Column
    private String jobWeight;
    @Column
    private Long customerId;
    @Column
    private Long customerEmployee;
    @Column
    private Long amount;
    @Column
    private Long paidAmount;
    @Column
    private Long willNoPay;
    @Transient
    private String errorCode;
}
