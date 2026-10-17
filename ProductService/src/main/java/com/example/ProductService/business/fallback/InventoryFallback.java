package com.example.ProductService.business.fallback;

import com.example.ProductService.business.dto.InventoryResponse;
import com.example.ProductService.business.feignclient.InventoryFeignClient;

public class InventoryFallback
        implements InventoryFeignClient {

    @Override
    public InventoryResponse getInventory(Long productId) {

        return new InventoryResponse(
                productId,
                0,
                false
        );
    }

    @Override
    public InventoryResponse reserveStock(
            Long productId,
            Integer quantity
    ) {

        return new InventoryResponse(
                productId,
                0,
                false
        );
    }
}