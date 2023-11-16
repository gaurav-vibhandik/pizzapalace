package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.Order;
import com.myapp.model.OrderLine;
import com.myapp.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo ;
    @Autowired
    private OrderLineService olService ;

    private final Logger logger = LoggerFactory.getLogger("com.myapp.controller.OrderController.file") ;


    //=========================================================================================================
    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void createNewOrder(Order receivedOrder) {
        try{
            orderRepo.createNewOrder(receivedOrder);
            logger.debug("Order created in DB with orderId={}",receivedOrder.getOrderId());
            logger.debug("Processing OL lines entry into database :");
            List<OrderLine> receivedOrderLines = receivedOrder.getOrderLines();
            //populating respective OrderLines for received Order
            for (OrderLine ol : receivedOrderLines) {
                ol.setOrderId(receivedOrder.getOrderId());
                olService.createNewOrderLine(ol);
            }
        //order has been created and its associated OrderLine details also created
        }catch (DataAccessException e){
            logger.error("Failed to create order due to error:\n{}",e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to create new order", HttpStatus.BAD_REQUEST) ;
        }
    }

    @Override
    public Order fetchOrderDetailsById(String oId) {
        try {
            Order fetched = orderRepo.fetchOrderDetailsById(oId);
            if (fetched == null) {
                throw new CustomException("Invalid orderId", "Failed to fetch order data", HttpStatus.NOT_FOUND);
            }
            List<OrderLine> orderLines = olService.fetchOrderLinesByOrderId(oId);
            fetched.setOrderLines(orderLines);
            return fetched;
            }catch (DataAccessException e){
                throw new CustomException(e.getCause().getMessage(),"Failed to fetch order data", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

    @Override
    public List<Order> fetchOrderDetailsByCustomerId(String customerId) {
        try{
            List<Order> fetchedOrders = orderRepo.fetchOrderDetailsByCustomerId(customerId);
            if(fetchedOrders.isEmpty()){
                System.out.println("\n\n\n===========> fetchedOrders is Empty\n\n\n");
            }
            return fetchedOrders ;
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch order data for given customer id", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

    @Override
    public List<Order> fetchAllOrderDetails() {
        List<Order> orderList = orderRepo.fetchAllOrderDetails();

        if(orderList == null){
            throw new CustomException("Failed to fetch all orders data" , "Failed to fetch all orders data" ,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return orderList ;
    }


    @Override
    @Transactional(rollbackFor = {DataAccessException.class , CustomException.class})
    public Order updateOrderDetails(String oId , Order receivedOrder) {
        try{
            int updatedRows = orderRepo.updateOrderDetails(oId, receivedOrder);
            if (updatedRows != 1) {
                logger.error("Failed to update invalid orderId={}", oId);
                throw new CustomException("Invalid orderId", "Failed to update order data", HttpStatus.BAD_REQUEST);
            }
            logger.debug("orderId={} got updated in db", oId);
            List<OrderLine> oldOlList = olService.fetchOrderLinesByOrderId(oId);
            List<String> oldOlIdList =
                    oldOlList.stream()
                            .map(oldOrderLine -> oldOrderLine.getOrderLineId())
                            .toList();
            List<String> newOlIdList =
                    receivedOrder.getOrderLines().stream()
                            .map(OrderLine::getOrderLineId)
                            .toList();

            Map<String, OrderLine> newOrderLineMap = new HashMap<>();
            for (OrderLine ol : receivedOrder.getOrderLines()) {
                newOrderLineMap.put(ol.getOrderLineId(), ol);
            }

            for (String oldOlId : oldOlIdList) {
                if (newOlIdList.contains(oldOlId)) {
                    logger.debug("In Process: Updating orderLine for given orderId={}", oId);
                    //received orderLineList has old Ol , so update it
                    olService.updateOrderLine(newOrderLineMap.get(oldOlId));
                } else {
                    logger.debug("In Process: Deleting orderLine for given orderId={}", oId);
                    //received orderLineList does not have old Ol , so delete it
                    olService.deleteOrderLineById(oldOlId);
                }
            }
        }catch (DataAccessException e){
            logger.error("Failed to update orderId={} due to error:\n{}",oId,e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to delete order", HttpStatus.NOT_FOUND) ;
        }
        Order updatedOrder = orderRepo.fetchOrderDetailsById(receivedOrder.getOrderId());
        return updatedOrder ;

    }

    @Override
    @Transactional(rollbackFor={CustomException.class})
    public void deleteOrderDetails(String oId) {
        try {
           int deleted = orderRepo.deleteOrderDetails(oId);
           //OrderLines depending upon current orderId will also be deleted due to "ON DELETE CASCADE" on FK of OrderLine db table
           if(deleted!=1){
               logger.error("Failed to delete invalid orderId={}",oId);
               throw  new CustomException("invalid orderId","deletion failed",HttpStatus.NOT_FOUND) ;
           }
        }catch (DataAccessException e){
            logger.error("Failed to delete orderId={} due to error:\n{}",oId,e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to delete order", HttpStatus.NOT_FOUND) ;
        }
    }
}
