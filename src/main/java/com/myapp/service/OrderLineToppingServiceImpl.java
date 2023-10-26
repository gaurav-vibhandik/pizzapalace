package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.OrderLine;
import com.myapp.repository.OrderLineToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineToppingServiceImpl implements OrderLineToppingService {
    @Autowired
    OrderLineToppingRepository olToppingRepo ;

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
    public void insertToppingsForGivenOrderLineId(OrderLine orderLine) {
        try{
            olToppingRepo.insertToppingsForGivenOrderLineId(orderLine);
        }catch (DataAccessException e){
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
