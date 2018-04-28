package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.AppUser;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

	AppUser findByName(String name);

}
