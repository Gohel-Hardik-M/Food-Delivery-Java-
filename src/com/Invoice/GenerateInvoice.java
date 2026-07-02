package com.Invoice;

import com.model.CartItem;
import com.model.Order;

public class GenerateInvoice {


        private final Discount discount;

        public GenerateInvoice() {
            this.discount = new Discount();
        }

        public void generate(Order order) {

            System.out.println("\n========== INVOICE ==========");
            System.out.println("Order ID : " + order.getOrderId());
            System.out.println("User ID  : " + order.getUserId());
            System.out.println("-----------------------------");

            for (CartItem item : order.getItems()) {

                double itemTotal = item.getMenu().getPrice() * item.getQuantity();

                System.out.printf("%s x %d = ₹%.2f%n",
                        item.getMenu().getItemName(),
                        item.getQuantity(),
                        itemTotal);
            }

            System.out.println("-----------------------------");

            double total = order.getTotalAmount();
            double discountAmount = discount.getDiscount(total);
            double finalAmount = total - discountAmount;

            System.out.printf("Total Amount : ₹%.2f%n", total);
            System.out.printf("Discount     : ₹%.2f%n", discountAmount);
            System.out.printf("Payable      : ₹%.2f%n", finalAmount);

            System.out.println("-----------------------------");
            System.out.println("Thank You For Ordering!");
            System.out.println("=============================\n");
        }

}
