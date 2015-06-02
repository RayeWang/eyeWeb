package com.ray.controller.admin;

import java.util.ArrayList;
import java.util.List;

import com.ray.entity.Users;

public class UserDao {


	public Users getDatabase(String username) {

		List<Users> users = internalDatabase();

		for (Users dbUser : users) {
			if (dbUser.getUsername().equals(username) == true) {
				System.out.println("User found");
				return dbUser;
			}
		}
		System.out.println("User does not exist!");
		throw new RuntimeException("User does not exist!");

	}

	/**
	 * 初始化数据
	 */
	private List<Users> internalDatabase() {

		List<Users> users = new ArrayList<Users>();
		Users user = null;

		user = new Users();
		user.setUsername("admin");

		// "admin"经过MD5加密后
		user.setPassword("21232f297a57a5a743894a0e4a801fc3");

		users.add(user);

		user = new Users();
		user.setUsername("user");

		// "user"经过MD5加密后
		user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");

		users.add(user);

		return users;

	}
}
