package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@Override
	public void delete(int id) {
		blogDao.delete(id);
	}

	@Override
	public Blog findOne(int id) {
		
		return blogDao.findOne(id);
	}

	@Override
	@PreAuthorize("#blog.user.name==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogDao.delete(blog);
	}

}
