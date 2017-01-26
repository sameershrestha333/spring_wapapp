package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Blog;
import com.example.entity.User;

public interface BlogDao extends JpaRepository<Blog, Integer>{
			List<Blog> findByUser(User user);
}
