package com.repository;

import java.util.HashMap;

public class StockRepository {

    private final HashMap<String, Integer> stock = new HashMap<>();

    public StockRepository() {

        stock.put("Wheat", 25);
        stock.put("Milk", 8);
        stock.put("Curd", 5);
        stock.put("Chilly Powder", 15);
        stock.put("Potato", 3);
        stock.put("Coke", 20);
        stock.put("Ice Cream", 6);
        stock.put("Noodles", 30);
        stock.put("Mango", 9);
        stock.put("Wrap", 12);
    }

    public void addOrUpdateStock(String item, int quantity) {
        stock.put(item, quantity);
    }

    public Integer searchStock(String item) {
        return stock.get(item);
    }

    public HashMap<String, Integer> getStock() {
        return stock;
    }
}
