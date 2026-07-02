package com.service;

import com.repository.StockRepository;

import java.util.ArrayList;
import java.util.Map;

public class StockService {



        private final StockRepository stockRepository;

        public StockService(StockRepository stockRepository) {
            this.stockRepository = stockRepository;
        }

        public void addOrUpdateStock(String item, int quantity) {
            stockRepository.addOrUpdateStock(item, quantity);
        }

        public Integer searchStock(String item) {
            return stockRepository.searchStock(item);
        }

        public ArrayList<String> getLowStockNotifications() {

            ArrayList<String> notifications = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : stockRepository.getStock().entrySet()) {

                if (entry.getValue() < 10) {

                    notifications.add(
                            "LOW STOCK : "
                                    + entry.getKey()
                                    + " - Only "
                                    + entry.getValue()
                                    + " units left."
                    );
                }
            }

            return notifications;
        }

}
