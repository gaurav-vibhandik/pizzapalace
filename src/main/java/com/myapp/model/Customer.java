package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "{orders}")
@Validated
public class Customer {

    private String customerId ;
    @NotNull(message = "firstName is mandatory")
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" ,message = "Email is not valid")
    private String emailAddress;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Order> orders ;







}
