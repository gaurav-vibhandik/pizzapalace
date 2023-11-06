package com.myapp.repository;


import com.myapp.model.PizzaPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PizzaPriceRepository {

    int createPizzaPrice(@Param("pp")PizzaPrice pizzaPrice);

    int updatePizzaPrice( @Param("id") Integer id,@Param("pp")PizzaPrice pizzaPrice);
    int deletePizzaPrice(@Param("id")Integer id);
    List<PizzaPrice> getPizzaPriceDetails();

    PizzaPrice getPizzaPriceDetailsById( @Param("id") Integer id);


}
