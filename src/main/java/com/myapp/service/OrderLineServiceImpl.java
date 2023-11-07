package com.myapp.service;

import com.myapp.exception.CustomException;
import com.myapp.model.OrderLine;
import com.myapp.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository olRepo;

    @Autowired OrderLineToppingService olToppingService;

    //===============================================================================================
    @Override
    public void createNewOrderLine(OrderLine orderLine) {

        olRepo.createNewOrderLine(orderLine);
        //handling toppingList is empty
        if(orderLine.getToppingList().size()> 0) {
            //if not empty , populate ol_topping table for given orderLineId
            olToppingService.insertToppingsForGivenOrderLineId(orderLine);
        }
        //orderLine with or without toppings has been created
    }

    @Override
    public List<OrderLine> fetchOrderLinesByOrderId(String oId) {
        List<OrderLine> orderLineList ;
        try {
            orderLineList = olRepo.fetchOrderLinesByOrderId(oId);
            for (OrderLine ol : orderLineList) {
                List<String> toppingListForGivenOrderLine = olToppingService.getToppingsForGivenOrderLineId(ol.getOrderLineId());
                ol.setToppingList(toppingListForGivenOrderLine);
            }

        }catch(DataAccessException e){
            throw new CustomException(e.getCause().getMessage(),"Failed to fetch orderLine details.Invalid orderId", HttpStatus.NOT_FOUND) ;
        }
        return orderLineList;
    }

    @Override
    public void deleteOrderLineByOrderId(String oId) {
        int deletedRows = olRepo.deleteOrderLineByOrderId(oId);
        /*//No need to check for validation of oId because OLMethods will be always followed
        after OrderMethods in which we check validity of oId
        if(deletedRows == 0){
            throw new CustomException("Invalid order id","orderlines data not deleted", HttpStatus.NOT_FOUND) ;
        }*/

    }


}
