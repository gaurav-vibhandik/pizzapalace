package com.myapp.controller;

import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.model.Pizza;
import com.myapp.service.PizzaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;
    private Logger loggerConsole = LoggerFactory.getLogger("com.myapp.controller.PizzaController.loggerConsole") ;
    private Logger loggerFile = LoggerFactory.getLogger("com.myapp.controller.PizzaController.loggerFile") ;

    @PostMapping("/pizzas")
    public ResponseEntity<?> addNewPizza( @Valid @RequestBody Pizza pizza) {
        pizzaService.addNewPizza(pizza);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setSuccess(true);
        resp.setMessage("Successfully created pizza");
        resp.setData(new GenericData<Pizza>());
        resp.getData().getList().add(pizza);
        //loggerConsole.info("pizza created in console");
        loggerFile.info("Pizza created with id= {}",pizza.getPizzaId());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);

    }

    @GetMapping("/pizzas/{pizzaId}")
    public ResponseEntity<?> fetchPizzaDetailsById(@PathVariable("pizzaId") String pId){
        Pizza fetchedPizza =  pizzaService.fetchPizzaDetailsById(pId);
        SuccessResponseDto resp = new SuccessResponseDto();;resp.setData(new GenericData<Pizza>());
        resp.getData().getList().add(fetchedPizza);
        resp.setSuccess(true);
        resp.setMessage("PizzaData found");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);

    }

    @GetMapping("/pizzas")
    public ResponseEntity<?> fetchAllPizzaDetails(){
        List<Pizza> fetchedPizzaList = pizzaService.fetchAllPizzaDetails();
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setData(new GenericData<Pizza>());
        resp.getData().setList(fetchedPizzaList);
        resp.setSuccess(true);
        resp.setMessage("Successfully fetched pizza details");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);

    }

    @PutMapping("/pizzas/{pizzaId}")
    public ResponseEntity<?> updatePizzaDetailsById(@PathVariable("pizzaId") String pId ,
                                                    @Valid @RequestBody Pizza pizza) {
        Pizza updatedPizza = pizzaService.updatePizzaDetailsById(pId, pizza);
        SuccessResponseDto resp = new SuccessResponseDto();
        resp.setData(new GenericData<Pizza>());
        resp.getData().getList().add(updatedPizza);
        resp.setSuccess(true);
        resp.setMessage("Successfully updated pizza details");
        loggerFile.info("Pizza with id={} updated to new details : {}",pId,updatedPizza.toString());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);
    }

    @DeleteMapping("/pizzas/{pizzaId}")
    public ResponseEntity<?> deletePizzaDetailsById(@PathVariable("pizzaId") String pId){
        pizzaService.deletePizzaDetailsById(pId);
        loggerFile.info("Pizza with id={} has been deleted",pId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
