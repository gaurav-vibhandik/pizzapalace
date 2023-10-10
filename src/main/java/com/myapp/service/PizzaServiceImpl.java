package com.myapp.service;


import com.myapp.exception.CustomException;
import com.myapp.model.Pizza;
import com.myapp.repository.PizzaRepository;
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

   //========================================================================================
    @Override
    @Transactional(rollbackFor = {DataAccessException.class})
    public void addNewPizza(Pizza pizza){
        try {
            pizzaRepo.addNewPizza(pizza);
        }catch (DataAccessException e){
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
    @Transactional(rollbackFor = {DataAccessException.class})
    public Pizza updatePizzaDetailsById(String pId, Pizza pizza) {

        int rowsUpdated = pizzaRepo.updatePizzaDetailsById(pId,pizza) ;
        if(rowsUpdated != 1) {
            throw new CustomException("Invalid pizzaId","Failed to update pizza data",HttpStatus.BAD_REQUEST) ;
        }
        Pizza updatedPizza = pizzaRepo.fetchPizzaDetailsById(pId);
        return  updatedPizza ;
    }


    @Override
    @Transactional(rollbackFor = {DataAccessException.class})
    public void deletePizzaDetailsById(String pId) {

       int deletedRows=pizzaRepo.deletePizzaDetailsById(pId);
       if(deletedRows!=1){
           throw new CustomException("Invalid pizza id","Failed to delete pizza",HttpStatus.NOT_FOUND);
       }
    }


}
