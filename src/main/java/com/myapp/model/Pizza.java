package com.myapp.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Validated
public class Pizza {

    private String pizzaId;
    @NotBlank(message = "Pizza name should not be empty")
    private String name;
    private String description;
    private PizzaType type;
    private String imageUrl;

}
