package com.myapp.exception;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomErrorWithMap {
    private int code ;
    private Map<String,String> message = new HashMap<>();
}
