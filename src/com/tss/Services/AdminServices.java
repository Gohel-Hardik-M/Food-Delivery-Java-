package com.tss.Services;

import com.tss.Cart.Order;
import com.tss.DB.DB;
import com.tss.Menu.Menu;
import com.tss.Users.Users;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminServices {


        UserService us;
        DB db;


        Scanner sc = new Scanner(System.in);
        public  AdminServices(UserService us, DB db){
            this.db = db;
            this.us = us;
        }


public  void  searchStock(){
    System.out.println("\n====== STOCK SEARCH =======");
    System.out.println("\n --->> Enter Item Name to Search in Stock :");
    String item = sc.nextLine();
    System.out.println();
    db.search_stock(item);
}

public  void add_update_stock(){
    System.out.println("\n====== STOCK Update =======");
    System.out.println("\n --->> Enter Item Name to add in Stock :");
    String item = sc.nextLine();
    System.out.println("\n --->> Enter Available Quantity :");
    int quantity = sc.nextInt();
    db.add_update_stock(item,quantity);
}


      public  void systemNotifications(){
          ArrayList<String> notifications = db.allNotifications();
          for(String notification : notifications){
              System.out.println("            * "+notification);
          }
      }


        public void viewUsers() {

            System.out.println("\n===== ALL USERS =====");

            if (db.getUsers().isEmpty()) {
                System.out.println("No users found!");
                return;
            }

            db.getUsers().forEach(user -> {
                System.out.println(user);
            });
        }


        public void addUser() {
            us.createUser();
        }


        public void viewMenu() {
            db.DisplayMenu();

        }


        public void addMenuItem() {

            System.out.print("Enter Menu Type: ");
            String type = sc.nextLine().toLowerCase();

            System.out.print("Enter Item Name: ");
            String name = sc.nextLine().toLowerCase();

            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine());

            Menu menu = new Menu(type, name, price);
            db.addMenu(menu);

            System.out.println("Menu item added successfully!");
        }


        public void deleteMenuItem() {

            System.out.print("Enter Menu ID to delete: ");
            String id = sc.nextLine();

            Menu menu = db.getMenuById(id);

            if (menu == null) {
                System.out.println("Invalid Menu ID!");
                return;
            }

            db.getAllmenu().remove(menu);

            System.out.println("Menu item deleted successfully!");
        }


        public void addRole() {

            System.out.print("Enter Role Name: ");
            String role = sc.nextLine();

            db.AddRole(role);
        }




        public void viewOrders() {

            System.out.println("\n===== ALL ORDERS =====");

            if (db.getOrders().isEmpty()) {
                System.out.println("No orders found!");
                return;
            }
            ArrayList<Order> allorders = db.getOrders();
            for(Order order : allorders) {
                System.out.println(order);
            }
        }


        public void adminMenu(Users admin) {

            while (true) {

                System.out.println("\n===== ADMIN MENU =====");
                System.out.println("==== USERS ====\n");
                System.out.println("1 -> View Users");
                System.out.println("2 -> Add User\n");
                System.out.println("==== MENU ====\n");
                System.out.println("3 -> View Menu");
                System.out.println("4 -> Add Menu Item");
                System.out.println("5 -> Delete Menu Item");
                System.out.println("6 -> Add Role\n");
                System.out.println("==== ORDERS ====\n");
                System.out.println("7 -> View Orders\n");
                System.out.println("==== STOCK ====\n");
                System.out.println("8 -> Search Item in Stock");
                System.out.println("9 -> Add Update Stock\n");
                System.out.println("==== NOTIFICATIONS ====\n");
                System.out.println("10 -> Check Notifications");


                System.out.println("0 -> Logout");

                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 10:
                        systemNotifications();
                    case 9:
                        add_update_stock();
                        break;
                    case 8:
                        searchStock();
                        break;

                    case 1:
                        viewUsers();
                        break;

                    case 2:
                        addUser();
                        break;

                    case 3:
                        viewMenu();
                        break;

                    case 4:
                        addMenuItem();
                        break;

                    case 5:
                        deleteMenuItem();
                        break;

                    case 6:
                        addRole();
                        break;

                    case 7:
                        viewOrders();
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
