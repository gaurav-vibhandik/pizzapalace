package com.myapp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaPrice {
    private Integer id;
    @NotBlank(message = "pizzaId is empty")
    private String pizzaId ;
    @NotBlank(message = "crustId is empty")
    private String crustId;
    private Size pizzaSize;
    @Positive(message = "Price must be positive value")
    private Float price ;
}
