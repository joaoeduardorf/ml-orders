package com.homebroker.ordersapi.ordersapi.appservice.responses;

import com.homebroker.ordersapi.ordersapi.domain.objectvalue.OrderType;

import java.time.Instant;
import java.util.UUID;

public class OrderResponse {
    private UUID orderId;
    private int walletId;
    private int quantity;
    private int price;
    private OrderType orderType;
    private Instant timestamp;

    public OrderResponse(UUID orderId, int walletId, int quantity, int price, OrderType orderType, Instant timestamp) {
        this.orderId = orderId;
        this.walletId = walletId;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
        this.timestamp = timestamp;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public int getWalletId() {
        return walletId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
