package com.homebroker.ordersapi.ordersapi.hosts.API;

import com.homebroker.ordersapi.ordersapi.appservice.mappers.OrderMapper;
import com.homebroker.ordersapi.ordersapi.appservice.requests.OrderRequest;
import com.homebroker.ordersapi.ordersapi.appservice.responses.OrderResponse;
import com.homebroker.ordersapi.ordersapi.domain.entities.Order;
import com.homebroker.ordersapi.ordersapi.infra.OrdersDB;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Queue;

@RestController
public class OrdersController {

    private static OrdersDB ordersDB;
    public OrdersController(){
        ordersDB = OrdersDB.getInstance();
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @PostMapping("/buyorder")
    OrderResponse BuyOrder(@RequestBody OrderRequest buyOrderRequest){
        try{
            Order order = OrderMapper.ToBuyOrder(buyOrderRequest);
            ordersDB.addOrder(order);
            return OrderMapper.ToOrderResponse(order);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @PostMapping("/sellorder")
    OrderResponse SellOrder(@RequestBody OrderRequest sellOrderRequest){
        Order order = OrderMapper.ToSellOrder(sellOrderRequest);
        ordersDB.addOrder(order);
        return OrderMapper.ToOrderResponse(order);
    }

    @PostMapping("/orders")
    Queue<Order> GetHistory(){
        return ordersDB.GetOrders();
    }
}
