package com.shop.ClotheShop.repository;

import java.util.Optional;

import com.shop.ClotheShop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByIdUser(Integer id);
}
