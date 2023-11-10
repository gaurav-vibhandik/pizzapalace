package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.OrderLine;
import com.myapp.repository.OrderLineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository olRepo;

    @Autowired OrderLineToppingService olToppingService;

    private final Logger logger = LoggerFactory.getLogger("com.myapp.controller.OrderController.file") ;


    //===============================================================================================

    @Override
    public void createNewOrderLine(OrderLine orderLine) {
        try{
            logger.debug("OrderLine request received with data : {}",orderLine.toString());
            olRepo.createNewOrderLine(orderLine);
            //handling toppingList is empty
            logger.debug("orderLine entry created in DB with id={}",orderLine.getOrderLineId());
            logger.debug("Processing ToppingList if any:");
            if(!orderLine.getToppingList().isEmpty()) {
                //if not empty , populate ol_topping table for given orderLineId
                olToppingService.insertToppingsForGivenOrderLine(orderLine);
            }
            logger.debug("OrderLine has been created with its toppingList");
            //orderLine with or without toppings has been created
        }catch (DataAccessException e){
            logger.error("Failed to create orderLine due to error:\n{}",e.getCause().getMessage());
            throw e ;
        }
    }

    @Override
    public List<OrderLine> fetchOrderLinesByOrderId(String oId) {
        List<OrderLine> orderLineList ;
        try {
            orderLineList = olRepo.fetchOrderLinesByOrderId(oId);
            for (OrderLine ol : orderLineList) {
                List<String> toppingListForGivenOrderLine = olToppingService.getToppingsForGivenOrderLineId(ol.getOrderLineId());
                ol.setToppingList(toppingListForGivenOrderLine);
            }

        }catch(DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch orderLine details.Invalid orderId", HttpStatus.NOT_FOUND) ;
        }
        return orderLineList;
    }

    @Override
    public void updateOrderLine(OrderLine newOl) {
        try{
            logger.debug("In process:Updating orderLineId={}", newOl.getOrderLineId());
            olRepo.updateOrderLine(newOl);
            //deleting the toppings from  ol_topping table
            olToppingService.deleteToppingsForGivenOrderLineId(newOl.getOrderLineId());
            //setting new ol_topping data for given new orderLine
            if (!newOl.getToppingList().isEmpty()) {
                olToppingService.insertToppingsForGivenOrderLine(newOl);
            }
            logger.debug("Finished:Updated orderLineId={}", newOl.getOrderLineId());
        }catch(DataAccessException e){
            logger.error("Failed to update orderLineId={} due to error :\n{}",newOl.getOrderLineId(),e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch orderLine details.Invalid orderId", HttpStatus.NOT_FOUND) ;
        }
    }

    @Override
    public void deleteOrderLineByOrderId(String oId) {
        logger.debug("Delete request received for orderLines having orderId={}",oId);
        try{
            int deletedRows = olRepo.deleteOrderLineByOrderId(oId);

            if (deletedRows == 0) {
                throw new CustomException("Invalid order id",
                        "No orderLines were found for given orderId", HttpStatus.NOT_FOUND);
            }
            logger.debug("Successfully deleted orderLines having orderId={} ",oId);
        }catch(DataAccessException e){
            logger.error("Failed to delete orderLines having orderId ={} due to error:\n{}",oId,e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch orderLine details.Invalid orderId", HttpStatus.NOT_FOUND) ;
        }

    }
    @Override
    public void deleteOrderLineById(String olId) {
        logger.debug("Delete request received for orderLineId={}",olId);
        int deletedRows = olRepo.deleteOrderLineById(olId);
        if(deletedRows == 0){
            logger.error("Failed to delete orderLine due to invalid orderLineId ={}",olId);
            throw new CustomException("Invalid orderLineId",
                    "Failed to delete orderLine ", HttpStatus.NOT_FOUND) ;
        }
        logger.debug("Successfully deleted orderLineId={}",olId);
    }


}
