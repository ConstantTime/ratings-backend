package com.gumroad.ratings.controllers;

import com.gumroad.ratings.service.ReviewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(path = "/api/v1/gumroad")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(
            value = "/review/{product_id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addReview(@PathVariable(name = "product_id") String productId,
                                    @RequestBody String review) {
        reviewService.saveReview(productId, review);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(
            value = "/review/{product_id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateReview(@PathVariable(name = "product_id") String productId,
                                       @RequestBody String review) {
        reviewService.updateReview(productId, review);
        return new ResponseEntity(HttpStatus.OK);
    }
}
