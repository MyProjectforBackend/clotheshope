package com.shop.ClotheShop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    private String brand;

    // add setter and getter for all fields
    // add constructor with all fields
    // add constructor with no fields
}
