package com.myapp.controller;

import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.exception.CustomException;
import com.myapp.model.Order;
import com.myapp.service.OrderLineService;
import com.myapp.service.OrderService;
import jakarta.validation.Valid;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class OrderController {

    @Autowired
    private OrderService orderService ;
    @Autowired
    private OrderLineService olService;


    private final Logger logger = LoggerFactory.getLogger("com.myapp.controller.OrderController.file") ;

    //=================================================================

    @PostMapping("/orders")
    public ResponseEntity<?> createNewOrder(@Valid @RequestBody Order receivedOrder){
        //creating new order along with its associated orderLines
        logger.info("====>Order request received with details:\n{}",receivedOrder );
        if(receivedOrder.getOrderLines().isEmpty()){
            logger.error("Failed to create order because no orderLines are present in received order.");
            throw new CustomException("No orderLines present in request order object","Failed to create new Order",HttpStatus.BAD_REQUEST);
        }
        orderService.createNewOrder(receivedOrder) ;
        Order created = orderService.fetchOrderDetailsById(receivedOrder.getOrderId());

        logger.info("<====Order created successfully with orderId {} ==> {}",created.getOrderId(),created);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Successfully created Order");
        resp.setData(new GenericData<Order>());
        resp.getData().getList().add(created);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> fetchOrderDetailsByOrderId(@PathVariable  String orderId){
        Order fetched =  orderService.fetchOrderDetailsById(orderId);
        fetched.setOrderLines(olService.fetchOrderLinesByOrderId(orderId));
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Order data found");
        resp.setData(new GenericData<Order>());
        resp.getData().getList().add(fetched);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/orders/customer/{customerId}")
    public ResponseEntity<?> fetchOrderDetailsByCustomerId(@PathVariable  String customerId){
        List<Order> fetchedOrderList =  orderService.fetchOrderDetailsByCustomerId(customerId);
        for(Order o : fetchedOrderList){
            o.setOrderLines(olService.fetchOrderLinesByOrderId(o.getOrderId()));
        }
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Order data for given customerId found");
        resp.setData(new GenericData<Order>());
        resp.getData().setList(fetchedOrderList);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> fetchAllOrderDetails(){
        List<Order> fetchedOrderList = orderService.fetchAllOrderDetails();
        for(Order fetchedOrder : fetchedOrderList){
            fetchedOrder.setOrderLines(olService.fetchOrderLinesByOrderId(fetchedOrder.getOrderId()));
        }
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched all Order data");
        resp.setData(new GenericData<Order>());
        resp.getData().setList(fetchedOrderList);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<?> updateOrderDetailsById(@PathVariable("orderId")  String oId , @RequestBody @Valid Order order){
        logger.info("====>Update request received for orderId={} with new order details:\n{}",oId, order);
        orderService.updateOrderDetails(oId, order);
        Order updated = orderService.fetchOrderDetailsById(oId);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Order data updated");
        resp.setData(new GenericData<Order>());
        resp.getData().getList().add(updated);
        logger.info("<====Order id={} successfully Updated To new details :{}", updated.getOrderId(), updated);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<?> deleteOrderById(@PathVariable  String orderId){
        logger.info("====>Delete request for orderId={}",orderId);
        orderService.deleteOrderDetails(orderId);
        logger.info("<==== Order id={} deleted successfully",orderId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
