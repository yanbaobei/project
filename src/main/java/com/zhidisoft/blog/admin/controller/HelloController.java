package com.zhidisoft.blog.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.blog.admin.service.IArticleService;
import com.zhidisoft.blog.admin.vo.PageVo;
import com.zhidisoft.blog.admin.vo.UserVo;

@Controller
public class HelloController {

	@Autowired
	IArticleService articleService;

	@GetMapping("/hello")
	public void hello(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello");
	}

	@GetMapping("/hello1")
	@ResponseBody
	public String hello1() throws IOException {
		return "hello";
	}

	// 两种方式
	// 方式一
	// No converter found for return value of type
	// 解决办法参考 http://www.cnblogs.com/winner-0715/p/6033581.html
	@GetMapping("/helloJson")
	@ResponseBody
	public PageVo helloJson(Integer pageNum, Integer pageSize) throws IOException {
		if (pageNum == null)
			pageNum = 1;
		if (pageSize == null)
			pageSize = 2;
		return articleService.findPage(pageNum, pageSize);
	}

	@PostMapping("/save")
	public void save(HttpServletResponse response) throws IOException {
		response.getWriter().print("post");
	}

	@GetMapping("/test")
	public String test(HttpServletRequest request, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize) {
		request.setAttribute("list", articleService.findPage(pageNum, pageSize));
		return "article/list"; // 省代码(视图解析器)
	}

	@GetMapping("/testModelAndView")
	public ModelAndView testModelAndView(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize) {
		// request.setAttribute("list", );
		return new ModelAndView("article/list", "list", articleService.findPage(pageNum, pageSize)); // 省代码(视图解析器)
	}

	@PostMapping("/test/save1")
	public String testSave1(String username) {
		System.out.println(username);
		return "redirect:/hello";
	}

	@PostMapping("/test/save2")
	public String testSave2(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/hello";
	}

	@PostMapping("/test/upload")
	public String testUpload(@RequestParam(value = "file") MultipartFile file)
			throws IllegalStateException, IOException {
		file.transferTo(new File("C:\\Users\\REN\\Desktop\\test-upload.zip"));
		return "redirect:/hello";
	}
}
