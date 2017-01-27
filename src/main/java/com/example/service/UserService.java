package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
	List<User> findAll();

	User findOne(int id);

	User findOneWithBlogs(int id);

	void save(User user);

	User findOneWithBlogs(String name);

	void delete(int id);

	User findOne(String username);

}
