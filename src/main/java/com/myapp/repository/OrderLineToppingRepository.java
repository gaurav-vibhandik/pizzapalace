package com.myapp.repository;

import com.myapp.model.OrderLine;
import com.myapp.model.OrderLineTopping;
import com.myapp.model.PizzaPrice;
import com.myapp.model.Topping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderLineToppingRepository {
List<String> getToppingsForGivenOrderLineId(@Param("olId") String orderLineId);

int insertToppingsForGivenOrderLineId(@Param("ol") OrderLine orderLine);

int deleteToppingsForGivenOrderLineId(@Param("olId") String orderLineId) ;


}