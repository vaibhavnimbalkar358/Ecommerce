package com.example.OrderService.repository;

import com.example.OrderService.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderUserId(Long userId);

    List<OrderItem> findByOrderStatus(String status);
}