package com.repository;

import com.model.Order;

import java.util.ArrayList;

public class OrderRepository {


    private final ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
