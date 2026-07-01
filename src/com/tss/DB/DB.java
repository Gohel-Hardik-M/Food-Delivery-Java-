package com.tss.DB;

import com.tss.Cart.Order;
import com.tss.Menu.Menu;
import com.tss.Users.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB {
    private ArrayList<String> roles= new ArrayList<>();
    private  ArrayList<Menu> allmenu = new ArrayList<>();

    private  ArrayList<Users> users = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    private HashMap<String,Integer> stock = new HashMap<>();
    private  ArrayList<String> notifications = new ArrayList<>();


    public ArrayList<String> allNotifications() {


        //dummyyyy data
        stock.put("Wheat", 25);
        stock.put("Milk", 8);
        stock.put("Curd", 5);
        stock.put("Chilly Powder", 15);
        stock.put("Potato", 3);
        stock.put("Coke", 20);
        stock.put("Ice Cream", 6);
        stock.put("Noodles", 30);
        stock.put("Mango", 9);
        stock.put("Wrap", 12);



        for (Map.Entry<String, Integer> entry : stock.entrySet()) {

            String item = entry.getKey();
            int qty = entry.getValue();

            if (qty < 10) {
                String msg = "Item at LOW STOCK: " + item + " - Only " + qty + " Units Available";
                notifications.add(msg);
            }
        }
        return notifications;
    }







    public  void add_update_stock(String item,int quantity){
        stock.put(item,quantity);
    }

    public  void search_stock(String item){
        if(stock.containsKey(item)){
            System.out.println(" | "+item+" | "+stock.get(item)+ " |");
        }
    }


    public void  AddUser(Users user){
        users.add(user);
    }


    public  ArrayList<Users> getUsers(){
        return  users;
    }

    public void AddRole(String rolename){
        roles.add(rolename);
        System.out.println("------------- Role Added Successfully !");
    }


    public Menu getMenuById(String id) {
        for (Menu menu : allmenu) {
            if (menu.getId().equals(id)) {
                return menu;
            }
        }
        return null;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }





    public void  addMenu(Menu m){
        allmenu.add(m);
    }

    public ArrayList<Menu> getAllmenu(){
        return allmenu;
    }


    public void addOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }



    public  void  DisplayMenu(){


        System.out.println("\n===== MENU ITEMS =====");

        if (getAllmenu().isEmpty()) {
            System.out.println("No menu items found!");
            return;
        }

        for (Menu menu : getAllmenu()) {
            System.out.printf(
                    "ID: %s | Type: %s | Item: %s | Price: ₹%.2f%n",
                    menu.getId(),
                    menu.getMenuType(),
                    menu.getItemName(),
                    menu.getPrice()
            );
        }
    }


}
