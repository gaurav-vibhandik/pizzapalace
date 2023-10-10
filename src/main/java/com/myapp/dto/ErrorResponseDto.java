package com.myapp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponseDto {
    private boolean success ;
    private String message;
    private Object error;

}

