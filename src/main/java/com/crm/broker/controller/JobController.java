package com.crm.broker.controller;

import com.crm.broker.model.Job;
import com.crm.broker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crm")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/addjob")
    public ResponseEntity<Job> addNewJob(@RequestBody Job jobWork) {
        Job savedJob = jobService.addNewJob(jobWork);
        if (savedJob.getErrorCode() != null) {
            return ResponseEntity.ok(savedJob);
        } else {
            return ResponseEntity.badRequest().body(jobWork);
        }
    }
}
