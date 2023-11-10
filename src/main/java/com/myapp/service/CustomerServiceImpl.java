package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.Customer;
import com.myapp.model.Order;
import com.myapp.repository.CustomerRepository;
import com.myapp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImpl implements  CustomerService {

    @Autowired
    private CustomerRepository customerRepo ;

    @Autowired
    private OrderRepository orderRepo ;
    private Logger logger = LoggerFactory.getLogger("com.myapp.controller.CustomerController.file") ;

    //===========================================================================================================

    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void createNewCustomer(Customer customer) {
        try{
        customerRepo.createNewCustomer(customer);
        }catch (DataAccessException e){
            logger.error("Failed to create new customer due to error:\n{}",e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to create new customer", HttpStatus.BAD_REQUEST) ;
        }
    }

    @Override
    public Customer fetchCustomerDetailsById(String cId) {
        Customer fetched = customerRepo.fetchCustomerDetailsById(cId);
        if(fetched==null){
            throw new CustomException("Invalid customer id","Failed to fetch customer data", HttpStatus.NOT_FOUND);
        }
        return fetched ;
    }

    @Override
    public List<Customer> fetchAllCustomerDetails() {
        List<Customer> fetchedList ;
        fetchedList = customerRepo.fetchAllCustomerDetails();
        return fetchedList ;
    }

    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void updateCustomerDetails(String cId, Customer c) {
        try{
            int updatedRows = customerRepo.updateCustomerDetails(cId, c);
            if(updatedRows !=1){
                logger.error("Failed to update invalid customerId={} ",cId);
                throw new CustomException("Invalid customerId","Failed to Update Customer details",HttpStatus.BAD_REQUEST);
            }
        }catch (DataAccessException e){
            logger.error("Failed to update customerId={} dur to error:\n{} ",cId,e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to Update Customer details", HttpStatus.BAD_REQUEST) ;
        }

    }

    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void deleteCustomerDetailsById(String cId) {

        try {
            int deleted = customerRepo.deleteCustomerDetailsById(cId);
            if (deleted != 1) {
                logger.error("Failed to delete invalid customerId={} ",cId);
                throw new CustomException("Invalid customerId", "Failed to Delete Customer details", HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException e){
            logger.error("Failed to delete customerId={} due to error:\n{}",cId,e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to Delete Customer details", HttpStatus.BAD_REQUEST) ;
        }
    }

    @Override
    public Customer fetchFullCustomerDetailsById(String customerId) {
        try{
            Customer fetched = customerRepo.fetchCustomerDetailsById(customerId) ;
            if(fetched==null){
                throw new CustomException("Invalid customer id","Failed to fetch customer data", HttpStatus.NOT_FOUND);
            }
            List<Order> ordersOfFetched = orderRepo.fetchOrderDetailsByCustomerId(customerId);
            fetched.setOrders(ordersOfFetched);
            return  fetched ;
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch full Customer details", HttpStatus.BAD_REQUEST) ;
        }
    }

}
