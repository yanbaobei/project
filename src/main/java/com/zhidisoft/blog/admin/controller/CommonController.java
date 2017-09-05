package com.zhidisoft.blog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

	@GetMapping("/err")
	public String err() {
		return "/common/error.html";
	}
}
