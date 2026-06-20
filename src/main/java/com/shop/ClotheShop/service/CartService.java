package com.shop.ClotheShop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shop.ClotheShop.domain.Cart;
import com.shop.ClotheShop.dto.CartDTO;
import com.shop.ClotheShop.repository.CartRepository;

@Service
public class CartService {
    private CartRepository cartRepository;

    public List<CartDTO> getAllCarts() {
        return cartRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CartDTO getCartByUser(Integer userId) {
        return cartRepository.findByIdUser(userId).map(this::toDTO).orElse(null);
    }

    public CartDTO createCart(CartDTO dto) {
        Cart cart = toEntity(dto);
        return toDTO(cartRepository.save(cart));
    }

    private CartDTO toDTO(Cart cart) {
        CartDTO dto = new CartDTO();
        dto.setCartId(cart.getId());
        dto.setUserId(cart.getIdUser());
        return dto;
    }

    private Cart toEntity(CartDTO dto) {
        Cart cart = new Cart();
        cart.setIdUser(dto.getUserId());
        return cart;
    }
}
