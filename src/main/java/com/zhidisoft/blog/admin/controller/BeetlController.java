package com.zhidisoft.blog.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.blog.admin.service.IArticleService;

/**
 * http://ibeetl.com/guide/#beetl
 * @author REN
 *
 */
@Controller
public class BeetlController {
	
	@Autowired
	IArticleService articleService;

	@GetMapping("/beetl")
	public ModelAndView index(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize) {
		return new ModelAndView("article/list.html", "list", articleService.findPage(pageNum, pageSize)); // 省代码(视图解析器)
	}
	
	
}
