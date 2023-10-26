package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Validated
public class Order {
    private String orderId;
    @NotBlank(message = "CustomerId is required")
    private String customerId;
    private String status ;
    @NotNull(message = "non-zero amount must be mentioned")
    private int totalAmount;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDateTime;
    @NotNull(message = "delivery address must be mentioned")
    private String deliveryAddress;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OrderLine> orderLines = new ArrayList<>();

//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private List<Side> sides = new ArrayList<>();

}
