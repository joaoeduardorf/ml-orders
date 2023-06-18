package com.homebroker.ordersapi.ordersapi.appservice.mappers;

import com.homebroker.ordersapi.ordersapi.appservice.requests.OrderRequest;
import com.homebroker.ordersapi.ordersapi.appservice.responses.OrderResponse;
import com.homebroker.ordersapi.ordersapi.domain.entities.Order;
import com.homebroker.ordersapi.ordersapi.domain.objectvalue.OrderType;

public class OrderMapper {
    public static Order ToBuyOrder(OrderRequest orderRequest){
        return new Order(orderRequest.walletId ,orderRequest.quantity, orderRequest.price, OrderType.BUY);
    }

    public static Order ToSellOrder(OrderRequest orderRequest){
        return new Order(orderRequest.walletId, orderRequest.quantity, orderRequest.price, OrderType.SELL);
    }

    public static OrderResponse ToOrderResponse(Order order){
        return new OrderResponse(order.getOrderId(), order.getWalletId(), order.getQuantity(), order.getPrice(),order.getOrderType(), order.getTimestamp());
    }
}
