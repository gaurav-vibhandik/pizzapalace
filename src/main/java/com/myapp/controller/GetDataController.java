package com.myapp.controller;


import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.model.*;
import com.myapp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "http://localhost:3000")
public class GetDataController {

    @Autowired
    private DataService dataServiceImpl ;

    @GetMapping("/crust_inventory")
    public ResponseEntity getCrustInventoryDetails(){
        List<CrustInventory> list =  dataServiceImpl.getCrustInventoryDetails() ;
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setData(new GenericData<CrustInventory>());
        resp.getData().setList(list);
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched crust inventory details");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);
}

    @GetMapping("/pizza_inventory")
    public ResponseEntity getPizzaInventoryDetails(){
        List<PizzaInventory> list =  dataServiceImpl.getPizzaInventoryDetails() ;
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setData(new GenericData<PizzaInventory>());
        resp.getData().setList(list);
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched pizza inventory details");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);

    }

    @GetMapping("/pizza_price")
    public ResponseEntity getPizzaPriceDetails(){
        List<PizzaPrice> list =  dataServiceImpl.getPizzaPriceDetails() ;
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setData(new GenericData<Pizza>());
        resp.getData().setList(list);
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched PizzaPrice details");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);

    }

    @GetMapping("/topping")
    public ResponseEntity getToppingDetails(){
        List<Topping> list =  dataServiceImpl.getToppingDetails() ;
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setData(new GenericData<Topping>());
        resp.getData().setList(list);
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched topping details");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);
    }




}
