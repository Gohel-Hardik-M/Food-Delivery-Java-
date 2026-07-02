package com.model;

import java.util.Random;

public class User {

        private final String id;
        private final String username;
        private final String password;
        private final String name;
        private final String role;
        private final String mobile;

        public User(String username,
                    String password,
                    String name,
                    String mobile,
                    String role) {

            this.id = generateUserId();
            this.username = username;
            this.password = password;
            this.name = name;
            this.mobile = mobile;
            this.role = role;
        }

        private static String generateUserId() {
            Random random = new Random();
            return "USR" + (10000 + random.nextInt(90000));
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        public String getMobile() {
            return mobile;
        }

        public String getRole() {
            return role;
        }

}
