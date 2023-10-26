package com.myapp.repository;

import com.myapp.model.PizzaPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PizzaPriceRepository {
    List<PizzaPrice> getPizzaPriceDetails();

}
