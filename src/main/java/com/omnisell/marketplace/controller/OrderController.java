package com.omnisell.marketplace.controller;

import com.omnisell.marketplace.dto.OrderResponse;
import com.omnisell.marketplace.model.Order;
import com.omnisell.marketplace.model.OrderItem;
import com.omnisell.marketplace.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(orderService::mapToOrderResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponse> getByUser(@PathVariable Long userId) {
        return orderService.getAllOrders().stream()
                .filter(o -> o.getUser().getId().equals(userId))
                .map(orderService::mapToOrderResponse)
                .toList();
    }



    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
