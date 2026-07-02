package com.Invoice;

public class Discount {



        private static final double DISCOUNT_PERCENTAGE = 0.05;
        private static final double MINIMUM_AMOUNT = 500;

        public double getDiscount(double totalAmount) {

            if (totalAmount >= MINIMUM_AMOUNT) {
                return totalAmount * DISCOUNT_PERCENTAGE;
            }

            return 0;
        }

}
