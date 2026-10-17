package com.example.ProductService.business.dto;

import com.example.ProductService.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse(

        Long id,

        String name,

        String description,

        BigDecimal price,

        Integer quantity,

        String category,

        String brand,

        String imageUrl,

        ProductStatus status,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {
}