package com.service;

import com.model.User;
import com.repository.UserRepository;

public class AuthenticationService {




        private final UserRepository repository;

        public AuthenticationService(UserRepository repository) {
            this.repository = repository;
        }

        public User login(String username, String password) {

            for (User user : repository.getUsers()) {

                if (user.getUsername().equals(username)
                        && user.getPassword().equals(password)) {

                    return user;
                }
            }

            return null;
        }

}
