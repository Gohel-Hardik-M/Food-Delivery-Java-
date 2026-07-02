package com.service;

import com.model.Menu;
import com.repository.MenuRepository;

public class MenuService {




        private final MenuRepository menuRepository;

        public MenuService(MenuRepository menuRepository) {
            this.menuRepository = menuRepository;
        }

        public void addMenuItem(String menuType, String itemName, double price) {

            Menu menu = new Menu(
                    menuType.toLowerCase(),
                    itemName.toLowerCase(),
                    price
            );

            menuRepository.addMenu(menu);

            System.out.println("------------------------");
            System.out.println("Item Added Successfully!");
        }

        public void displayMenu() {

            System.out.println("\n===== MENU ITEMS =====");

            if (menuRepository.getAllMenu().isEmpty()) {
                System.out.println("No menu items found!");
                return;
            }

            for (Menu menu : menuRepository.getAllMenu()) {

                System.out.printf(
                        "ID: %s | Type: %s | Item: %s | Price: ₹%.2f%n",
                        menu.getId(),
                        menu.getMenuType(),
                        menu.getItemName(),
                        menu.getPrice()
                );
            }
        }

        public Menu getMenuById(String id) {
            return menuRepository.getMenuById(id);
        }




}
