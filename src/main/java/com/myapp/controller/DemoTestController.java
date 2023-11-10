package com.myapp.controller;


import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class DemoTestController {

    @GetMapping("/test/{id}")
    public ResponseEntity<?> testPathVariable(@Min(1) @PathVariable("id")int id){
          return ResponseEntity.ok("valid");
    }

}
