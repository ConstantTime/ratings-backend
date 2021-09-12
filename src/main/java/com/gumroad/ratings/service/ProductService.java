package com.gumroad.ratings.service;

import com.gumroad.ratings.db.models.ProductEntity;
import com.gumroad.ratings.db.repository.ProductRepository;
import com.gumroad.ratings.models.request.ProductRequest;
import com.gumroad.ratings.models.response.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productRequest.getName());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setProductId(UUID.randomUUID().toString());
        ProductEntity entity = productRepository.save(productEntity);

        return new Product(entity.getProductId(), entity.getName(), entity.getDescription());
    }

    public List<Product> getProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();

        return productEntityList.stream().map(productEntity -> new Product(
                productEntity.getProductId(),
                productEntity.getName(),
                productEntity.getDescription())).collect(Collectors.toList());
    }

    public Product getProduct(String productId) {
        ProductEntity productEntity = productRepository.findByProductId(productId);

        return new Product(
                productEntity.getProductId(),
                productEntity.getName(),
                productEntity.getDescription());
    }
}
