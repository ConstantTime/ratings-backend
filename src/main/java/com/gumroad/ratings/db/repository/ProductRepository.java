package com.gumroad.ratings.db.repository;

import com.gumroad.ratings.db.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByProductId(String productId);
}
