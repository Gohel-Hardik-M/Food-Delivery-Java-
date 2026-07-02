package com.repository;

import java.util.ArrayList;

public class RoleRepository {

    private final ArrayList<String> roles = new ArrayList<>();

    public void addRole(String role) {
        roles.add(role);
    }

    public ArrayList<String> getRoles() {
        return roles;
    }
}
