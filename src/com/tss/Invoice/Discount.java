package com.tss.Invoice;

import java.util.ArrayList;

public class Discount {
    public  double getDiscount(double totalamount){
        if(totalamount>500){
            return totalamount % 5 ;
        }
        return 0;
    }
}
