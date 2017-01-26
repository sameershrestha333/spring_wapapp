package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByName(String name);

}
