package com.crm_ssm01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm_ssm01.pojo.User;
import com.crm_ssm01.service.UserService;
import com.crm_ssm01.utils.MD5Utils;
/**
 * 用户的controller
 * @author Peter
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="/initLogin")
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value="/initRegist")
	public String toRegist(){
		return "regist";
	}
	
	/**
	 * 注册时检查用户名不能重复
	 * 绑定简单类型参数
	 * @param user_code
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/checkCode")
	public void checkCode(String user_code, HttpServletResponse response){
		User u = userService.checkCode(user_code);
		//设置编码风格
		response.setContentType("text/html;charset=UTF-8");
		//获取输出流
		try {
			PrintWriter writer = response.getWriter();
			if(u == null){
				//输出yes,说明这个用户名数据库没有可以注册
				writer.print("yes");
			}else{
				//输出no,说明这个用户名数据库有,不可以注册
				writer.print("no");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 注册用户
	 * 绑定pojo
	 * @param user
	 * @return
	 */
	@RequestMapping("/regist")
	public String regist(User user){
		//接收user数据进行注册
		userService.saveUser(user);
		return "login";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request, HttpSession session){
		User existUser = userService.findUser(user);
		if(existUser==null){
			request.setAttribute("errorMsg", "用户名或者密码错误");
			request.setAttribute("user_code", user.getUser_code());
			request.setAttribute("user_password", user.getUser_password());
			return "login";
		}else{
			session.setAttribute("existUser", existUser);
			return "index";
		}
	}
	
	/**
	 * 下面三个方法是进行index.jsp页面的加载
	 * @return
	 */
	@RequestMapping("/top")
	public String top(){
		return "top";
	}
	@RequestMapping("/menu")
	public String menu(){
		return "menu";
	}
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		session.removeAttribute("existUser");
		return "login";
	}
	
	/**
	 * 初始化密码
	 * @return
	 */
	@RequestMapping("/initReset")
	public String initReset(){
		return "reset";
	}
	
	/**
	 * 重置密码
	 * @param user_pwd1
	 * @param user_pwd2
	 * @param request
	 * @return
	 */
	@RequestMapping("/reset")
	public String resetPwd(String user_pwd1, String user_pwd2, HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("existUser");
		String user_pwd = user.getUser_password();
		String user_pwd_1 = MD5Utils.md5(user_pwd1);
		if(user_pwd.equals(user_pwd_1)){
			String user_pwd_2 = MD5Utils.md5(user_pwd2);
			user.setUser_password(user_pwd_2);
			userService.resetPwd(user);
			return "login";
		}else{
			request.setAttribute("errorMsg", "输入的旧密码错误");
			return "reset";
		}
	}
}
