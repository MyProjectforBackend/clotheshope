package com.shop.ClotheShop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartItemDTO {
    private int cartItemId;
    private int cartId;
    private int productVariantId;
    private int quantity;

    // add setter and getter for all fields
    // add constructor with all fields
    // add constructor with no fields
}
