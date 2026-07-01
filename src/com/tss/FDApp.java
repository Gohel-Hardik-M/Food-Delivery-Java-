package com.tss;

import com.tss.Cart.Order;
import com.tss.DB.DB;
import com.tss.Services.AdminServices;
import com.tss.Services.CustomerService;
import com.tss.Services.DeliveryPartnerService;
import com.tss.Services.UserService;
import com.tss.Users.Users;

import java.util.Scanner;

public class FDApp {
    public static void main(String[] args) {
        DB db = new DB();

        UserService s1 = new UserService(db);
        Scanner sc = new Scanner(System.in);

        CustomerService cs = new CustomerService(db);
        AdminServices as = new AdminServices(s1,db);
        DeliveryPartnerService dl1 = new DeliveryPartnerService(db);


        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1 --> Login");
            System.out.println("2 --> Register Admin");
            System.out.println("3 --> Register Delivery Partner");
            System.out.println("4 --> Register Customer");
            System.out.println("0 --> Exit");
            System.out.print("Enter choice: ");

            int user_choice = sc.nextInt();
            sc.nextLine();

            switch (user_choice) {

                case 1:
                    Users loggedinUser= s1.login();
                    if(loggedinUser.getRole().equalsIgnoreCase("CUSTOMER")){
                        cs.customerMenu(loggedinUser);
                    }
                    if (loggedinUser.getRole().equalsIgnoreCase("ADMIN")){

                        as.adminMenu(loggedinUser);
                    }
                    if(loggedinUser.getRole().equalsIgnoreCase("DELIVERY_PARTNER")){
                        dl1.deliveryMenu(loggedinUser);
                    }
                    break;

                case 2:
                    s1.registerAdmin();
                    break;

                case 3:
                    s1.registerDeliveryPartner();
                    break;

                case 4:
                    s1.registerCustomer();
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }


    }
}
