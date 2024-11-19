package com.tests.system;

import com.tests.system.model.Role;
import com.tests.system.model.User;
import com.tests.system.model.UserRole;
import com.tests.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TestsSystemBackendApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TestsSystemBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("David");
		user.setLastname("Gonzalez");
		user.setUsername("DaGonz");
		user.setPassword("123456");
		user.setEmail("d1@gmail.com");
		user.setPhone("123654975");
		user.setProfile("foto.png");

		Role role = new Role();
		role.setId(1L);
		role.setName("ADMIN");

		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRole);

		User savedUser = userService.saveUser(user, userRoles);
		System.out.println(savedUser.getUsername());
	}
}
