package com.gumroad.ratings.models.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String productId;
    private String name;
    private String description;
}
