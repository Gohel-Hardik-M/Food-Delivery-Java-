package com.service;

import com.model.Cart;
import com.model.Menu;
import com.model.User;
import com.repository.MenuRepository;

import java.util.Scanner;

public class CustomerService {



        private final MenuRepository menuRepository;
        private final OrderService orderService;
        private final Scanner scanner;

        public CustomerService(MenuRepository menuRepository,
                               OrderService orderService) {

            this.menuRepository = menuRepository;
            this.orderService = orderService;
            this.scanner = new Scanner(System.in);
        }

        public void viewMenu() {

            System.out.println("\n========== MENU ==========");

            if (menuRepository.getAllMenu().isEmpty()) {
                System.out.println("No menu items available.");
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

        public void addToCart(Cart cart) {

            System.out.print("Enter Item ID: ");
            String id = scanner.nextLine();

            Menu menu = menuRepository.getMenuById(id);

            if (menu == null) {
                System.out.println("Invalid Item ID!");
                return;
            }

            System.out.print("Enter Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            cart.addItem(menu, quantity);

            System.out.println("Item added to cart!");
        }

        public void viewCart(Cart cart) {

            System.out.println("\n========= CART =========");

            if (cart.isEmpty()) {
                System.out.println("Cart is empty!");
                return;
            }

            cart.getItems().forEach(item ->

                    System.out.println(
                            item.getMenu().getItemName()
                                    + " x "
                                    + item.getQuantity()
                                    + " = ₹"
                                    + (item.getMenu().getPrice() * item.getQuantity())
                    )
            );

            System.out.println("----------------------");
            System.out.println("TOTAL : ₹" + cart.getTotal());
        }

        public void removeFromCart(Cart cart) {

            System.out.print("Enter Item ID to remove: ");
            String id = scanner.nextLine();

            cart.removeItem(id);

            System.out.println("Item removed from cart!");
        }

        public void placeOrder(User user, Cart cart) {
            orderService.placeOrder(user, cart);
        }

        public void customerMenu(User user) {

            Cart cart = new Cart();

            while (true) {

                System.out.println("\n===== CUSTOMER MENU =====");
                System.out.println("1 -> View Menu");
                System.out.println("2 -> Add to Cart");
                System.out.println("3 -> View Cart");
                System.out.println("4 -> Remove Item from Cart");
                System.out.println("5 -> Place Order");
                System.out.println("0 -> Logout");

                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        viewMenu();
                        break;

                    case 2:
                        viewMenu();
                        addToCart(cart);
                        break;

                    case 3:
                        viewCart(cart);
                        break;

                    case 4:
                        removeFromCart(cart);
                        break;

                    case 5:
                        placeOrder(user, cart);
                        break;

                    case 0:
                        System.out.println("Logging out...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }

}
