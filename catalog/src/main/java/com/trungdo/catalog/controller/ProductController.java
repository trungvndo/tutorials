package com.trungdo.catalog.controller;

import com.trungdo.catalog.dto.CreateProductRequest;
import com.trungdo.catalog.entities.Product;
import com.trungdo.catalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequest request) {
        Product newProduct = productRepository.save(
            new Product(
                request.getName(),
                request.getCategory(),
                request.getPrice()
            )
        );

        return newProduct;
    }
}
