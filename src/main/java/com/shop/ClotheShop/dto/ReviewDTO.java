package com.shop.ClotheShop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDTO {
    private int reviewId;
    private int userId;
    private int productId;
    private String comment;
    private int rating;

    // add setter and getter for all fields
    // add constructor with all fields
    // add constructor with no fields
}
