package com.crm.broker.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEmployeeRequest {

    private String customerMobileNo;

    private String employeeName;

    private String employeeMobileNumber;

}
