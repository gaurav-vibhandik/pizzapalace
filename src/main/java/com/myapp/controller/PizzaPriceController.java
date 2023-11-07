package com.myapp.controller;

import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.model.PizzaPrice;
import com.myapp.service.PizzaPriceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PizzaPriceController {

    @Autowired
    private PizzaPriceService pizzaPriceService;

    //=================================================================

    @PostMapping("/pizzaPrices")
    public ResponseEntity<?> createNewPizzaPrice(@RequestBody @Valid PizzaPrice receivedPizzaPrice){

        pizzaPriceService.createPizzaPrice(receivedPizzaPrice);

        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Successfully created PizzaPrice");
        resp.setData(new GenericData<PizzaPrice>());
        resp.getData().getList().add(receivedPizzaPrice);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }


    @GetMapping("/pizzaPrices")
    public ResponseEntity<?> fetchAllPizzaPriceDetails(){
        List<PizzaPrice> fetchedPizzaPriceList = pizzaPriceService.getPizzaPriceDetails();

        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched all PizzaPrice data");
        resp.setData(new GenericData<PizzaPrice>());
        resp.getData().setList(fetchedPizzaPriceList);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @PutMapping("/pizzaPrices/{pizzaPriceId}")
    public ResponseEntity<?> updatePizzaPriceDetailsById(@PathVariable("pizzaPriceId")  Integer ppId ,
                                                    @RequestBody @Valid PizzaPrice pizzaPrice){

        pizzaPriceService.updatePizzaPrice(ppId,pizzaPrice);
        PizzaPrice updated = pizzaPriceService.getPizzaPriceDetailsById(ppId);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("PizzaPrice data updated");
        resp.setData(new GenericData<PizzaPrice>());
        resp.getData().getList().add(updated);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @DeleteMapping("/pizzaPrices/{pizzaPriceId}")
    public ResponseEntity<?> deletePizzaPriceById(@PathVariable  Integer pizzaPriceId){

        pizzaPriceService.deletePizzaPrice(pizzaPriceId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
