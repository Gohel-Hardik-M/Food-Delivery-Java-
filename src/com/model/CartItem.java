package com.model;

public class CartItem {



        private final Menu menu;
        private int quantity;

        public CartItem(Menu menu, int quantity) {
            this.menu = menu;
            this.quantity = quantity;
        }

        public Menu getMenu() {
            return menu;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

}
