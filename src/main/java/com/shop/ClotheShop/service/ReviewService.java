package com.shop.ClotheShop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shop.ClotheShop.domain.Review;
import com.shop.ClotheShop.dto.ReviewDTO;
import com.shop.ClotheShop.repository.ReviewRepository;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsByProduct(Integer productId) {
        return reviewRepository.findByProduct_ProductId(productId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsByUser(Integer userId) {
        return reviewRepository.findByUser_Id(userId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ReviewDTO createReview(ReviewDTO dto) {
        Review review = toEntity(dto);
        return toDTO(reviewRepository.save(review));
    }

    public ReviewDTO updateReview(Integer id, ReviewDTO dto) {
        return reviewRepository.findById(id).map(existing -> {
            existing.setRating(dto.getRating());
            existing.setComment(dto.getComment());
            return toDTO(reviewRepository.save(existing));
        }).orElse(null);
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDTO toDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(review.getId());
        if (review.getUser() != null) {
            dto.setUserId(review.getUser().getId());
        }
        if (review.getProduct() != null) {
            dto.setProductId(review.getProduct().getProductId());
        }
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        return dto;
    }

    private Review toEntity(ReviewDTO dto) {
        Review review = new Review();
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        return review;
    }
}
