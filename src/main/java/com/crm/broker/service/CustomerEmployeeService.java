package com.crm.broker.service;

import com.crm.broker.model.CustomersEmployee;
import com.crm.broker.model.request.CustomerEmployeeRequest;

public interface CustomerEmployeeService {
    CustomersEmployee addNewCustomerEmployee(CustomerEmployeeRequest customerEmployeeRequest);

}
