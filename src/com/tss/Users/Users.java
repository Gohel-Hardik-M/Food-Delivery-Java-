package com.tss.Users;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Users {

    private String id;
    private String username;
    private String password;
    private String name;
    private String role;
    private  String mobile;




    public Users(String username, String password, String name,String mobile, String role) {
        this.id = generateUserId();
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.name = name;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public static String generateUserId() {
        Random random = new Random();
        return "USR" + (10000 + random.nextInt(90000));
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

}
