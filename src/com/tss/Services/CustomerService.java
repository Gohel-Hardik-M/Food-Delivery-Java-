package com.tss.Services;

import com.tss.Cart.Cart;
import com.tss.Cart.Order;
import com.tss.DB.DB;
import com.tss.Menu.Menu;
import com.tss.Users.Users;

import java.util.Scanner;

public class CustomerService {



    DB db;

    public  CustomerService(DB db){

        this.db= db;

    }
    Menu m = new Menu(db);
    OrderService o = new OrderService(db);


    private Scanner sc = new Scanner(System.in);




    public  void viewMenu() {
        db.DisplayMenu();
    }


    public void addToCart(Cart cart) {

            System.out.print("Enter Item ID: ");
            String id = sc.nextLine();

            Menu menu = db.getMenuById(id);

            if (menu == null) {
                System.out.println("Invalid Item ID!");
                return;
            }

            System.out.print("Enter Quantity: ");
            int qty = Integer.parseInt(sc.nextLine());

            cart.addItem(menu, qty);

            System.out.println("Item added to cart!");
    }


    public void viewCart(Cart cart) {

            System.out.println("\n========= CART =========");

            if (cart.getItems().isEmpty()) {
                System.out.println("Cart is empty!");
                return;
            }

            cart.getItems().forEach(item -> {
                System.out.println(
                        item.getMenu().getItemName()
                                + " x " + item.getQuantity()
                                + " = ₹" + (item.getMenu().getPrice() * item.getQuantity())
                );
            });

            System.out.println("----------------------");
            System.out.println("TOTAL: ₹" + cart.getTotal());
        }


        public void removeFromCart(Cart cart) {

            System.out.print("Enter Item ID to remove: ");
            String id = sc.nextLine();

            cart.removeItem(id);

            System.out.println("Item removed from cart!");
        }


        public void placeOrder(Users user, Cart cart) {

            o.placeOrder(user, cart);
        }


        public void customerMenu(Users user) {

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
                int choice = Integer.parseInt(sc.nextLine());

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
