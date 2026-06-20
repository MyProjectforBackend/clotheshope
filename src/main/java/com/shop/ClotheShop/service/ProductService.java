package com.shop.ClotheShop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.shop.ClotheShop.domain.Product;
import com.shop.ClotheShop.dto.ProductDTO;
import com.shop.ClotheShop.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Integer id) {
        return productRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public ProductDTO createProduct(ProductDTO dto) {
        Product product = toEntity(dto);
        return toDTO(productRepository.save(product));
    }

    private ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setPrice(product.getPrice().doubleValue());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }

    private Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setPrice(BigDecimal.valueOf(dto.getPrice()));
        product.setImageUrl(dto.getImageUrl());
        return product;
    }
}
