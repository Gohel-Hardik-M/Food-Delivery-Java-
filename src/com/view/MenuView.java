package com.view;


import com.model.Menu;

import java.util.List;
import java.util.Scanner;

public class MenuView {


        private final Scanner scanner;

        public MenuView(Scanner scanner) {
            this.scanner = scanner;
        }

        public String getMenuType() {
            System.out.print("Enter Menu Type: ");
            return scanner.nextLine().trim();
        }

        public String getItemName() {
            System.out.print("Enter Item Name: ");
            return scanner.nextLine().trim();
        }

        public double getPrice() {

            while (true) {
                try {
                    System.out.print("Enter Price: ");
                    return Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price! Please enter a valid number.");
                }
            }
        }


        public void displayMenu(List<Menu> menus) {

            System.out.println("\n========== MENU ==========");

            if (menus.isEmpty()) {
                System.out.println("No menu items available.");
                return;
            }

            for (Menu menu : menus) {
                System.out.printf(
                        "ID: %s | Type: %s | Item: %s | Price: ₹%.2f%n",
                        menu.getId(),
                        menu.getMenuType(),
                        menu.getItemName(),
                        menu.getPrice()
                );
            }
        }

        public void showMenuAddedMessage() {
            System.out.println("------------------------");
            System.out.println("Item Added Successfully!");
        }

        public void showInvalidMenuMessage() {
            System.out.println("Invalid Menu Item!");
        }

}
