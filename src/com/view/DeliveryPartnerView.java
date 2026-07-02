package com.view;

import com.model.Order;
import com.model.User;
import com.service.DeliveryPartnerService;

import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryPartnerView {



        private final DeliveryPartnerService service;
        private final Scanner sc;

        public DeliveryPartnerView(DeliveryPartnerService service){

            this.service = service;
            this.sc = new Scanner(System.in);
        }

        public void deliveryMenu(User partner){

            while(true){

                System.out.println("\n===== DELIVERY MENU =====");
                System.out.println("1.View Available Orders");
                System.out.println("2.Accept Order");
                System.out.println("3.View My Orders");
                System.out.println("4.Mark Picked Up");
                System.out.println("5.Mark Delivered");
                System.out.println("0.Logout");

                int choice=Integer.parseInt(sc.nextLine());

                switch(choice){

                    case 1:

                        showOrders(service.getAvailableOrders(partner));

                        break;

                    case 2:

                        System.out.print("Order ID : ");

                        System.out.println(
                                service.acceptOrder(sc.nextLine(),partner)
                                        ?
                                        "Accepted."
                                        :
                                        "Cannot Accept."
                        );

                        break;

                    case 3:

                        showOrders(service.getMyOrders(partner));

                        break;

                    case 4:

                        System.out.print("Order ID : ");

                        System.out.println(
                                service.markPickedUp(sc.nextLine(),partner)
                                        ?
                                        "Picked Up."
                                        :
                                        "Invalid."
                        );

                        break;

                    case 5:

                        System.out.print("Order ID : ");

                        System.out.println(
                                service.markDelivered(sc.nextLine(),partner)
                                        ?
                                        "Delivered."
                                        :
                                        "Invalid."
                        );

                        break;

                    case 0:

                        return;

                    default:

                        System.out.println("Invalid Choice.");
                }
            }
        }

        private void showOrders(ArrayList<Order> orders){

            if(orders.isEmpty()){

                System.out.println("No Orders.");

                return;
            }

            for(Order order:orders){

                System.out.println("----------------------");
                System.out.println("Order : "+order.getOrderId());
                System.out.println("Status : "+order.getStatus());
                System.out.println("Total : "+order.getTotalAmount());
            }

        }


}
