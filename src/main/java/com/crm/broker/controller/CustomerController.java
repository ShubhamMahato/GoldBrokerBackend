package com.crm.broker.controller;

import com.crm.broker.model.Customer;
import com.crm.broker.model.CustomerAndEmployeeResponse;
import com.crm.broker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crm")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addNewCustomer(customer));
    }
    @GetMapping("getcustomers")
    public ResponseEntity<List<Customer>> gtAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("getcustomersandemployees")
    public ResponseEntity<List<CustomerAndEmployeeResponse>> getCustomerAndCustomerEmplpyee(){
        return ResponseEntity.ok(customerService.getCustomerAndEmployeeResponses());
    }
}
