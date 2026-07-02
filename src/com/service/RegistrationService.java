package com.service;

import com.model.User;
import com.repository.UserRepository;

public class RegistrationService {




        private final UserRepository repository;

        public RegistrationService(UserRepository repository) {
            this.repository = repository;
        }

        public void registerAdmin(String username,
                                  String password,
                                  String name,
                                  String mobile) {

            User user = new User(username, password, name, mobile, "ADMIN");
            repository.addUser(user);

            System.out.println("Admin Registered Successfully!");
        }

        public void registerCustomer(String username,
                                     String password,
                                     String name,
                                     String mobile) {

            User user = new User(username, password, name, mobile, "CUSTOMER");
            repository.addUser(user);

            System.out.println("Customer Registered Successfully!");
        }

        public void registerDeliveryPartner(String username,
                                            String password,
                                            String name,
                                            String mobile) {

            User user = new User(username, password, name, mobile, "DELIVERY_PARTNER");
            repository.addUser(user);

            System.out.println("Delivery Partner Registered Successfully!");
        }

        public void createUser(String username,
                               String password,
                               String name,
                               String mobile,
                               String role) {

            User user = new User(username, password, name, mobile, role.toUpperCase());

            repository.addUser(user);

            System.out.println("User created successfully!");
        }

}
