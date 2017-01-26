package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Blog;
import com.example.entity.Item;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.BlogDao;
import com.example.repository.ItemDao;
import com.example.repository.RoleDao;
import com.example.repository.UserDao;
import com.example.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<User> findAll() {

		return userDao.findAll();
	}

	@Override
	public User findOne(int id) {

		return userDao.findOne(id);
	}

	@Override
	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogDao.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemDao.findByBlog(blog,new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);

		}

		user.setBlogs(blogs);
		return user;
	}

	@Override
	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles=new ArrayList<Role>();
		roles.add(roleDao.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userDao.save(user);

	}

	@Override
	public User findOneWithBlogs(String name) {
	
		User user= userDao.findByName(name);
		
		return findOneWithBlogs(user.getId());
	}

}
