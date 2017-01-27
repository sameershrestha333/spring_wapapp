package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String users(Model model) {
		// List<User> users=userService.findAll();
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/{id}")
	public String userDetails(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/users?success=true";
	}
}
