package com.tests.system.service.impl;

import com.tests.system.model.User;
import com.tests.system.model.UserRole;
import com.tests.system.repository.RoleRepository;
import com.tests.system.repository.UserRepository;
import com.tests.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception {
        User userToSave = userRepository.findByUsername(user.getUsername());
        if (userToSave != null) {
            System.out.println("The user already exists!");
            throw new Exception("The user already Exists!");
        } else {

            //Save roles
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }
            //Assign roles to user
            user.getUserRoles().addAll(userRoles);

            //Save user
            userToSave = userRepository.save(user);
        }
        return userToSave;
    }
}
