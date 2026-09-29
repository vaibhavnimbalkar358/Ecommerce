package com.example.OrderService.thirdparty.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private Long userId;
    private String name;
    private String phone;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
