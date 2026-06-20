package com.shop.ClotheShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ClotheShop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByBrand(Integer id);

    List<Product> findByCategory(Integer id);
}
