package com.view;

import com.model.Menu;
import com.model.Order;
import com.model.User;
import com.service.AdminService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {



        private final AdminService adminService;
        private final Scanner sc;

        public AdminView(AdminService adminService) {
            this.adminService = adminService;
            this.sc = new Scanner(System.in);
        }

        public void adminMenu(User admin) {

            while (true) {

                System.out.println("\n========== ADMIN MENU ==========");
                System.out.println("1. View Users");
                System.out.println("2. Add User");
                System.out.println("3. View Menu");
                System.out.println("4. Add Menu Item");
                System.out.println("5. Delete Menu Item");
                System.out.println("6. Add Role");
                System.out.println("7. View Orders");
                System.out.println("8. Search Stock");
                System.out.println("9. Add / Update Stock");
                System.out.println("10. View Notifications");
                System.out.println("0. Logout");

                System.out.print("Enter Choice : ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        viewUsers();
                        break;

                    case 2:
                        createUser();
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

                    case 8:
                        searchStock();
                        break;

                    case 9:
                        updateStock();
                        break;

                    case 10:
                        viewNotifications();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        }

        private void createUser() {

            System.out.print("Username : ");
            String username = sc.nextLine();

            System.out.print("Password : ");
            String password = sc.nextLine();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Mobile : ");
            String mobile = sc.nextLine();

            System.out.print("Role : ");
            String role = sc.nextLine().toUpperCase();

            adminService.createUser(username, password, name, mobile, role);

            System.out.println("User Created Successfully.");
        }

        private void viewUsers() {

            ArrayList<User> users = adminService.getAllUsers();

            if (users.isEmpty()) {

                System.out.println("No Users Found.");
                return;
            }

            for (User user : users) {

                System.out.println("-----------------------------------");
                System.out.println("ID       : " + user.getId());
                System.out.println("Name     : " + user.getName());
                System.out.println("Username : " + user.getUsername());
                System.out.println("Mobile   : " + user.getMobile());
                System.out.println("Role     : " + user.getRole());
            }
        }

        private void viewMenu() {

            ArrayList<Menu> menus = adminService.getAllMenu();

            if (menus.isEmpty()) {

                System.out.println("No Menu Items Available.");
                return;
            }

            for (Menu menu : menus) {

                System.out.println("-----------------------------------");
                System.out.println("ID    : " + menu.getId());
                System.out.println("Type  : " + menu.getMenuType());
                System.out.println("Item  : " + menu.getItemName());
                System.out.println("Price : ₹" + menu.getPrice());
            }
        }

        private void addMenuItem() {

            System.out.print("Menu Type : ");
            String type = sc.nextLine();

            System.out.print("Item Name : ");
            String item = sc.nextLine();

            System.out.print("Price : ");
            double price = Double.parseDouble(sc.nextLine());

            adminService.addMenuItem(type, item, price);

            System.out.println("Menu Item Added.");
        }

        private void deleteMenuItem() {

            System.out.print("Enter Menu ID : ");

            String id = sc.nextLine();

            if (adminService.deleteMenuItem(id)) {

                System.out.println("Menu Deleted Successfully.");
            }
            else {

                System.out.println("Menu Not Found.");
            }
        }

        private void addRole() {

            System.out.print("Role Name : ");

            String role = sc.nextLine().toUpperCase();

            adminService.addRole(role);

            System.out.println("Role Added Successfully.");
        }

        private void searchStock() {

            System.out.print("Enter Item Name : ");

            String item = sc.nextLine();

            Integer qty = adminService.searchStock(item);

            if (qty == null) {

                System.out.println("Item Not Found.");
            }
            else {

                System.out.println(item + " : " + qty);
            }
        }

        private void updateStock() {

            System.out.print("Item Name : ");

            String item = sc.nextLine();

            System.out.print("Quantity : ");

            int qty = Integer.parseInt(sc.nextLine());

            adminService.addOrUpdateStock(item, qty);

            System.out.println("Stock Updated Successfully.");
        }

        private void viewNotifications() {

            ArrayList<String> notifications = adminService.getNotifications();

            if (notifications.isEmpty()) {

                System.out.println("No Notifications.");
                return;
            }

            for (String notification : notifications) {

                System.out.println(notification);
            }
        }

        private void viewOrders() {

            ArrayList<Order> orders = adminService.getAllOrders();

            if (orders.isEmpty()) {

                System.out.println("No Orders Found.");
                return;
            }

            for (Order order : orders) {

                System.out.println("-----------------------------------");
                System.out.println("Order ID : " + order.getOrderId());
                System.out.println("User ID  : " + order.getUserId());
                System.out.println("Status   : " + order.getStatus());
                System.out.println("Total    : ₹" + order.getTotalAmount());
            }
        }

}
