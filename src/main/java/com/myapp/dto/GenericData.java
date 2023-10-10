package com.myapp.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenericData<T> {
    private List<T> list = new ArrayList<>() ;
}
