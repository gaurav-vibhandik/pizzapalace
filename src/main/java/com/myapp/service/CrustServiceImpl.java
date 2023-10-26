package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.Crust;
import com.myapp.repository.CrustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrustServiceImpl implements CrustService{

    @Autowired
    private CrustRepository crustRepo ;
    @Override
    public List<Crust> getAllCrustDetails() {
        try {
            return crustRepo.getAllCrustDetails();
        }catch (DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to get crust details", HttpStatus.NOT_FOUND) ;
        }
        catch (Exception e){

            throw new CustomException("Failed to fetch all crust details",
                    "Failed to fetch crust data", HttpStatus.BAD_REQUEST);
        }


    }
}
