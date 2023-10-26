package com.myapp.model;

import com.myapp.model.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaInventory {

    private String pizzaId;

    private Size pizzaSize;
    private int quantity;



}
