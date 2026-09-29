package com.example.OrderService.business.dto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTOa {

    private Long userId;
    private String Name;
    private String phone;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
