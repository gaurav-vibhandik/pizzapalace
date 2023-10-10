package com.myapp.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomError {
    private int code ;
    private String message;
}
