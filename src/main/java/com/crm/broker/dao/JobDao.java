package com.crm.broker.dao;

import com.crm.broker.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends JpaRepository<Job,Long> {
    Job findByJobId(Long id);
}
