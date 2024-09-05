package com.infy.userdata.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.userdata.entity.User;

public interface UserDataRepository extends CrudRepository<User, Integer>{
    List<User> findByUserName(String userName);
    // For the exam 
    List<User> findByPassword(String password);
	
}
