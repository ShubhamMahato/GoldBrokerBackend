package com.crm.broker.dao;

import com.crm.broker.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
    Customer findByCustomerMobileNo(String customerMobileNo);
    Customer findByCustomerId(Long customerId);
}
