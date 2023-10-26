package com.myapp.repository;

import com.myapp.model.PizzaInventory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PizzaInventoryRepository {
    List<PizzaInventory> getPizzaInventoryDetails() ;

}
