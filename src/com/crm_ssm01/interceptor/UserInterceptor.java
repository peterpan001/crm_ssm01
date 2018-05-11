package com.crm_ssm01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用户拦截功能
 */
public class UserInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView exception) throws Exception {
		
	}

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		/**
		 * request.getRequestURL() 返回全路径
		   request.getRequestURI() 返回除去host（域名或者ip）部分的路径
		   request.getContextPath() 返回工程名部分，如果工程映射为/，此处返回则为空
		   request.getServletPath() 返回除去host和工程名部分的路径
		        例如：
		   request.getRequestURL() http://localhost:8080/jqueryLearn/resources/request.jsp 
 		   request.getRequestURI() /jqueryLearn/resources/request.jsp
		   request.getContextPath()/jqueryLearn 
		   request.getServletPath()/resources/request.jsp 
		       注： resources为WebContext下的目录名 
              jqueryLearn 为工程名
		 */
		//判断是否为用户模块(登录，注册，修改密码，退出)，是的话放行
		if(request.getRequestURI().indexOf("/user") > 0){
			return true;
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("existUser")!=null){
			return true;
		}
		request.getRequestDispatcher("/user/initLogin.action").forward(request, response);
		return false;
	}

}
