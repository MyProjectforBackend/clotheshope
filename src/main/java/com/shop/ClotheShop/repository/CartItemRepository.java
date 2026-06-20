package com.shop.ClotheShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ClotheShop.dto.CartDTO;

public interface CartItemRepository extends JpaRepository<CartDTO, Integer> {
    List<CartDTO> findByCart_Id(Integer cartId);
}
