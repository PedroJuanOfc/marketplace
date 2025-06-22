package com.omnisell.marketplace.dto;

import lombok.Data;

@Data
public class OrderItemResponse {
    private String productName;
    private Double unitPrice;
    private Integer quantity;
    private Double subtotal;
}