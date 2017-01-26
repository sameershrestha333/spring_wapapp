package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service
@Transactional
public class InitDbService {

	@Autowired
	private RoleDao roleDao;
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@PostConstruct
	public void init(){
		
		Role roleUser=new Role();
		roleUser.setName("ROLE_USER");
		roleDao.save(roleUser);
		
		Role roleAdmin=new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleDao.save(roleAdmin);
		
		User userAdmin=new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		
		List<Role> roles=new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userDao.save(userAdmin);
		
		Blog blogJSF=new Blog();
		blogJSF.setName("Modern JSF");
		blogJSF.setUrl("https://www.tutorialspoint.com/jsf/");
		blogJSF.setUser(userAdmin);
		blogDao.save(blogJSF);
		
		Item item1=new Item();
		item1.setBlog(blogJSF);
		item1.setTitle("JavaTpoint");
		item1.setLink("http://www.javatpoint.com/");
		item1.setPublishedDate(new Date());
		
		Item item2=new Item();
		item2.setBlog(blogJSF);
		item2.setTitle("Bootstrap");
		item2.setLink("http://getbootstrap.com/");
		item2.setPublishedDate(new Date());
		
		itemDao.save(item1);
		itemDao.save(item2);
	}
	
}
