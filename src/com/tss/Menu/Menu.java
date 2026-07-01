package com.tss.Menu;

import com.tss.DB.DB;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private  String id;
    private String menuType;
    private String itemName;
    private double price;

    private  Menu m;

    DB db;
    public  Menu(String type,String item_name, double price){
        this.id =generateItemId();
        this.menuType = type;
        this.itemName=item_name;
        this.price = price;

    }

    public  Menu(DB db){
        this.db = db;

    }

    public static String generateItemId() {
        Random random = new Random();
        return "ITEM" + (10000 + random.nextInt(90000));
    }

    public String getId() {
        return id;
    }



    public  String getMenuType(){
        return menuType;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }



    Scanner sc = new Scanner(System.in);
    public  void  addMenuItem(){

            System.out.println("--->> Enter Menu Type :");
            String menu_type = sc.next().toLowerCase();
            System.out.println("--->> Enter Item Name :");
            String item_name = sc.next().toLowerCase();
            System.out.println("--->> Enter Price :");
            double item_price = sc.nextInt();

            m = new Menu(menu_type,item_name,item_price);
            db.addMenu(m);
            System.out.println("------------------------");
            System.out.println("  Item Added Successfully !");
    }







}
