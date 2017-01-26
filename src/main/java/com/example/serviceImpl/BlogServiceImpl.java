package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Blog;
import com.example.entity.User;
import com.example.repository.BlogDao;
import com.example.repository.UserDao;
import com.example.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public void save(Blog blog, String name) {
	 User user=	userDao.findByName(name);
	 blog.setUser(user);
	 blogDao.save(blog);
	}

}
