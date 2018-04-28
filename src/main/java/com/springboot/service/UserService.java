package com.springboot.service;


import java.util.List;

import com.springboot.model.AppUser;

public interface UserService {
	
	AppUser findById(int id);

	AppUser findByName(String name);

	void saveUser(AppUser user);

	void updateUser(AppUser user);

	void deleteUserById(int id);

	void deleteAllUsers();

	List<AppUser> findAllUsers();

	boolean isUserExist(AppUser user);
}