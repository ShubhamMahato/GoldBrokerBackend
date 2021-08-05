package com.crm.broker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAndEmployeeResponse {
    private Customer customer;
    private List<CustomersEmployee> customersEmployeeList;
    private String errorCode;
}
