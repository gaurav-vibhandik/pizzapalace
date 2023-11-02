package com.myapp.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Topping {

    private String toppingId;

    @NotBlank(message = "topping name is empty")
    private String name	;
    @NotBlank(message = "topping type is empty")
    private String type;
    @Min(value = 0 , message = "Price can not be negative value")
    private Integer price;
    @Min(value = 0 , message = "Quantity can not be negative value")
    private Integer quantity;
}
