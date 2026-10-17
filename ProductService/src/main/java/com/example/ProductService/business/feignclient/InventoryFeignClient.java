package com.example.ProductService.business.feignclient;


import com.example.ProductService.business.dto.InventoryResponse;
import com.example.ProductService.business.fallbackfactory.InventoryFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "INVENTORY-SERVICE",
        path = "/api/v1/inventory",
        fallbackFactory = InventoryFallbackFactory.class
)
public interface InventoryFeignClient {

    @GetMapping("/product/{productId}")
    InventoryResponse getInventory(
            @PathVariable Long productId
    );

    @PutMapping("/product/{productId}/reserve")
    InventoryResponse reserveStock(
            @PathVariable Long productId,
            @RequestParam Integer quantity
    );
}