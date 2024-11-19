package com.tests.system.service;

import com.tests.system.model.User;
import com.tests.system.model.UserRole;

import java.util.Set;


public interface UserService {

    User saveUser(User user, Set<UserRole> userRoles) throws Exception;

    User getUser(String username);

    void deleteUser(Long id);

}
