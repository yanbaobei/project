package com.zhidisoft.blog.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * http://www.cnblogs.com/banning/p/6195072.html
 * 
 * @author REN
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getContextPath());// 项目路径(如果项目部署在tomcat ROOT
														// 目录下,就是/)
		System.out.println(request.getServletPath());// 访问路径()

		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		// if(!servletPath.startsWith("/login")){
		String userId = (String) request.getSession().getAttribute("userId");
		if (StringUtils.isEmpty(userId)) {

			String ctxPath = request.getContextPath();
			// request.getSession().setAttribute("servletPath", servletPath);
			response.sendRedirect(ctxPath + "/login?servletPath=" + servletPath);
			// 重定向两种办法
			// 1.session
			// 2. url

			// request.getRequestDispatcher("").forward(request, arg1);
			// TODO 鏄痶rue鍋滄杩涘叆涓嬩竴涓嫤鎴櫒,杩樻槸false
			return false;
		}
		// }
		return super.preHandle(request, response, handler);
	}
}
