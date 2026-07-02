package com;

import com.Invoice.GenerateInvoice;
import com.model.User;
import com.repository.*;
import com.service.*;
import com.view.*;

import java.util.Scanner;

public class FDApp {

        public static void main(String[] args) {

            //=========================
            // Repositories
            //=========================

            UserRepository userRepository = new UserRepository();
            MenuRepository menuRepository = new MenuRepository();
            OrderRepository orderRepository = new OrderRepository();
            StockRepository stockRepository = new StockRepository();
            RoleRepository roleRepository = new RoleRepository();

            //=========================
            // Services
            //=========================

            RegistrationService registrationService =
                    new RegistrationService(userRepository);

            AuthenticationService authenticationService =
                    new AuthenticationService(userRepository);

            MenuService menuService =
                    new MenuService(menuRepository);

            StockService stockService =
                    new StockService(stockRepository);

            RoleService roleService =
                    new RoleService(roleRepository);

            GenerateInvoice invoice = new GenerateInvoice();

            OrderService orderService =
                    new OrderService(
                            orderRepository,
                            invoice,
                            userRepository
                    );

            AdminService adminService =
                    new AdminService(
                            registrationService,
                            menuService,
                            stockService,
                            roleService,
                            userRepository,
                            menuRepository,
                            orderRepository
                    );

            DeliveryPartnerService deliveryPartnerService =
                    new DeliveryPartnerService(orderRepository);

            //=========================
            // Views
            //=========================

            RegisterView registerView =
                    new RegisterView(registrationService);

            LoginView loginView =
                    new LoginView(authenticationService);

            CustomerView customerView =
                    new CustomerView(menuService, orderService);

            AdminView adminView =
                    new AdminView(adminService);

            DeliveryPartnerView deliveryPartnerView =
                    new DeliveryPartnerView(deliveryPartnerService);

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n=================================");
                System.out.println("   FOOD DELIVERY MANAGEMENT");
                System.out.println("=================================");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");

                System.out.print("Enter Choice : ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        registerView.showRegistrationMenu();
                        break;

                    case 2:

                        User user = loginView.login();

                        if (user == null) {

                            System.out.println("Invalid Username or Password.");
                            break;
                        }

                        switch (user.getRole().toUpperCase()) {

                            case "ADMIN":
                                adminView.adminMenu(user);
                                break;

                            case "CUSTOMER":
                                customerView.customerMenu(user);
                                break;

                            case "DELIVERY_PARTNER":
                                deliveryPartnerView.deliveryMenu(user);
                                break;

                            default:
                                System.out.println("Unknown Role.");
                        }

                        break;

                    case 0:

                        System.out.println("Thank You!");
                        return;

                    default:

                        System.out.println("Invalid Choice.");
                }
            }
        }

}
