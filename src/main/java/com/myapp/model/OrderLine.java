package com.myapp.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

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
    private String crustId ;

    @Nullable
    private boolean extraCheese ;

    @Nullable
    private List<String> toppingList ;

    @NotNull
    private int totalPrice;

}
