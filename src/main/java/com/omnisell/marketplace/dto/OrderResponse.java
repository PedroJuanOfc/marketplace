package com.omnisell.marketplace.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Long orderId;
    private LocalDateTime createdAt;
    private String status;
    private List<OrderItemResponse> items;
    private Double total;
}
