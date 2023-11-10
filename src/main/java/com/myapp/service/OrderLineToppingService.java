package com.myapp.service;

import com.myapp.model.OrderLine;

import java.util.List;

public interface OrderLineToppingService {
    List<String> getToppingsForGivenOrderLineId(String orderLineId);

    void insertToppingsForGivenOrderLine(OrderLine orderLine);

    void deleteToppingsForGivenOrderLineId(String orderLineId);

}




