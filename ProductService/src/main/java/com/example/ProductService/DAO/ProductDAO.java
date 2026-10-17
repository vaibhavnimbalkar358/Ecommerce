package com.example.ProductService.DAO;


import com.example.ProductService.integration.domain.Product;
import com.example.ProductService.integration.repository.read.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductDAO {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findByIdAndDeletedFalse(id);
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAllByDeletedFalse(pageable);
    }

    public boolean existsByName(String name) {
        return productRepository
                .existsByNameIgnoreCaseAndDeletedFalse(name);
    }

    public void delete(Product product) {
        productRepository.save(product);
    }

    public ProductRepository repository() {
        return productRepository;
    }
}