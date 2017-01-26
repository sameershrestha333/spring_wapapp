package com.example.service;

import com.example.entity.Blog;

public interface BlogService {
	void save(Blog blog, String name);

	void delete(int id);

	Blog findOne(int id);

	void delete(Blog blog);
}
