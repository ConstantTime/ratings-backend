package com.gumroad.ratings.models.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductReviewRequest {
    private BigDecimal rating;
    private String review;
}
