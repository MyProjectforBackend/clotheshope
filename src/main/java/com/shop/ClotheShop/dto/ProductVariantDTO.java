package com.shop.ClotheShop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductVariantDTO {
    private String sku;
    private String size;
    private String color;
    private int quantity;
    private int productId;

    // add setter and getter for all fields
    // add constructor with all fields
    // add constructor with no fields
}
