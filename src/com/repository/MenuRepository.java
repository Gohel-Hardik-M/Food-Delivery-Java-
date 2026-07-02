package com.repository;

import com.model.Menu;

import java.util.ArrayList;

public class MenuRepository {

    private final ArrayList<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public ArrayList<Menu> getAllMenu() {
        return menus;
    }

    public Menu getMenuById(String id) {

        for (Menu menu : menus) {
            if (menu.getId().equals(id)) {
                return menu;
            }
        }

        return null;
    }
}
