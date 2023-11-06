package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.PizzaPrice;
import com.myapp.repository.PizzaPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaPriceServiceImpl implements PizzaPriceService {

    @Autowired
    private PizzaPriceRepository pizzaPriceRepo ;
    @Override
    @Transactional(rollbackFor = {Exception.class,DataAccessException.class,CustomException.class})
    public void createPizzaPrice(PizzaPrice pizzaPrice) {

        try{
            pizzaPriceRepo.createPizzaPrice(pizzaPrice);
        }catch (DataAccessException e){
        throw new CustomException(e.getCause().getMessage(),"Failed to fetch pizzaPrice details", HttpStatus.NOT_FOUND) ;
    }

    }

    @Override
    public void updatePizzaPrice(Integer pizzaPriceId, PizzaPrice pizzaPrice) {
        try{
            int count = pizzaPriceRepo.updatePizzaPrice(pizzaPriceId, pizzaPrice);
            if (count != 1) {
                throw new CustomException("Invalid PizzaPriceId", "Failed to update pizzaPrice", HttpStatus.BAD_REQUEST);
            }
        }catch (DataAccessException e){
        throw new CustomException(e.getCause().getMessage(),"Failed to create new pizzaPrice", HttpStatus.NOT_FOUND) ;
    }

    }

    @Override
    public void deletePizzaPrice(Integer pizzaPriceId) {
        try{
            int count = pizzaPriceRepo.deletePizzaPrice(pizzaPriceId);
            if (count != 1) {
                throw new CustomException("Invalid PizzaPriceId", "Failed to delete pizzaPrice", HttpStatus.BAD_REQUEST);
            }
        }catch (DataAccessException e){
        throw new CustomException(e.getCause().getMessage(),"Failed to delete pizzaPrice", HttpStatus.NOT_FOUND) ;
    }
    }

    @Override
    public List<PizzaPrice> getPizzaPriceDetails() {

        try{
            return pizzaPriceRepo.getPizzaPriceDetails();
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch pizzaPrice details", HttpStatus.NOT_FOUND) ;
        }
    }

    @Override
    public PizzaPrice getPizzaPriceDetailsById(Integer id) {
        try{return pizzaPriceRepo.getPizzaPriceDetailsById(id);
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch pizzaPrice details", HttpStatus.NOT_FOUND) ;
        }
    }
}
