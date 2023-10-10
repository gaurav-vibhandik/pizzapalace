package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.Order;
import com.myapp.model.OrderLine;
import com.myapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo ;
    @Autowired
    private OrderLineService olService ;
    //=========================================================================================================
    @Override
    @Transactional(rollbackFor = {DataAccessException.class})
    public void createNewOrder(Order receivedOrder) {
        try{
            orderRepo.createNewOrder(receivedOrder);
            List<OrderLine> receivedOrderLines = receivedOrder.getOrderLines();
            //populating respective OrderLines for received Order
            for(OrderLine ol : receivedOrderLines){
                ol.setOrderId(receivedOrder.getOrderId());
                olService.createNewOrderLine(ol);
            }
        //order has been created and its associated OrderLine details also created
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to create new order", HttpStatus.NOT_FOUND) ;
        }
    }

    @Override
    public Order fetchOrderDetailsById(String oId) {

        Order fetched = orderRepo.fetchOrderDetailsById(oId) ;
        if(fetched == null){
            throw new CustomException("Invalid orderId" , "Failed to fetch order data" , HttpStatus.NOT_FOUND);
        }
        List<OrderLine> orderLines = olService.fetchOrderLinesByOrderId(oId);
        fetched.setOrderLines(orderLines);
        return fetched;

    }

    @Override
    public List<Order> fetchOrderDetailsByCustomerId(String customerId) {
        return orderRepo.fetchOrderDetailsByCustomerId(customerId) ;
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
    //consideration : From frontend we receive orderId and its respective orderLineIds also
        try{
            int rowsUpdated = orderRepo.updateOrderDetails(oId , receivedOrder);
            if(rowsUpdated != 1){
                throw  new CustomException("invalid orderId","Failed to update order",HttpStatus.BAD_REQUEST) ;
            }
            //Dropping previous orderLines associated with current order
            olService.deleteOrderLineByOrderId(oId);
            //reassigning new(same or added or removed) orderLines to current order
            List<OrderLine> receivedOrderLines =  receivedOrder.getOrderLines();
            for(OrderLine ol : receivedOrderLines){
                ol.setOrderId(oId);
                olService.createNewOrderLine(ol);
            }
            Order updated = orderRepo.fetchOrderDetailsById(oId);
            return updated ;
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to update order details", HttpStatus.NOT_FOUND) ;
        }

    }

    @Override
    @Transactional(rollbackFor = {DataAccessException.class , CustomException.class})
    public void deleteOrderDetails(String oId) {
        try {
           int deleted = orderRepo.deleteOrderDetails(oId);
           //OrderLines depending upon current orderId will also be deleted due to "ON DELETE CASCADE" on FK of OrderLine db table
           if(deleted!=1){
               throw  new CustomException("invalid orderId","deletion failed",HttpStatus.NOT_FOUND) ;
           }
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to delete order", HttpStatus.NOT_FOUND) ;
        }
    }
}
