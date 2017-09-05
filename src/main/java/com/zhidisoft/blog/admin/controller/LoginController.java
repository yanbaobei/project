package com.zhidisoft.blog.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.blog.admin.entity.User;
import com.zhidisoft.blog.admin.service.IUserService;
import com.zhidisoft.blog.admin.vo.AjaxVo;
import com.zhidisoft.blog.admin.vo.UserVo;

@Controller
public class LoginController {

	@Autowired
	IUserService userService;

	// @GetMapping("/login")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView index(String servletPath) {
		return new ModelAndView("login.html", "servletPath", servletPath);
	}

	@PostMapping("/login")
	@ResponseBody
	public AjaxVo login(UserVo userVo, HttpSession session) {
		// 判断
		if (userVo == null)
			return new AjaxVo().setErrorCode("1001").setErrorMsg("用户信息为空");
		if (StringUtils.isEmpty(userVo.getUsername()) || StringUtils.isEmpty(userVo.getPassword()))
			return new AjaxVo().setErrorCode("1001").setErrorMsg("用户信息为空");
		User dbUser = userService.findByUserName(userVo.getUsername());
		if (dbUser == null)
			return new AjaxVo().setErrorCode("1002").setErrorMsg("用户名不存在");
		if (!userVo.getPassword().equals(dbUser.getPassword()))
			return new AjaxVo().setErrorCode("1002").setErrorMsg("密码错误");

		session.setAttribute("userId", dbUser.getId());
		return new AjaxVo().setErrorCode("0");
		// .setErrorMsg("登录成功");
	}
}
