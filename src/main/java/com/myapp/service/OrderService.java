package com.myapp.service;

import com.myapp.model.Order;

import java.util.List;

public interface OrderService {

    public void createNewOrder(Order order);
    public Order fetchOrderDetailsById(String oId);
    List<Order> fetchOrderDetailsByCustomerId(String customerId);

    public List<Order> fetchAllOrderDetails();

    public Order updateOrderDetails(String oId , Order order);

    public void deleteOrderDetails(String oId);

}
