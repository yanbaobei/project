package com.zhidisoft.blog.admin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
@RequestMapping("/ueditor")
public class UeditorUploadController {

	@GetMapping
	public void upload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		String rootPath = request.getRealPath("/");		
		response.getWriter().print(new ActionEnter( request, rootPath ).exec());
	}
}
