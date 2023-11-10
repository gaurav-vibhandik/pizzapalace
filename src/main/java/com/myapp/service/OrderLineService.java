package com.myapp.service;

import com.myapp.model.OrderLine;

import java.util.List;

public interface OrderLineService {

    public void createNewOrderLine(OrderLine orderLine);
    public void updateOrderLine(OrderLine newOl);

    public List<OrderLine> fetchOrderLinesByOrderId(String oId);

    public void deleteOrderLineByOrderId(String oId);

    void deleteOrderLineById(String olId);
}
