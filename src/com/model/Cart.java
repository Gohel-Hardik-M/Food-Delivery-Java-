package com.model;

import java.util.ArrayList;

public class Cart {




        private final ArrayList<CartItem> items = new ArrayList<>();

        public void addItem(Menu menu, int qty) {

            for (CartItem item : items) {

                if (item.getMenu().getId().equals(menu.getId())) {

                    item.setQuantity(item.getQuantity() + qty);
                    return;
                }
            }

            items.add(new CartItem(menu, qty));
        }

        public void removeItem(String menuId) {

            items.removeIf(item ->
                    item.getMenu().getId().equals(menuId));
        }

        public void updateQuantity(String menuId, int qty) {

            for (CartItem item : items) {

                if (item.getMenu().getId().equals(menuId)) {

                    item.setQuantity(qty);
                    return;
                }
            }
        }

        public ArrayList<CartItem> getItems() {
            return items;
        }

        public void clear() {
            items.clear();
        }

        public double getTotal() {

            double total = 0;

            for (CartItem item : items) {
                total += item.getMenu().getPrice() * item.getQuantity();
            }

            return total;
        }

        public boolean isEmpty() {
            return items.isEmpty();
        }

}
