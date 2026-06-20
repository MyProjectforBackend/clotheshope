package com.shop.ClotheShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.shop.ClotheShop.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByIdUser(Integer idUser);
}
