package com.myapp.service;

import com.myapp.model.OrderLine;

import java.util.List;

public interface OrderLineToppingService {
    List<String> getToppingsForGivenOrderLineId(String orderLineId);

    void insertToppingsForGivenOrderLineId(OrderLine orderLine);

    void deleteToppingsForGivenOrderLineId(String orderLineId);

}




