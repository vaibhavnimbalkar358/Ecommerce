package com.example.OrderService.presentation.controller;

import com.example.OrderService.business.dto.OrderRequestDTOa;
import com.example.OrderService.business.service.OrderService;
import com.example.OrderService.integration.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class orderController {

    @Autowired
    private OrderService orderService;


    // Create Order
    @PostMapping("/order")
    public String createOrder(@RequestBody OrderRequestDTOa order) {
        return orderService.createOrder(order);
    }


    // Get Order By ID
    @GetMapping("/{id}")
    public OrderRequestDTOa getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }


    // Get All Orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    // Update Order
    @PutMapping("/{id}")
    public Order updateOrder(
            @PathVariable Long id,
            @RequestBody Order order) {

        return orderService.updateOrder(id, order);
    }


    // Delete Order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);

        return "Order deleted successfully";
    }

}
