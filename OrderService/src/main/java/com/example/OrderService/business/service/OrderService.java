package com.example.OrderService.business.service;

import com.example.OrderService.business.dto.OrderRequestDTOa;
import com.example.OrderService.integration.domain.Order;

import java.util.List;
public interface OrderService {
    String createOrder(OrderRequestDTOa order);

    OrderRequestDTOa getOrderById(Long id);

    List<Order> getAllOrders();

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);
}
