package com.service;

import com.model.Menu;
import com.model.Order;
import com.model.User;
import com.repository.MenuRepository;
import com.repository.OrderRepository;
import com.repository.UserRepository;

import java.util.ArrayList;

public class AdminService {


        private final RegistrationService userService;
        private final MenuService menuService;
        private final StockService stockService;
        private final RoleService roleService;

        private final UserRepository userRepository;
        private final MenuRepository menuRepository;
        private final OrderRepository orderRepository;

        public AdminService(RegistrationService userService,
                            MenuService menuService,
                            StockService stockService,
                            RoleService roleService,
                            UserRepository userRepository,
                            MenuRepository menuRepository,
                            OrderRepository orderRepository) {

            this.userService = userService;
            this.menuService = menuService;
            this.stockService = stockService;
            this.roleService = roleService;

            this.userRepository = userRepository;
            this.menuRepository = menuRepository;
            this.orderRepository = orderRepository;
        }

        // ---------------- USER ----------------

        public ArrayList<User> getAllUsers() {
            return userRepository.getUsers();
        }

        public void createUser(String username,
                               String password,
                               String name,
                               String mobile,
                               String role) {

            userService.createUser(username, password, name, mobile, role);
        }

        // ---------------- MENU ----------------

        public ArrayList<Menu> getAllMenu() {
            return menuRepository.getAllMenu();
        }

        public void addMenuItem(String type,
                                String itemName,
                                double price) {

            menuService.addMenuItem(type, itemName, price);
        }

        public boolean deleteMenuItem(String menuId) {

            Menu menu = menuRepository.getMenuById(menuId);

            if (menu == null) {
                return false;
            }

            menuRepository.getAllMenu().remove(menu);
            return true;
        }

        // ---------------- ROLE ----------------

        public void addRole(String role) {
            roleService.addRole(role);
        }

        // ---------------- STOCK ----------------

        public Integer searchStock(String item) {
            return stockService.searchStock(item);
        }

        public void addOrUpdateStock(String item,
                                     int quantity) {

            stockService.addOrUpdateStock(item, quantity);
        }

        public ArrayList<String> getNotifications() {
            return stockService.getLowStockNotifications();
        }

        // ---------------- ORDER ----------------

        public ArrayList<Order> getAllOrders() {
            return orderRepository.getOrders();
        }

}
