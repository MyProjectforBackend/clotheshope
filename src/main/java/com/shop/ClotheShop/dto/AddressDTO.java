package com.shop.ClotheShop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO {
    private int adressId;
    private int userId;
    private String city;
    private String country;

    // add setter and getter for all fields
    // add constructor with all fields
    // add constructor with no fields
}
