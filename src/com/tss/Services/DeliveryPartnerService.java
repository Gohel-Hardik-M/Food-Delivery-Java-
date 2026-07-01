package com.tss.Services;

import com.tss.Cart.Order;
import com.tss.DB.DB;
import com.tss.Users.Users;

import java.util.Scanner;

public class DeliveryPartnerService {

    DB db;
 public  DeliveryPartnerService(DB db){
     this.db = db;
    }




        private Scanner sc = new Scanner(System.in);



        public void viewAvailableOrders() {

            System.out.println("\n===== AVAILABLE ORDERS =====");

            boolean found = false;

            for (Order order : db.getOrders()) {

                if (order.getStatus().equalsIgnoreCase("Pending")) {

                    System.out.println("--------------------------------");
                    System.out.println("Order ID : " + order.getOrderId());
                    System.out.println("Status   : " + order.getStatus());

                    found = true;
                }
            }

            if (!found) {
                System.out.println("No pending orders.");
            }
        }

        public void acceptOrder() {

            System.out.print("Enter Order ID: ");
            String id = sc.nextLine();

            for (Order order : db.getOrders()) {

                if (order.getOrderId().equals(id)
                        && order.getStatus().equalsIgnoreCase("Pending")) {

                    order.setStatus("Accepted");

                    System.out.println("Order accepted successfully.");
                    return;
                }
            }

            System.out.println("Order not found.");
        }

        public void markPickedUp() {

            System.out.print("Enter Order ID: ");
            String id = sc.nextLine();

            for (Order order : db.getOrders()) {

                if (order.getOrderId().equals(id)
                        && order.getStatus().equalsIgnoreCase("Accepted")) {

                    order.setStatus("Picked Up");

                    System.out.println("Order picked up.");
                    return;
                }
            }

            System.out.println("Invalid Order.");
        }

        public void markDelivered() {

            System.out.print("Enter Order ID: ");
            String id = sc.nextLine();

            for (Order order : db.getOrders()) {

                if (order.getOrderId().equals(id)
                        && order.getStatus().equalsIgnoreCase("Picked Up")) {

                    order.setStatus("Delivered");

                    System.out.println("Order delivered successfully.");
                    return;
                }
            }

            System.out.println("Invalid Order.");
        }

        public void viewMyOrders() {

            System.out.println("\n===== ORDERS =====");

            if (db.getOrders().isEmpty()) {

                System.out.println("No Orders.");
                return;
            }

            for (Order order : db.getOrders()) {

                System.out.println("--------------------------------");
                System.out.println("Order ID : " + order.getOrderId());
                System.out.println("Status   : " + order.getStatus());
            }
        }

        public void deliveryMenu(Users user) {

            while (true) {

                System.out.println("\n===== DELIVERY PARTNER MENU =====");
                System.out.println("1 -> View Available Orders");
                System.out.println("2 -> Accept Order");
                System.out.println("3 -> View Orders");
                System.out.println("4 -> Mark Picked Up");
                System.out.println("5 -> Mark Delivered");
                System.out.println("0 -> Logout");

                System.out.print("Enter choice : ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        viewAvailableOrders();
                        break;

                    case 2:
                        acceptOrder();
                        break;

                    case 3:
                        viewMyOrders();
                        break;

                    case 4:
                        markPickedUp();
                        break;

                    case 5:
                        markDelivered();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        }


}
