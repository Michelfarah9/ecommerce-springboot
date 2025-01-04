package com.example.product_catalog.controller;
import com.example.product_catalog.entity.Product;
import com.example.product_catalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    // Constructor injection of the repository
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET /products -> returns a list of all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // POST /products -> creates a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Example of a GET by ID endpoint (optional)
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
