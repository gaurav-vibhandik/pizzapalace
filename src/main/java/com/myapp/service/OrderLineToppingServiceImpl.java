package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.OrderLine;
import com.myapp.repository.OrderLineToppingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderLineToppingServiceImpl implements OrderLineToppingService {
    @Autowired
    private OrderLineToppingRepository olToppingRepo ;


   private final Logger logger = LoggerFactory.getLogger("com.myapp.controller.OrderController.file") ;

    @Override
    public List<String> getToppingsForGivenOrderLineId(String orderLineId) {
        try{
          return olToppingRepo.getToppingsForGivenOrderLineId(orderLineId);
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to get Toppings for given orderLineId",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void insertToppingsForGivenOrderLine(OrderLine orderLine) {
        try{
            olToppingRepo.insertToppingsForGivenOrderLineId(orderLine);
            logger.debug("For orderLineId={} toppingList added in db",orderLine.getOrderLineId());
        }catch (DataAccessException e){
            logger.error("For given orderLineId={} , Failed to add toppingList entry due to error :{}", orderLine.getOrderLineId(),e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to insert Toppings for given orderLineId",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void deleteToppingsForGivenOrderLineId(String orderLineId) {
        try{
            olToppingRepo.deleteToppingsForGivenOrderLineId(orderLineId);

        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to delete Toppings for given orderLineId",
                    HttpStatus.BAD_REQUEST);
        }
    }


}
