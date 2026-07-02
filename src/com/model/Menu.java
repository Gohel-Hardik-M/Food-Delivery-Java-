package com.model;

import java.util.Random;

public class Menu {

        private final String id;
        private final String menuType;
        private final String itemName;
        private final double price;

        public Menu(String menuType,
                    String itemName,
                    double price) {

            this.id = generateItemId();
            this.menuType = menuType;
            this.itemName = itemName;
            this.price = price;
        }

        private static String generateItemId() {

            Random random = new Random();
            return "ITEM" + (10000 + random.nextInt(90000));
        }

        public String getId() {
            return id;
        }

        public String getMenuType() {
            return menuType;
        }

        public String getItemName() {
            return itemName;
        }

        public double getPrice() {
            return price;
        }

}
