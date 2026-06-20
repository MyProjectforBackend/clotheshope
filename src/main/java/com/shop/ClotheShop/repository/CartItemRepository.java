package com.shop.ClotheShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ClotheShop.domain.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCart_Id(Integer cartId);
}
