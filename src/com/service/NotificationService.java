package com.service;

import com.repository.StockRepository;

import java.util.ArrayList;
import java.util.Map;

public class NotificationService {


        private final StockRepository stockRepository;

        public NotificationService(StockRepository stockRepository) {
            this.stockRepository = stockRepository;
        }

        public ArrayList<String> getNotifications() {

            ArrayList<String> notifications = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : stockRepository.getStock().entrySet()) {

                String item = entry.getKey();
                int qty = entry.getValue();

                if (qty < 10) {

                    notifications.add(
                            "Item at LOW STOCK: "
                                    + item
                                    + " - Only "
                                    + qty
                                    + " Units Available"
                    );
                }
            }

            return notifications;
        }


}
