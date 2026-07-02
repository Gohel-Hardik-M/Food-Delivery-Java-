package com.view;

import com.service.RegistrationService;

import java.util.Scanner;

public class RegisterView {


        private final RegistrationService registrationService;
        private final Scanner sc;

        public RegisterView(RegistrationService registrationService) {

            this.registrationService = registrationService;
            this.sc = new Scanner(System.in);
        }

        public void showRegistrationMenu() {

            while (true) {

                System.out.println("\n========== REGISTER ==========");
                System.out.println("1. Register Customer");
                System.out.println("2. Register Delivery Partner");
                System.out.println("3. Register Admin");
                System.out.println("0. Back");

                System.out.print("Enter Choice : ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        registerCustomer();
                        break;

                    case 2:
                        registerDeliveryPartner();
                        break;

                    case 3:
                        registerAdmin();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        }

        private void registerCustomer() {

            System.out.print("Username : ");
            String username = sc.nextLine();

            System.out.print("Password : ");
            String password = sc.nextLine();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Mobile : ");
            String mobile = sc.nextLine();

            registrationService.registerCustomer(username, password, name, mobile);

            System.out.println("Customer Registered Successfully.");
        }

        private void registerDeliveryPartner() {

            System.out.print("Username : ");
            String username = sc.nextLine();

            System.out.print("Password : ");
            String password = sc.nextLine();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Mobile : ");
            String mobile = sc.nextLine();

            registrationService.registerDeliveryPartner(username, password, name, mobile);

            System.out.println("Delivery Partner Registered Successfully.");
        }

        private void registerAdmin() {

            System.out.print("Username : ");
            String username = sc.nextLine();

            System.out.print("Password : ");
            String password = sc.nextLine();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Mobile : ");
            String mobile = sc.nextLine();

            registrationService.registerAdmin(username, password, name, mobile);

            System.out.println("Admin Registered Successfully.");
        }

}
