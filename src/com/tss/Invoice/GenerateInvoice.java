package com.tss.Invoice;

import com.tss.Cart.CartItem;
import com.tss.Cart.Order;

public class GenerateInvoice {



        public void generate(Order order) {

            System.out.println("\n========== INVOICE ==========");
            System.out.println("Order ID : " + order.getOrderId());
            System.out.println("User ID  : " + order.getUserId());
            System.out.println("-----------------------------");

            for (CartItem item : order.getItems()) {

                double itemTotal =
                        item.getMenu().getPrice() * item.getQuantity();

                System.out.println(
                        item.getMenu().getItemName()
                                + " x " + item.getQuantity()
                                + " = ₹" + itemTotal
                );
            }

            System.out.println("-----------------------------");
            System.out.println("TOTAL AMOUNT: ₹" + order.getTotalAmount());
            System.out.println("Thank you for your order!");
            System.out.println("=============================\n");
        }

}
