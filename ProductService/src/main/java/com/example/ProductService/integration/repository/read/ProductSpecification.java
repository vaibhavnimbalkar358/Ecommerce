package com.example.ProductService.integration.repository.read;

import com.example.ProductService.integration.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public final class ProductSpecification {

    private ProductSpecification() {}
    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> name == null || name.isBlank() ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> hasCategory(String category) {
        return (root, query, cb) -> category == null || category.isBlank() ? null : cb.equal(cb.lower(root.get("category")), category.toLowerCase());
    }

    public static Specification<Product> hasBrand(String brand) {

        return (root, query, cb) -> brand == null || brand.isBlank() ? null : cb.equal(cb.lower(root.get("brand")), brand.toLowerCase());
    }

    public static Specification<Product> priceGreaterThan(BigDecimal price) {

        return (root, query, cb) -> price == null ? null : cb.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> priceLessThan(BigDecimal price) {
        return (root, query, cb) ->
                price == null ? null : cb.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> activeProducts() {

        return (root, query, cb) -> cb.and(cb.isFalse(root.get("deleted")), cb.equal(root.get("status"), com.example.ProductService.enums.ProductStatus.ACTIVE));
    }
}