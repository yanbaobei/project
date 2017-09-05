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
		System.out.println(request.getContextPath());// ��Ŀ·��(�����Ŀ������tomcat ROOT
														// Ŀ¼��,����/)
		System.out.println(request.getServletPath());// ����·��()

		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		// if(!servletPath.startsWith("/login")){
		String userId = (String) request.getSession().getAttribute("userId");
		if (StringUtils.isEmpty(userId)) {

			String ctxPath = request.getContextPath();
			// request.getSession().setAttribute("servletPath", servletPath);
			response.sendRedirect(ctxPath + "/login?servletPath=" + servletPath);
			// �ض������ְ취
			// 1.session
			// 2. url

			// request.getRequestDispatcher("").forward(request, arg1);
			// TODO 是true停止进入下一个拦截器,还是false
			return false;
		}
		// }
		return super.preHandle(request, response, handler);
	}
}
