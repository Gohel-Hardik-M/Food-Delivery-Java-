package com.service;

import com.repository.RoleRepository;

import java.util.ArrayList;

public class RoleService {


        private final RoleRepository roleRepository;

        public RoleService(RoleRepository roleRepository) {
            this.roleRepository = roleRepository;
        }

        public void addRole(String role) {
            roleRepository.addRole(role);
        }

        public ArrayList<String> getRoles() {
            return roleRepository.getRoles();
        }

}
