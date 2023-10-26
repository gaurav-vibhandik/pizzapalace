package com.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaPrice {

    private String pizzaId ;
    private String crustId;
    private Size pizzaSize;
    private Float price ;
}
