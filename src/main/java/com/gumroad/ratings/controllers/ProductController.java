package com.gumroad.ratings.controllers;

import com.gumroad.ratings.models.request.ProductRatingRequest;
import com.gumroad.ratings.models.request.ProductRequest;
import com.gumroad.ratings.models.response.Product;
import com.gumroad.ratings.models.response.ProductRatingResponse;
import com.gumroad.ratings.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(path = "/api/v1/gumroad")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(
            value = "/product",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.addProduct(productRequest);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping(
            value = "/product",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(
            value = "/product/{product_id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProducts(@PathVariable(name = "product_id") String productId) {
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
