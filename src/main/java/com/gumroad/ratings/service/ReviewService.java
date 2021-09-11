package com.gumroad.ratings.service;

import com.gumroad.ratings.db.models.ReviewEntity;
import com.gumroad.ratings.db.repository.ReviewRepository;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveReview(String productId, String review) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReview(review);
        reviewEntity.setProductId(productId);
        reviewRepository.save(reviewEntity);
    }

    public void updateReview(String productId, String review) {
        reviewRepository.setReviewForProduct(review, productId);
    }
}
