package com.myapp.service;

import com.myapp.model.Customer;

import java.util.List;


public interface CustomerService {

    void createNewCustomer(Customer customer);
    Customer fetchCustomerDetailsById(String cId);
    List<Customer> fetchAllCustomerDetails();

    public void updateCustomerDetails(String cId, Customer c);

    void deleteCustomerDetailsById(String cId);

    Customer fetchFullCustomerDetailsById(String customerId);
}
