package com.example.ProductService.business.service;

import com.example.ProductService.business.dto.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductResponse createProduct(ProductCreateRequest request);

    ProductResponse getProductById(Long id);

    Page<ProductResponse> getProducts(String name, String category, String brand,Pageable pageable);

    ProductResponse updateProduct(Long id, ProductUpdateRequest request);

    void deleteProduct(Long id);
}