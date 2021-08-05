package com.crm.broker.dao;

import com.crm.broker.model.CustomersEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerEmployeeDao extends JpaRepository<CustomersEmployee, Long> {
    CustomersEmployee findByEmployeeId(Long id);
    List<CustomersEmployee> findByCustomerId(Long customerId);
}
