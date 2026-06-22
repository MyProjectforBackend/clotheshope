package com.shop.ClotheShop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ClotheShop.dto.CartDTO;
import com.shop.ClotheShop.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartDTO> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/user/{userId}")
    public CartDTO getCartByUser(@PathVariable Integer userId) {
        return cartService.getCartByUser(userId);
    }

    @PostMapping
    public CartDTO createCart(@RequestBody CartDTO dto) {
        return cartService.createCart(dto);
    }
}
