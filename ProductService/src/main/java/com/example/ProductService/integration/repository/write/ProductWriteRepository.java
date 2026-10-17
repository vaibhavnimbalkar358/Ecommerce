package com.example.ProductService.integration.repository.write;

import com.example.ProductService.integration.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductWriteRepository extends JpaRepository<Product,Long> {
}
