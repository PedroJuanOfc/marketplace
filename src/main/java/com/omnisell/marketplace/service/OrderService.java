package com.omnisell.marketplace.service;

import com.omnisell.marketplace.model.Order;
import com.omnisell.marketplace.model.OrderItem;
import com.omnisell.marketplace.repository.OrderRepository;
import com.omnisell.marketplace.repository.ProductRepository;
import com.omnisell.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(Long userId, List<OrderItem> items) {
        Order order = new Order();
        order.setUser(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado")));

        for (OrderItem item : items) {
            item.setOrder(order);
            item.setProduct(productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado")));
            item.setPrice(item.getProduct().getPrice());
        }

        order.setItems(items);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
