package com.repository;

import com.model.User;

import java.util.ArrayList;

public class UserRepository {

    private final ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
