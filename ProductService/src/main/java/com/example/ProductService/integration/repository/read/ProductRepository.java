package com.example.ProductService.integration.repository.read;

import com.example.ProductService.integration.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Optional<Product> findByIdAndDeletedFalse(Long id);

    Page<Product> findAllByDeletedFalse(Pageable pageable);

    Page<Product> findByCategoryIgnoreCaseAndDeletedFalse(String category, Pageable pageable
    );
    boolean existsByNameIgnoreCaseAndDeletedFalse(String name);
}