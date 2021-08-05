package com.crm.broker.service.impl;

import com.crm.broker.dao.CustomerDao;
import com.crm.broker.dao.CustomerEmployeeDao;
import com.crm.broker.dao.JobDao;
import com.crm.broker.model.Customer;
import com.crm.broker.model.CustomersEmployee;
import com.crm.broker.model.ErrorCodes;
import com.crm.broker.model.Job;
import com.crm.broker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerEmployeeDao customerEmployeeDao;

    @Autowired
    SendSMS sendSMS;

    @Override
    public Job addNewJob(Job job) {
        if (job != null) {
            if (job.getCustomerId() != null && job.getCustomerEmployee() != null) {
                Customer customer = customerDao.findByCustomerId(job.getCustomerId());
                CustomersEmployee customersEmployee = customerEmployeeDao.findByEmployeeId(job.getCustomerEmployee());
                if (customer != null && customersEmployee != null) {
                    Job savedJob = jobDao.save(job);
//                    try {
////                        sendSMS.sendMessage(savedJob, customer, customersEmployee);
////                    } catch (Exception e) {
////                        return Job.builder().errorCode(ErrorCodes.PLEASE_CHECK_IF_GSM_MODEM_IS_ON).build();
////                    }
                    return savedJob;

                } else {
                    return Job.builder().errorCode(ErrorCodes.CUSTOMER_OR_EMPLOYEE_NOT_FOUND).build();
                }

            } else {
                return Job.builder().errorCode(ErrorCodes.PLEASE_PROVIDE_CUSTOMER_AND_EMPLOYEE_ID).build();
            }
        }
        return Job.builder().errorCode(ErrorCodes.ERROR_IN_INPUT).build();
    }
}
