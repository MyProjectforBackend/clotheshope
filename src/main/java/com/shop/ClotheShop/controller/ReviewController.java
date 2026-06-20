package com.shop.ClotheShop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ClotheShop.dto.ReviewDTO;
import com.shop.ClotheShop.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/product/{productId}")
    public List<ReviewDTO> getReviewsByProduct(@PathVariable Integer productId) {
        return reviewService.getReviewsByProduct(productId);
    }

    @GetMapping("/user/{userId}")
    public List<ReviewDTO> getReviewsByUser(@PathVariable Integer userId) {
        return reviewService.getReviewsByUser(userId);
    }

    @PostMapping
    public ReviewDTO createReview(@RequestBody ReviewDTO dto) {
        return reviewService.createReview(dto);
    }

    @PutMapping("/{id}")
    public ReviewDTO updateReview(@PathVariable Integer id, @RequestBody ReviewDTO dto) {
        return reviewService.updateReview(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
    }
}
