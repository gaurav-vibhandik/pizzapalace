package com.myapp.model;

import com.myapp.model.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrustInventory {
    private String crustId;

    private Size crustSize;
    private int quantity;

}
