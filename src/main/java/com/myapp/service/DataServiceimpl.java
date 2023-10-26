package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.PizzaPrice;
import com.myapp.model.CrustInventory;
import com.myapp.model.PizzaInventory;
import com.myapp.model.Topping;
import com.myapp.repository.CrustInventoryRepository;
import com.myapp.repository.PizzaInventoryRepository;
import com.myapp.repository.PizzaPriceRepository;
import com.myapp.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceimpl implements  DataService{

    @Autowired
    private CrustInventoryRepository crustInventoryRepo ;

    @Autowired
    private PizzaInventoryRepository pizzaInventoryRepo;

    @Autowired
    private PizzaPriceRepository pizzaPriceRepo;

    @Autowired
    private ToppingRepository toppingRepo ;

    @Override
    public List<CrustInventory> getCrustInventoryDetails() {
        try {
            return crustInventoryRepo.getCrustInventoryDetails();
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to get Crust Inventory details", HttpStatus.NOT_FOUND) ;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new CustomException(e.getMessage(),"Failed to get Crust Inventory details", HttpStatus.NOT_FOUND) ;
        }
    }

    @Override
    public List<PizzaInventory> getPizzaInventoryDetails() {
        try {
            return pizzaInventoryRepo.getPizzaInventoryDetails();
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to get Pizza Inventory details", HttpStatus.NOT_FOUND) ;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new CustomException(e.getMessage(),"Failed to get Pizza Inventory details", HttpStatus.NOT_FOUND) ;
        }
    }

    @Override
    public List<PizzaPrice> getPizzaPriceDetails() {
        try {
            return pizzaPriceRepo.getPizzaPriceDetails();
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to get Pizza price details", HttpStatus.NOT_FOUND) ;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new CustomException(e.getMessage(),"Failed to get Pizza Price details", HttpStatus.NOT_FOUND) ;
        }
    }


    @Override
    public List<Topping> getToppingDetails(){
        try {
            return toppingRepo.getToppingDetails();
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to get Pizza price details", HttpStatus.NOT_FOUND) ;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new CustomException(e.getMessage(),"Failed to get Pizza Price details", HttpStatus.NOT_FOUND) ;
        }

    }

}
