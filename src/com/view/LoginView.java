package com.view;

import com.model.User;
import com.service.AuthenticationService;

import java.util.Scanner;

public class LoginView {


        private final AuthenticationService authenticationService;
        private final Scanner sc;

        public LoginView(AuthenticationService authenticationService) {
            this.authenticationService = authenticationService;
            this.sc = new Scanner(System.in);
        }

        public User login() {

            while (true) {

                System.out.println("\n========== LOGIN ==========");

                System.out.print("Username : ");
                String username = sc.nextLine();

                System.out.print("Password : ");
                String password = sc.nextLine();

                User user = authenticationService.login(username, password);

                if (user != null) {

                    System.out.println("Login Successful!");

                    return user;
                }

                System.out.println("Invalid Username or Password.");
            }
        }


}
