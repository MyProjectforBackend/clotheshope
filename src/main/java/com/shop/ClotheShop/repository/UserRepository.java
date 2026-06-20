package com.shop.ClotheShop.repository;

import java.util.Optional;

import com.shop.ClotheShop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByGmail(String gmail);

    Optional<User> findByUsername(String username);
}
