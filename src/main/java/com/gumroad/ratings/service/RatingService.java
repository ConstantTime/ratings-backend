package com.gumroad.ratings.service;

import com.gumroad.ratings.db.models.RatingEntity;
import com.gumroad.ratings.db.repository.RatingRepository;
import com.gumroad.ratings.models.request.ProductRatingRequest;
import com.gumroad.ratings.models.response.ProductRating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void saveRating(String productId, ProductRatingRequest productRatingRequest) {
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setRating(productRatingRequest.getRating());
        ratingEntity.setRatingId(UUID.randomUUID().toString());
        ratingEntity.setReview(productRatingRequest.getReview());
        ratingEntity.setProductId(productId);
        ratingRepository.save(ratingEntity);
    }

    public void updateRating(String ratingId, ProductRatingRequest productRatingRequest) {
        ratingRepository.updateRatingAndReview(productRatingRequest.getRating(),
                productRatingRequest.getReview(), ratingId);
    }

    public List<ProductRating> getTop3RatingsAndReviews(String productId) {
        List<RatingEntity> ratingEntityList = ratingRepository.findThreeBestRatingsFor(productId);
        List<ProductRating> productRatings = new ArrayList<>();

        ratingEntityList.forEach(ratingEntity ->
                productRatings.add(new ProductRating(ratingEntity.getRatingId(), ratingEntity.getRating(), ratingEntity.getReview())));

        return productRatings;
    }
}
