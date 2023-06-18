package com.homebroker.ordersapi.ordersapi.infra;

import com.homebroker.ordersapi.ordersapi.domain.entities.Order;

import java.util.*;

public class OrdersDB {

    private Queue<Order> orders;
    private static OrdersDB instance;
    private OrdersDB() {
        orders = new LinkedList<>();
    }

    public static OrdersDB getInstance() {
        if(instance == null) {
            synchronized(OrdersDB.class) {
                if(instance == null) {
                    instance = new OrdersDB();
                }
            }
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Queue<Order> GetOrders(){
        return orders;
    }
}
