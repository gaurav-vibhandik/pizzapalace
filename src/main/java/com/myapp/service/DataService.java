package com.myapp.service;

import com.myapp.model.PizzaPrice;
import com.myapp.model.CrustInventory;
import com.myapp.model.PizzaInventory;
import com.myapp.model.Topping;

import java.util.List;

public interface DataService {
    List<CrustInventory> getCrustInventoryDetails();
    List<PizzaInventory> getPizzaInventoryDetails();
    List<PizzaPrice> getPizzaPriceDetails();

    List<Topping> getToppingDetails();

}
