package com.example.OrderService.business.serviceimpl;

import com.example.OrderService.business.dto.OrderRequestDTOa;
import com.example.OrderService.business.service.OrderService;
import com.example.OrderService.integration.domain.Order;
import com.example.OrderService.integration.repository.read.OrderReadRepository;
import com.example.OrderService.integration.repository.write.OrderRepositorywriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepositorywriteRepository orderWriteRepository;

    @Autowired
    private OrderReadRepository orderReadRepository;


    @Override
    public String createOrder(OrderRequestDTOa order) {

        Order newOrder = new Order();

        newOrder.setUserId(order.getUserId());
        newOrder.setName(order.getName());
        newOrder.setPhone(order.getPhone());
        newOrder.setProductId(order.getProductId());
        newOrder.setQuantity(order.getQuantity());
        newOrder.setPrice(order.getPrice());

        orderWriteRepository.save(newOrder);

        return "Order is created successfully";
    }


    @Override
    public OrderRequestDTOa getOrderById(Long id) {

        Order order = orderReadRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id: " + id));

        OrderRequestDTOa response = new OrderRequestDTOa();

        response.setUserId(order.getUserId());
        response.setName(order.getName());
        response.setPhone(order.getPhone());
        response.setProductId(order.getProductId());
        response.setQuantity(order.getQuantity());
        response.setPrice(order.getPrice());

        return response;
    }


    @Override
    public List<Order> getAllOrders() {

        return orderWriteRepository.findAll();
    }


    @Override
    public Order updateOrder(Long id, Order order) {

        Order existingOrder = orderReadRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id: " + id));

        existingOrder.setUserId(order.getUserId());
        existingOrder.setName(order.getName());
        existingOrder.setPhone(order.getPhone());
        existingOrder.setProductId(order.getProductId());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setPrice(order.getPrice());

        return orderWriteRepository.save(existingOrder);
    }


    @Override
    public void deleteOrder(Long id) {

        Order existingOrder = orderWriteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id: " + id));

        orderWriteRepository.delete(existingOrder);
    }
}

