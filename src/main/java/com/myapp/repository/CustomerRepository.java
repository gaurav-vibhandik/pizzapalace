package com.myapp.repository;


import com.myapp.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerRepository {

    public void createNewCustomer(@Param("c") Customer customer);
    public Customer fetchCustomerDetailsById(@Param("cId") String customerId);

    public List<Customer> fetchAllCustomerDetails();

    public int updateCustomerDetails(@Param("cId") String cId,@Param("c")Customer c);

    public int deleteCustomerDetailsById(@Param("cId") String cId);

    public String doesCustomerIdExist(@Param("customerId") String customerId);

}
