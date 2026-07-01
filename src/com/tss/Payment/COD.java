package com.tss.Payment;

public class COD implements PaymentInterface{
    @Override
    public boolean Pay() {
        System.out.println();
        System.out.println("---->> Pay On Delivery");
        System.out.println("======================================");
        return false;
    }
}
