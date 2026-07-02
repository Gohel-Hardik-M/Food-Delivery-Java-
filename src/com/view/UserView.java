package com.view;

import java.util.Scanner;

public class UserView {


        private final Scanner scanner;

        public UserView(Scanner scanner) {
            this.scanner = scanner;
        }

        public String getUsername() {

            System.out.print("Enter Username: ");
            return scanner.nextLine();
        }

        public String getPassword() {

            System.out.print("Enter Password: ");
            return scanner.nextLine();
        }

        public String getName() {

            System.out.print("Enter Name: ");
            return scanner.nextLine();
        }

        public String getMobile() {

            System.out.print("Enter Mobile: ");
            return scanner.nextLine();
        }

        public String getRole() {

            System.out.print("Enter Role (ADMIN/CUSTOMER/DELIVERY_PARTNER): ");
            return scanner.nextLine();
        }

}
