package com.myapp.service;

import com.myapp.model.Topping;

import java.util.List;

public interface ToppingService {

    void createTopping(Topping topping);

    void updateTopping(String toppingId ,Topping topping);
    void deleteTopping(String toppingId);
    List<Topping> getToppingDetails();
   Topping getToppingDetailsById(String tpId);

}
