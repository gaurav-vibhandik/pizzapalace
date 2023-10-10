package com.myapp.repository;

import com.myapp.model.Pizza;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PizzaRepository {
//   public Pizza addNewPizza(@Param("p") Pizza pizza);
   public void addNewPizza(@Param("p") Pizza pizza);
   public Pizza fetchPizzaDetailsById(@Param("pId") String pId);
   public List<Pizza> fetchAllPizzaDetails();

   public int updatePizzaDetailsById(@Param("pizzaId") String pId, @Param("p")Pizza pizza) ;


   int deletePizzaDetailsById(@Param("pId") String pId);
}