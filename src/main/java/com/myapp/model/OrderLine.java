package com.myapp.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderLine {
    private String orderLineId;
    @NotBlank(message = "orderId can not be empty")
    private String orderId;
    @NotBlank(message = "pizzaId can not be empty")
    private String pizzaId;
    @NotBlank(message = "size can not be empty")
    private String size;
    @Positive(message = "Quantity can not be negative")
    private int quantity;
    @NotBlank(message = "crustId can not be empty")
    private String crustId ;
    private boolean extraCheese ;
    @Nullable
    private List<String> toppingList ;
    @Positive(message = "Price must be greater than zero")
    private int totalPrice;

}
