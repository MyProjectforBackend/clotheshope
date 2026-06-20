package com.shop.ClotheShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ClotheShop.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProduct_ProductId(Integer productId);

    List<Review> findByUser_Id(Integer idUser);
}
