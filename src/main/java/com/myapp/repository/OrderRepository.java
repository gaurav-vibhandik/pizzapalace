package com.myapp.repository;


import com.myapp.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
@Mapper
public interface OrderRepository {

    public int createNewOrder(@Param("o") Order order );

    public Order fetchOrderDetailsById(@Param("oId") String oId);

    public List<Order> fetchAllOrderDetails();

    public int updateOrderDetails(@Param("oId") String oId , @Param("o") Order order);

    public int deleteOrderDetails(@Param("oId") String oId);


    List<Order> fetchOrderDetailsByCustomerId(String customerId);


}
