package com.gumroad.ratings.service;

import com.gumroad.ratings.db.models.RatingEntity;
import com.gumroad.ratings.db.repository.RatingRepository;
import com.gumroad.ratings.models.request.ProductReviewRequest;
import com.gumroad.ratings.models.response.ProductReview;
import com.gumroad.ratings.models.response.ProductReviewResponse;
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

    public void saveRating(String productId, ProductReviewRequest productReviewRequest) {
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setRating(productReviewRequest.getRating());
        ratingEntity.setRatingId(UUID.randomUUID().toString());
        ratingEntity.setReview(productReviewRequest.getReview());
        ratingEntity.setProductId(productId);
        ratingRepository.save(ratingEntity);
    }

    public void updateRating(String ratingId, ProductReviewRequest productReviewRequest) {
        ratingRepository.updateRatingAndReview(productReviewRequest.getRating(),
                productReviewRequest.getReview(), ratingId);
    }

    public ProductReviewResponse getTop3RatingsAndReviews(String productId) {
        List<RatingEntity> ratingEntityList = ratingRepository.findThreeBestRatingsFor(productId);
        ProductReviewResponse productReviewResponse = new ProductReviewResponse();
        List<ProductReview> productReviews = new ArrayList<>();

        ratingEntityList.forEach(ratingEntity ->
                productReviews.add(new ProductReview(ratingEntity.getRating(), ratingEntity.getReview())));

        productReviewResponse.setProductReviews(productReviews);

        return productReviewResponse;
    }
}
