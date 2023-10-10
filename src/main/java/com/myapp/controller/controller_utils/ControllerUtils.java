package com.myapp.controller.controller_utils;

import com.myapp.dto.GenericData;
import com.myapp.dto.SuccessResponseDto;
import com.myapp.model.Customer;
import com.myapp.model.Order;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ControllerUtils {

    /*public SuccessResponseDto returnSuccessResponseDto(){
        SuccessResponseDto resp = new SuccessResponseDto(String message , ?????  ,Object data);
        resp.setSuccess(true);
        resp.setMessage("Successfully created Order");
        resp.setData(new GenericData<Order>()); // ???????????
        resp.getData().getList().add(created);
        return null;
    }*/

    public static List<String> validateCustomerByExistingFields(Customer c) throws IllegalAccessException {
        Class<?> classReflection = c.getClass();
        List<String> failedValidations = new ArrayList<>() ;
        for (Field field : classReflection.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(c);
            // System.out.println(field.getName());
            String suffixError = "  is not valid.";
            if (value != null) {
                //System.out.println(field.getName() + ": " + value);
                //  System.out.println("For field: "+ value + " is it valid = " + isFieldValid(field.getName()));
                String fieldName = field.getName();
                if( ! isFieldValid(fieldName)){
                    failedValidations.add(fieldName + suffixError);
                }

            }
        }

        return failedValidations ;
    }

    private static boolean isFieldValid(String field) {

        switch (field){
            case "firstName":return !field.isBlank();

            case "lastName":return !field.isBlank();

            case "address":return !field.isBlank();

            case "phoneNumber":return !field.isBlank();

            case "emailAddress":return !field.isBlank() && field.matches("%@gmail.com$");

            default: return false;


        }
    }

}
