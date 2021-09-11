package com.gumroad.ratings.db.repository;

import com.gumroad.ratings.db.models.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "update ReviewEntity r set r.review=?1 where r.productId=?2")
    void setReviewForProduct(String review, String productId);
}