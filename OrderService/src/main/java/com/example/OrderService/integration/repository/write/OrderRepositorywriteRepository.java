package com.example.OrderService.integration.repository.write;

import com.example.OrderService.integration.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepositorywriteRepository extends JpaRepository<Order, Long>{
}
