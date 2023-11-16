package com.myapp.controller;

import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.model.Topping;
import com.myapp.model.Topping;
import com.myapp.service.ToppingService;
import com.myapp.service.ToppingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToppingController {

    @Autowired
    private ToppingService tpService;

    //=================================================================

    @PostMapping("/toppings")
    public ResponseEntity<?> createNewTopping(@RequestBody @Valid Topping receivedTopping){

        tpService.createTopping(receivedTopping);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Successfully created Topping");
        resp.setData(new GenericData<Topping>());
        resp.getData().getList().add(receivedTopping);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }


    @GetMapping("/toppings")
    public ResponseEntity<?> fetchAllToppingDetails(){
        List<Topping> fetchedToppingList = tpService.getToppingDetails();

        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched all Topping data");
        resp.setData(new GenericData<Topping>());
        resp.getData().setList(fetchedToppingList);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @PutMapping("/toppings/{toppingId}")
    public ResponseEntity<?> updateToppingDetailsById(@PathVariable("toppingId")  String tpId ,
                                                    @RequestBody @Valid Topping topping){

        tpService.updateTopping(tpId,topping);
        Topping updated = tpService.getToppingDetailsById(tpId);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Topping data updated");
        resp.setData(new GenericData<Topping>());
        resp.getData().getList().add(updated);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @DeleteMapping("/toppings/{toppingId}")
    public ResponseEntity<?> deleteToppingById(@PathVariable  String toppingId){

        tpService.deleteTopping(toppingId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
