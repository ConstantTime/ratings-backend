package com.gumroad.ratings.models.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRating {
    private String ratingId;
    private BigDecimal rating;
    private String review;
}
