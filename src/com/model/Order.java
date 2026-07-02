package com.model;

import java.util.ArrayList;
import java.util.List;

public class Order {


        private final String orderId;
        private final String userId;
        private final List<CartItem> items;
        private final double totalAmount;
        private String status;
    private String deliveryPartnerId;

        public Order(String orderId,
                     String userId,
                     List<CartItem> items,
                     double totalAmount) {

            this.orderId = orderId;
            this.userId = userId;
            this.items = new ArrayList<>(items);
            this.totalAmount = totalAmount;
            this.status = "pending";

        }



    public String getDeliveryPartnerId() {
        return deliveryPartnerId;
    }

    public void setDeliveryPartnerId(String deliveryPartnerId) {
        this.deliveryPartnerId = deliveryPartnerId;
    }



        public String getOrderId() {
            return orderId;
        }

        public String getUserId() {
            return userId;
        }

        public List<CartItem> getItems() {
            return items;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
