package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
