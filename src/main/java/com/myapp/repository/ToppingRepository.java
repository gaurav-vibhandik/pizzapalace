package com.myapp.repository;


import com.myapp.model.Crust;
import com.myapp.model.Topping;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ToppingRepository {

    List<Topping> getToppingDetails();


}
