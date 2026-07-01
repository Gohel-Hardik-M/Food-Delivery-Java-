package com.tss.Services;

import com.tss.Cart.Cart;
import com.tss.Cart.CartItem;
import com.tss.Cart.Order;
import com.tss.DB.DB;
import com.tss.Invoice.GenerateInvoice;
import com.tss.Users.Users;

import java.util.UUID;

public class OrderService {


        private DB db;

        public OrderService(DB db) {
            this.db = db;
        }


        public void placeOrder(Users user, Cart cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot place order!");
            return;
        }

        String orderId = generateOrderId();

        Order order = new Order(
                orderId,
                user.getId(),
                user.getName(),
                cart.getItems(),
                cart.getTotal(),db
        );

        db.addOrder(order);

        GenerateInvoice invoice = new GenerateInvoice();
        invoice.generate(order);

        cart.clear();
    }



        private String generateOrderId() {
            return "ORD-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        }

}
