package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/loginpage")
	public String login() {
		return "loginpage";
	}

	// Logout mapping
	@RequestMapping("/logout")
	public String showLoggedout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
}
