package com.example.ProductService.business.serviceimpl;

import com.example.ProductService.DAO.ProductDAO;
import com.example.ProductService.business.dto.*;
import com.example.ProductService.business.service.ProductService;
import com.example.ProductService.enums.ProductStatus;

import com.example.ProductService.exception.ProductAlreadyExistsException;
import com.example.ProductService.exception.ProductNotFoundException;
import com.example.ProductService.integration.domain.Product;
import com.example.ProductService.integration.repository.read.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public ProductResponse createProduct(ProductCreateRequest request) {
        if (productDAO.existsByName(request.name())) {
            throw new ProductAlreadyExistsException(
                    "Product already exists: " + request.name());
        }
        Product product = new Product();

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
        product.setCategory(request.category());
        product.setBrand(request.brand());
        product.setImageUrl(request.imageUrl());

        product.setStatus(request.quantity() > 0 ? ProductStatus.ACTIVE : ProductStatus.OUT_OF_STOCK);
        Product savedProduct = productDAO.save(product);
        return mapToResponse(savedProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id) {

        Product product = productDAO.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return mapToResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductResponse> getProducts(String name, String category, String brand, Pageable pageable) {

        Specification<Product> specification = Specification
                        .where(ProductSpecification.hasName(name))
                        .and(ProductSpecification.hasCategory(category))
                        .and(ProductSpecification.hasBrand(brand));
        return productDAO.repository().findAll(specification, pageable).map(this::mapToResponse);
    }

    @Override
    public ProductResponse updateProduct(Long id,ProductUpdateRequest request) {
        Product product = productDAO.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
        product.setCategory(request.category());
        product.setBrand(request.brand());
        product.setImageUrl(request.imageUrl());

        product.setStatus(request.quantity() > 0 ? ProductStatus.ACTIVE : ProductStatus.OUT_OF_STOCK);
        return mapToResponse(productDAO.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productDAO.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        // Soft delete
        product.setDeleted(true);
        product.setStatus(ProductStatus.INACTIVE);
        productDAO.delete(product);
    }

    private ProductResponse mapToResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory(),
                product.getBrand(),
                product.getImageUrl(),
                product.getStatus(),
                product.getCreatedAt(),
                product.getUpdatedAt());
    }
}