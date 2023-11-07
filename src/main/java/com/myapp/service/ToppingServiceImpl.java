package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.Topping;
import com.myapp.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingServiceImpl implements ToppingService {

    @Autowired
    private ToppingRepository tpRepo ;
    @Override
    public void createTopping(Topping topping) {

        try{
            tpRepo.createTopping(topping);
        }catch(DataAccessException e){
            throw new CustomException(e.getLocalizedMessage(),"Failed to create new topping",HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public void updateTopping( String toppingId,Topping topping) {
        try {
            int count = tpRepo.updateTopping(toppingId, topping);
            if (count != 1) {
                throw new CustomException("Invalid ToppingId", "Failed to update topping", HttpStatus.BAD_REQUEST);
            }
        }catch(DataAccessException e){
            throw new CustomException(e.getLocalizedMessage(),"Failed to create new topping",HttpStatus.BAD_REQUEST);
    }
    }

    @Override
    public void deleteTopping(String toppingId) {
        int count = tpRepo.deleteTopping(toppingId);
        if(count!=1){
            throw new CustomException("Invalid ToppingId","Failed to delete topping", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Topping> getToppingDetails() {
        return tpRepo.getToppingDetails();
    }

    @Override
    public Topping getToppingDetailsById(String tpId) {
        return tpRepo.getToppingDetailsById(tpId);
    }
}
