package com.myapp.controller;


import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.model.Crust;
import com.myapp.model.Pizza;
import com.myapp.service.CrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CrustController {

    @Autowired
    private CrustService crustService;

    @GetMapping("/crust")
    public ResponseEntity<?> getAllCrustDetails(){
        List<Crust> fetchedList =  crustService.getAllCrustDetails();
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setData(new GenericData<Crust>());
        resp.getData().setList(fetchedList);
        resp.setSuccess(true);
        resp.setMessage("Crust Details Found");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);

    }

}
