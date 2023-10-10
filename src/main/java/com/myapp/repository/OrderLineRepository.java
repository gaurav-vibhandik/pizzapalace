package com.myapp.repository;


import com.myapp.model.OrderLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderLineRepository {

    public void createNewOrderLine(@Param("ol") OrderLine orderLine );

    public OrderLine fetchOrderLineById(@Param("olId") String olId);

    public List<OrderLine> fetchOrderLinesByOrderId(@Param("oId") String oId);

    public List<OrderLine> fetchAllOrderLines();

    public int updateOrderLine(@Param("olId") String olId, @Param("ol") OrderLine orderLine );

    public int deleteOrderLine(@Param("olId") String olId);

    public int deleteOrderLineByOrderId(@Param("oId") String oId);



}
