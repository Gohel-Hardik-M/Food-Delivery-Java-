package com.tss.Services;

import com.tss.DB.DB;
import com.tss.Users.Users;

import java.util.Scanner;

public class UserService {


    private DB db;

    public UserService(DB db) {
        this.db = db;
    }

    public void registerAdmin() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();

        Users user = new Users(username, password, name, mobile, "ADMIN");
        db.AddUser(user);

        System.out.println("Admin Registered Successfully!");
    }



    public void registerCustomer() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();
        Users user = new Users(username, password, name, mobile, "CUSTOMER");
        db.AddUser(user);
        System.out.println("Customer Registered Successfully!");
    }



    public void createUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== CREATE USER =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Enter Role (ADMIN/CUSTOMER/DELIVERY_PARTNER): ");
        String role = sc.nextLine().toUpperCase();

        Users user = new Users(username, password, name, mobile, role);

        db.AddUser(user);

        System.out.println("User created successfully!");
    }


    public void registerDeliveryPartner() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();

        Users user = new Users(username, password, name, mobile, "DELIVERY_PARTNER");

        db.AddUser(user);

        System.out.println("Delivery Partner Registered Successfully!");
    }






    public Users login() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("--->> Enter Username: ");
            String username = sc.nextLine();

            System.out.print("--->> Enter Password: ");
            String password = sc.nextLine();

            for (Users user : db.getUsers()) {

                if (user.getUsername().equals(username)
                        && user.getPassword().equals(password)) {

                    System.out.println("** Login Successful! **");
                    return user;
                }
            }
            System.out.println("WARNING --->> Invalid Username or Password!");
            System.out.println("--------------------------------------------");
        }
    }

}
