package com.myapp.repository;


import com.myapp.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderRepository {

    public void createNewOrder(@Param("o") Order order );

    public Order fetchOrderDetailsById(@Param("oId") String oId);

    public List<Order> fetchAllOrderDetails();

    public int updateOrderDetails(@Param("oId") String oId , @Param("o") Order order);

    public int deleteOrderDetails(@Param("oId") String oId);


    List<Order> fetchOrderDetailsByCustomerId(String customerId);


}
