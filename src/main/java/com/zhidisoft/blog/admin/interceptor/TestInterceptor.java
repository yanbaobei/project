package com.zhidisoft.blog.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter {

	/**
	 * preHandle 在方法(url)之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("执行了preHandler");
		return super.preHandle(request, response, handler);
	}

	/**
	 * 执行完成之后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("执行了afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * TODO postHandle 和 afterCompletion 区别
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("执行了postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}
}
