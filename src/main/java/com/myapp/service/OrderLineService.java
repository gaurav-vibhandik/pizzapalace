package com.myapp.service;

import com.myapp.model.OrderLine;

import java.util.List;

public interface OrderLineService {

    public void createNewOrderLine(OrderLine orderLine);

    public List<OrderLine> fetchOrderLinesByOrderId(String oId);

    public void deleteOrderLineByOrderId(String oId);
}
