package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Order {
    private String orderId;
    @NotBlank( message = "CustomerId is required")
    private String customerId;
    private String status ;
    @Min(value = 0 ,message = "Total amount can not be negative")
    private int totalAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss" )
    private LocalDateTime orderDateTime;
    @NotBlank(message = "delivery address must be mentioned")
    private String deliveryAddress;
    @NotEmpty(message = "In given order ,OrderLines are not present")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OrderLine> orderLines = new ArrayList<>();

//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private List<Side> sides = new ArrayList<>();

}
