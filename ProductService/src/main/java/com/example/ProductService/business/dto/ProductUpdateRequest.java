package com.example.ProductService.business.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductUpdateRequest(

        @NotBlank(message = "Product name is required")
        @Size(max = 150)
        String name,

        @NotBlank(message = "Description is required")
        String description,

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than zero")
        BigDecimal price,

        @NotNull(message = "Quantity is required")
        @Min(value = 0)
        Integer quantity,

        @NotBlank(message = "Category is required")
        String category,

        String brand,

        String imageUrl
) {
}