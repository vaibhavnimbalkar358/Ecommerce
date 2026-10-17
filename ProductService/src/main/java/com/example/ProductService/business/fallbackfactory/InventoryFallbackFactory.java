package com.example.ProductService.business.fallbackfactory;


import com.example.ProductService.business.dto.InventoryResponse;
import com.example.ProductService.business.feignclient.InventoryFeignClient;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class InventoryFallbackFactory
        implements FallbackFactory<InventoryFeignClient> {

    @Override
    public InventoryFeignClient create(Throwable cause) {

        return new InventoryFeignClient() {

            @Override
            public InventoryResponse getInventory(
                    Long productId
            ) {

                System.out.println(
                        "Inventory Service unavailable: "
                                + cause.getMessage()
                );

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

                System.out.println(
                        "Inventory Service unavailable: "
                                + cause.getMessage()
                );

                return new InventoryResponse(
                        productId,
                        0,
                        false
                );
            }
        };
    }
}