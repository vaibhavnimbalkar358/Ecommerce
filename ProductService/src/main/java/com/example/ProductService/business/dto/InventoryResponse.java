package com.example.ProductService.business.dto;

public record InventoryResponse(

        Long productId,

        Integer availableQuantity,

        boolean available
) {
}