package com.tss.Cart;

import com.tss.DB.DB;

import java.util.ArrayList;

public class Order {


        private String orderId;
        private String userId;
        private ArrayList<CartItem> items;  // snapshot
        private double totalAmount;
        private  String status;
        DB db;

    public Order(String orderId,
                 String userId,
                 String userName,
                 ArrayList<CartItem> items,
                 double totalAmount, DB db) {
        this.db = db;
        this.status  = "pending";

        this.orderId = orderId;
        this.userId = userId;


        this.items = new ArrayList<>(items);

        this.totalAmount = totalAmount;
    }



        public  Order(DB db){
  this.db = db;
        }
        public Order(String orderId,
                     String userId,
                     String userName,
                     ArrayList<CartItem> items,
                     double totalAmount) {

            this.orderId = orderId;
            this.userId = userId;


            this.items = new ArrayList<>(items);

            this.totalAmount = totalAmount;
        }

        public ArrayList<CartItem> getItems() {
            return items;
        }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
