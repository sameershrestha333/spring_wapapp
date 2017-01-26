package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

	@RequestMapping("/")
	public String home() {

		// return "redirect:/login";
		return "redirect:/index";

	}

	@RequestMapping("/index")
	public String home1() {

		// return "redirect:/login";
		return "index";

	}

}
