package com.example.ProductService.integration.domain;

import com.example.ProductService.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(
        name = "products",
        indexes = {
                @Index(name = "idx_product_name", columnList = "name"),
                @Index(name = "idx_product_category", columnList = "category"),
                @Index(name = "idx_product_status", columnList = "status")
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(length = 100)
    private String brand;

    @Column(length = 500)
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ProductStatus status;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Version
    private Long version;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {

        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        updatedAt = now;

        if (deleted == null) {
            deleted = false;
        }

        if (status == null) {
            status = quantity != null && quantity > 0
                    ? ProductStatus.ACTIVE
                    : ProductStatus.OUT_OF_STOCK;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // getters and setters
}