package com.crm.broker.controller;

import com.crm.broker.model.CustomersEmployee;
import com.crm.broker.model.request.CustomerEmployeeRequest;
import com.crm.broker.service.CustomerEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crm")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerEmployeeController {

    @Autowired
    CustomerEmployeeService customerEmployeeService;


    @PostMapping("/addemployee")
    public ResponseEntity<CustomersEmployee> addNewCustomerEmployee(@RequestBody CustomerEmployeeRequest customerEmployeeRequest){
        return ResponseEntity.ok().body(customerEmployeeService.addNewCustomerEmployee(customerEmployeeRequest));
    }
}
