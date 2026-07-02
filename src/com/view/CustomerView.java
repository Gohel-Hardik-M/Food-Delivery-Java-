package com.view;

import com.model.Cart;
import com.model.CartItem;
import com.model.Menu;
import com.model.User;
import com.service.MenuService;
import com.service.OrderService;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {



        private final MenuService menuService;
        private final OrderService orderService;

        private final Cart cart;

        private final Scanner sc;

        public CustomerView(MenuService menuService,
                            OrderService orderService) {

            this.menuService = menuService;
            this.orderService = orderService;

            this.cart = new Cart();

            this.sc = new Scanner(System.in);
        }

        public void customerMenu(User user) {

            while (true) {

                System.out.println("\n========== CUSTOMER MENU ==========");
                System.out.println("1. View Menu");
                System.out.println("2. Add To Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Remove From Cart");
                System.out.println("5. Place Order");
                System.out.println("0. Logout");

                System.out.print("Enter Choice : ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        viewMenu();
                        break;

                    case 2:
                        addToCart();
                        break;

                    case 3:
                        viewCart();
                        break;

                    case 4:
                        removeFromCart();
                        break;

                    case 5:
                        placeOrder(user);
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        }

        private void viewMenu() {

            menuService.displayMenu();
        }

        private void addToCart() {

            viewMenu();

            System.out.print("Enter Menu ID : ");
            String id = sc.nextLine();

            Menu menu = menuService.getMenuById(id);

            if (menu == null) {

                System.out.println("Invalid Menu ID.");
                return;
            }

            System.out.print("Quantity : ");
            int quantity = Integer.parseInt(sc.nextLine());

            cart.addItem(menu, quantity);

            System.out.println("Item Added To Cart.");
        }

        private void viewCart() {

            if (cart.isEmpty()) {

                System.out.println("Cart is Empty.");
                return;
            }

            for (CartItem item : cart.getItems()) {

                System.out.println(item.getMenu().getItemName()
                        + " x "
                        + item.getQuantity()
                        + " = ₹"
                        + (item.getMenu().getPrice() * item.getQuantity()));
            }

            System.out.println("----------------------");
            System.out.println("Total : ₹" + cart.getTotal());
        }

        private void removeFromCart() {

            System.out.print("Enter Menu ID : ");

            String id = sc.nextLine();

            cart.removeItem(id);

            System.out.println("Item Removed.");
        }

        private void placeOrder(User user) {

            if (cart.isEmpty()) {

                System.out.println("Cart is Empty.");
                return;
            }

            orderService.placeOrder(user, cart);

            System.out.println("Order Placed Successfully.");
        }

}
