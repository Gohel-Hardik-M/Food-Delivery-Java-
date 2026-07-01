package com.tss.Payment;

import java.util.Scanner;

public class UPI implements PaymentInterface {

    Scanner sc = new Scanner(System.in);
    @Override
    public boolean Pay() {

        while (true){
            System.out.println();
            System.out.println("--->> Enter Your UPI :");
            String user_upi = sc.next();
            System.out.println();
            System.out.println("--->> Accept & Pay (y/n) :");
            String accept = sc.next();
            if(accept.toLowerCase() == "y" || accept.toLowerCase() == "yes") {
                System.out.println("Payment Successfull !!");
                return true;
            }
            return false;
        }
    }
}
