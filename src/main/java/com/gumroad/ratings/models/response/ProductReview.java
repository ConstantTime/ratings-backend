package com.gumroad.ratings.models.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductReview {
    private BigDecimal rating;
    private String review;
}
