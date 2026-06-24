package com.shop.ClotheShop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String gmail;
    private String password;
    private String role;
    private String phone;
    private Integer id;

    // add setter and getter for all fields
    // add constructor with all fields
    // add constructor with no fields
}
