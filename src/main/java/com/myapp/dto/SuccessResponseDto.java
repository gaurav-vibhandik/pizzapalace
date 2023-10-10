package com.myapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SuccessResponseDto {
    private boolean success;
    private String message ;
    private GenericData data ;

}
