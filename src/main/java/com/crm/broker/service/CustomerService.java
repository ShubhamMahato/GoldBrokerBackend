package com.crm.broker.service;

import com.crm.broker.model.Customer;
import com.crm.broker.model.CustomerAndEmployeeResponse;

import java.util.List;

public interface CustomerService {
    Customer addNewCustomer(Customer customer);
    List<Customer> getAllCustomers();
    List<CustomerAndEmployeeResponse> getCustomerAndEmployeeResponses();
}
