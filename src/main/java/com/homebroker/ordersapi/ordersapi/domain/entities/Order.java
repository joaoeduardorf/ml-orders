package com.homebroker.ordersapi.ordersapi.domain.entities;

import com.homebroker.ordersapi.ordersapi.domain.objectvalue.OrderType;

import java.time.Instant;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private int walletId;
    private int quantity;
    private int price;
    private OrderType orderType;
    private Instant timestamp;

    public Order(int walletId, int quantity, int price, OrderType orderType) {
        this.orderId = UUID.randomUUID();
        this.walletId = walletId;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
        this.timestamp = Instant.now();
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

    public int getWalletId() {
        return walletId;
    }

    public UUID getOrderId() {
        return orderId;
    }
}
