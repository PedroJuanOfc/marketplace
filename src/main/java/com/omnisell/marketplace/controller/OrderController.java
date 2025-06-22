package com.omnisell.marketplace.controller;

import com.omnisell.marketplace.dto.OrderResponse;
import com.omnisell.marketplace.model.Order;
import com.omnisell.marketplace.model.OrderItem;
import com.omnisell.marketplace.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public OrderResponse createOrder(@PathVariable Long userId, @RequestBody List<OrderItem> items) {
        Order order = orderService.createOrder(userId, items);
        return orderService.mapToOrderResponse(order);
    }


    @GetMapping
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return orders.stream()
                .map(orderService::mapToOrderResponse)
                .toList();
    }


    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return orderService.mapToOrderResponse(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
