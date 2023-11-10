package com.myapp.service;


import com.myapp.exception.CustomException;
import com.myapp.model.Pizza;
import com.myapp.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService{

   @Autowired
   private PizzaRepository pizzaRepo ;

    private final Logger logger = LoggerFactory.getLogger("com.myapp.controller.PizzaController.logger") ;

   //========================================================================================
    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void addNewPizza(Pizza pizza){
        try {
            pizzaRepo.addNewPizza(pizza);
        }catch (DataAccessException e){
            logger.error("Failed to create new Pizza due to error :\n{}",e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to create new pizza entry",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Pizza fetchPizzaDetailsById(String pId) {
       Pizza fetchedPizza = pizzaRepo.fetchPizzaDetailsById(pId);
       if(fetchedPizza ==null) {
           throw new CustomException("Invalid pizzaId" , "Failed to fetch pizza data", HttpStatus.NOT_FOUND);
       }
       return fetchedPizza;
    }

    @Override
    public List<Pizza> fetchAllPizzaDetails() {
        try {
          //  throw new CustomException("Failed to fetch all pizza details","Failed to fetch pizza data", HttpStatus.BAD_REQUEST);
            return pizzaRepo.fetchAllPizzaDetails();
        }catch (Exception e){
            throw new CustomException("Failed to fetch all pizza details",
                    "Failed to fetch pizza data", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public Pizza updatePizzaDetailsById(String pId, Pizza pizza) {
        try{
            int rowsUpdated = pizzaRepo.updatePizzaDetailsById(pId, pizza);
            if (rowsUpdated != 1) {
                logger.error("Failed to update invalid pizzaId={}", pId);
                throw new CustomException("Invalid pizzaId", "Failed to update pizza data", HttpStatus.BAD_REQUEST);
            }
            Pizza updatedPizza = pizzaRepo.fetchPizzaDetailsById(pId);
            return  updatedPizza ;
        }catch (DataAccessException e){
            logger.error("Failed to update pizzaId={} due to error:\n{}",pId,e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to update pizza details", HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void deletePizzaDetailsById(String pId) {

        try{
            int deletedRows = pizzaRepo.deletePizzaDetailsById(pId);
            if (deletedRows != 1) {
                logger.error("Failed to delete invalid pizzaId={}",pId);
                throw new CustomException("Invalid pizza id", "Failed to delete pizza", HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException e){
            logger.error("Failed to delete pizzaId={} due to error:\n{}",pId,e.getCause().getMessage());
            throw new CustomException(e.getCause().getMessage(),"Failed to update pizza details", HttpStatus.BAD_REQUEST);
        }
    }


}
