package com.shop.ClotheShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ClotheShop.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByIdUser(Integer id);
}
