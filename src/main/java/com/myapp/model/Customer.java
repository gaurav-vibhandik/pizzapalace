package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
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
    @NotBlank(message = "firstName is required")
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    @NotBlank(message = "email is required")
    @Email(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$" ,message = "Email is empty or not valid.EmailName should not contain symbols other than . and _")
    private String emailAddress;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Order> orders ;
}
