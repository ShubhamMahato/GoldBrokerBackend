package com.crm.broker.service.impl;

import com.crm.broker.dao.CustomerDao;
import com.crm.broker.dao.CustomerEmployeeDao;
import com.crm.broker.model.Customer;
import com.crm.broker.model.CustomerAndEmployeeResponse;
import com.crm.broker.model.CustomersEmployee;
import com.crm.broker.model.ErrorCodes;
import com.crm.broker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerEmployeeDao customerEmployeeDao;

    @Override
    public Customer addNewCustomer(Customer customer) {
        if (customer != null) return customerDao.save(customer);
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerDao.findAll();
        if (!customers.isEmpty()) {
            return customers;
        }
        return Collections.singletonList(Customer.builder().errorCode(ErrorCodes.NO_CUSTOMER_FOUND).build());
    }

    @Override
    public List<CustomerAndEmployeeResponse> getCustomerAndEmployeeResponses() {
        List<Customer> customers = customerDao.findAll();
        if (customers.isEmpty()) {
            return Collections.singletonList(CustomerAndEmployeeResponse.builder().errorCode(ErrorCodes.NO_CUSTOMER_FOUND).build());
        }
        List<CustomerAndEmployeeResponse> customerAndEmployeeResponses = new ArrayList<>();
        customers.forEach(x -> {
            List<CustomersEmployee> employees = customerEmployeeDao.findByCustomerId(x.getCustomerId());
            if (employees != null && !employees.isEmpty()) {
                customerAndEmployeeResponses.add(CustomerAndEmployeeResponse.builder().
                        customersEmployeeList(employees).customer(x).build());
            } else {
                customerAndEmployeeResponses.add(CustomerAndEmployeeResponse.builder().
                        customersEmployeeList(Collections.singletonList(CustomersEmployee.builder().errorCode(ErrorCodes.NO_EMPLOYEE_FOUND).build()
                        )).customer(x).build());
            }

        });
        return customerAndEmployeeResponses;
    }


}
