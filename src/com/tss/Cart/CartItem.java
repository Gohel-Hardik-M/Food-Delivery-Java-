package com.tss.Cart;

import com.tss.DB.DB;
import com.tss.Menu.Menu;

import java.util.ArrayList;

public class CartItem {

    public CartItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    private Menu menu;
        private int quantity;

        public Menu getMenu() { return menu; }
        public int getQuantity() { return quantity; }

        public void setQuantity(int quantity) {
        this.quantity = quantity;
        }
}
