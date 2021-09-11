package com.gumroad.ratings.db.repository;

import com.gumroad.ratings.db.models.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "update ratings r set r.rating=?1 where r.product_id=?2" , nativeQuery = true)
    void setRatingForProduct(Double rating, String productId);
}
