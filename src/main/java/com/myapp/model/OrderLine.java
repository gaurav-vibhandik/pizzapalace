package com.myapp.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderLine {
    private String orderLineId;
    @NotNull
    private String orderId;
    @NotNull
    private String pizzaId;
    @NotNull
    private String size;
    @NotNull
    private int quantity;
    @NotNull
    private int totalPrice;


}
