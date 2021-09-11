package com.gumroad.ratings.service;

import com.gumroad.ratings.db.models.RatingEntity;
import com.gumroad.ratings.db.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void saveRating(String productId, BigDecimal rating) {
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setRating(rating);
        ratingEntity.setProductId(productId);
        ratingRepository.save(ratingEntity);
    }

    public void updateRating(String productId, BigDecimal rating) {
        ratingRepository.setRatingForProduct(rating, productId);
    }
}
