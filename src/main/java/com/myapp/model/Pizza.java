package com.myapp.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pizza {

    private String pizzaId;
    @NotNull
    private String name;
    private String description;
    private String type;
    private String imageUrl;

}
