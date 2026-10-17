package com.example.ProductService.presentation.controller;

import com.example.ProductService.business.dto.*;
import com.example.ProductService.business.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductCreateRequest request)
    {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Product created successfully", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>>
    getProductById(@PathVariable Long id) {
        ProductResponse response = productService.getProductById(id);
        return ResponseEntity.ok(ApiResponse.success("Product fetched successfully", response));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getProducts(@RequestParam(required = false) String name,
                                                             @RequestParam(required = false) String category,
                                                             @RequestParam(required = false) String brand,
                                                             @PageableDefault(page = 0, size = 20, sort = "createdAt") Pageable pageable) {
        return ResponseEntity.ok(productService.getProducts(name, category, brand, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>>
    updateProduct(@PathVariable Long id, @Valid @RequestBody ProductUpdateRequest request
    ) {
        ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.ok(ApiResponse.success("Product updated successfully", response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>
    deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponse.success("Product deleted successfully", null));
    }
}