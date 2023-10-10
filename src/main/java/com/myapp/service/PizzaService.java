package com.myapp.service;

import com.myapp.model.Pizza;

import java.util.List;

public interface PizzaService {

    void addNewPizza(Pizza pizza);

    Pizza fetchPizzaDetailsById(String pId);

    List<Pizza> fetchAllPizzaDetails();

    Pizza updatePizzaDetailsById(String pId, Pizza pizza);

    void deletePizzaDetailsById(String pId);
}
