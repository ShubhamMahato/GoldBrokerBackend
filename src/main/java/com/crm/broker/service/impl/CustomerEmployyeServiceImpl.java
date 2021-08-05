package com.crm.broker.service.impl;

import com.crm.broker.dao.CustomerDao;
import com.crm.broker.dao.CustomerEmployeeDao;
import com.crm.broker.model.Customer;
import com.crm.broker.model.CustomersEmployee;
import com.crm.broker.model.ErrorCodes;
import com.crm.broker.model.request.CustomerEmployeeRequest;
import com.crm.broker.service.CustomerEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEmployyeServiceImpl implements CustomerEmployeeService {
    @Autowired
    private
    CustomerEmployeeDao customerEmployeeDao;

    @Autowired
    private
    CustomerDao customerDao;

    @Override
    public CustomersEmployee addNewCustomerEmployee(CustomerEmployeeRequest customerEmployeeRequest) {

        if (customerEmployeeRequest != null) {
            Customer customer = customerDao.findByCustomerMobileNo(customerEmployeeRequest.getCustomerMobileNo());
            if (customer != null) {
                CustomersEmployee customersEmployee = CustomersEmployee.builder().
                                employeeName(customerEmployeeRequest.getEmployeeName()).
                                customerId(customer.getCustomerId()).
                                employeeMobileNumber(customerEmployeeRequest.getEmployeeMobileNumber()).
                                build();

                return customerEmployeeDao.save(customersEmployee);

            } else {
                return CustomersEmployee.builder().errorCode(ErrorCodes.CUSTOMER_NOT_FOUND).build();
            }
        }
        return CustomersEmployee.builder().errorCode(ErrorCodes.ERROR_IN_INPUT).build();
    }


}
