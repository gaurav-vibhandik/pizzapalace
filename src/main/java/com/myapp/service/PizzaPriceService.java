package com.myapp.service;

import com.myapp.model.PizzaPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PizzaPriceService {
    void createPizzaPrice(PizzaPrice pizzaPrice);

    void updatePizzaPrice(Integer id, PizzaPrice pizzaPrice);
    void deletePizzaPrice(Integer id);
    List<PizzaPrice> getPizzaPriceDetails();

    PizzaPrice getPizzaPriceDetailsById( Integer id);

}
