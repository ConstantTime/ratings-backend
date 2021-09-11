package com.gumroad.ratings.models.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRatingResponse {
    List<ProductRating> productRatings;
}