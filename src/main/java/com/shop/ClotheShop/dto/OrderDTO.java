package com.shop.ClotheShop.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {
    private int idOrder;
    private int idUser;
    private LocalDate orderDate;
    private double totalPrise;
    private int addressId;

    // add setter and getter for all fields
    // add constructor with all fields
    // add constructor with no fields

}
