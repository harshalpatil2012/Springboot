package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.AppUser;
import com.springboot.repositories.UserRepository;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public AppUser findById(int id) {
		return userRepository.findOne(id);
	}

	public AppUser findByName(String name) {
		return userRepository.findByName(name);
	}

	public AppUser saveUser(AppUser user) {
		return userRepository.save(user);
	}

	public void updateUser(AppUser user){
		saveUser(user);
	}

	public void deleteUserById(int id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<AppUser> findAllUsers(){
		return userRepository.findAll();
	}

	public boolean isUserExist(AppUser user) {
		return findByName(user.getName()) != null;
	}

	

}
