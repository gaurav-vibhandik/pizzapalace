package com.myapp.controller;

import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.model.Customer;
import com.myapp.service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController{
    @Autowired
    private CustomerService customerService ;
    private Logger logger = LoggerFactory.getLogger("com.myapp.controller.CustomerController.file") ;

    //=================================================================


    @PostMapping("/customers")
    public ResponseEntity createNewCustomer(@RequestBody @Valid Customer customer){
        logger.info("New customer create request received with data = {}",customer);
        customerService.createNewCustomer(customer) ;
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Customer created");
        resp.setData(new GenericData<Customer>());
        resp.getData().getList().add(customer);
        logger.info("Customer entry added in db:{}",customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);

    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity fetchCustomerDetailsById(@PathVariable String customerId){
        Customer fetched =  customerService.fetchCustomerDetailsById(customerId);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Customer data found");
        resp.setData(new GenericData<Customer>());
        resp.getData().getList().add(fetched);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/customers")
    public ResponseEntity fetchAllCustomerDetails(){
        List<Customer> fetchedCustomerList = customerService.fetchAllCustomerDetails();

        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setData(new GenericData<Customer>());
        resp.getData().setList(fetchedCustomerList);
        resp.setMessage("Successfully fetched all customer data");
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @PutMapping("/customers/{customerId}")
    //In PUT request whole Customer object will be sent (with none or one or more fields changed)
    public ResponseEntity updateOrderDetailsById(@PathVariable("customerId")  String cId ,
                                                 @RequestBody @Valid Customer customer){
        logger.info("Customer update request received with data = {}",customer);
        //customer is validated by @Valid
        customerService.updateCustomerDetails(cId,customer);
        Customer updated = customerService.fetchCustomerDetailsById(cId);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Customer data updated");
        resp.setData(new GenericData<Customer>());
        resp.getData().getList().add(updated);
        logger.info("Customer details updated to new data :{}",updated);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity deleteCustomerDetailsById(@PathVariable("customerId")  String cId) {
        logger.info("Customer delete request received for customerId={}",cId);
        customerService.deleteCustomerDetailsById(cId);
        logger.info("Customer data with id {} deleted",cId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/customers/{customerId}/full")
    public ResponseEntity fetchFullCustomerDetailsById(@PathVariable  String customerId){
    Customer fetched =  customerService.fetchFullCustomerDetailsById(customerId);
    SuccessResponseDto resp = new SuccessResponseDto();
    resp.setSuccess(true);
    resp.setMessage("Full Customer data fetched");
    resp.setData(new GenericData<Customer>());
    resp.getData().getList().add(fetched);
    return ResponseEntity.status(HttpStatus.OK).body(resp);
    }


    
}
