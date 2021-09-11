package com.gumroad.ratings.db.repository;

import com.gumroad.ratings.db.models.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "update RatingEntity r set r.rating=?1, r.review=?2 where r.productId=?3")
    void updateRatingAndReview(BigDecimal rating, String review, String productId);

    @Query(value = "select * from ratings r order by r.rating desc limit 3", nativeQuery = true)
    List<RatingEntity> findThreeBestRatingsFor(String productId);
}
