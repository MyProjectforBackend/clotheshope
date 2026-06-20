package com.shop.ClotheShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ClotheShop.domain.ProductVariant;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Integer> {
    List<ProductVariant> findByProductId(Integer productId);

    List<ProductVariant> findByColor(String color);
}
