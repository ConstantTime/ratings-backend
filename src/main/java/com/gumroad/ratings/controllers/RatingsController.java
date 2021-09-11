package com.gumroad.ratings.controllers;

import com.gumroad.ratings.service.RatingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(path = "/api/v1/gumroad")
public class RatingsController {

    private final RatingService ratingService;

    public RatingsController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(
            value = "/rating/{product_id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addRatings(@PathVariable(name = "product_id") String productId,
                                     @RequestBody Double rating) {
        ratingService.addRating(productId, rating);
        return new ResponseEntity(HttpStatus.OK);
    }
}

