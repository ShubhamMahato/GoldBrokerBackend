package com.crm.broker.service.impl;

import com.crm.broker.model.Customer;
import com.crm.broker.model.CustomersEmployee;
import com.crm.broker.model.Job;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Service
public class SendSMS {

    public void sendMessage(Job job, Customer customer, CustomersEmployee customersEmployee) throws Exception {

        if (customer != null && job != null && customersEmployee != null) {
            String message = "Hi " + customer.getCustomerName() + " your " + job.getJobMaterial() + " having weight "+job.getJobWeight()+" is submitted to us by your employee " +customersEmployee.getEmployeeName() +
                    " for " + job.getJobType() + " .Once done we will send sms for picking it up. Thanks for visiting us.";
            String customerPhoneNumber = customer.getCustomerMobileNo();
            String customerEmployeePhoneNumber = customersEmployee.getEmployeeMobileNumber();
            String username = "ganesh";
            String password = "12345";
            String address = "http://192.168.18.243";
            String port = "8090";

            URL url = new URL(
                    address + ":" + port + "/SendSMS?username=" + username + "&password=" + password +
                            "&phone=" + customerPhoneNumber + "&message=" + URLEncoder.encode(message, "UTF-8"));

            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
            bufferedReader.close();

            URL url1 = new URL(
                    address + ":" + port + "/SendSMS?username=" + username + "&password=" + password +
                            "&phone=" + customerEmployeePhoneNumber + "&message=" + URLEncoder.encode(message, "UTF-8"));

            URLConnection connection1 = url1.openConnection();
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream()));
            String inputLine1;
            while ((inputLine1 = bufferedReader1.readLine()) != null) {
                System.out.println(inputLine1);
            }
            bufferedReader1.close();
        } else if (customer != null && job != null && customersEmployee == null) {
            String message = "Hi " + customer.getCustomerName() + " your " + job.getJobMaterial() + " having weight "+job.getJobWeight()+" is submitted to us by you, " +
                    "for " + job.getJobType() + " .Once done we will send sms for picking it up. Thanks for visiting us.";
            String customerPhoneNumber = customer.getCustomerMobileNo();
            String username = "ganesh";
            String password = "12345";
            String address = "http://192.168.18.243";
            String port = "8090";

            URL url = new URL(
                    address + ":" + port + "/SendSMS?username=" + username + "&password=" + password +
                            "&phone=" + customerPhoneNumber + "&message=" + URLEncoder.encode(message, "UTF-8"));

            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
            bufferedReader.close();

        }
    }
}
