package com.crm_ssm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm_ssm01.dao.UserMapper;
import com.crm_ssm01.pojo.User;
import com.crm_ssm01.utils.MD5Utils;
/**
 * 用户的业务层
 * @author Peter
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 通过用户名查询用户是否存在
	 */
	public User checkCode(String user_code) {
		return userMapper.checkCode(user_code);
	}

	/**
	 * 保存用户
	 */
	public void saveUser(User user) {
		//获取用户密码给密码MD5加密
		String password = user.getUser_password();
		user.setUser_password(MD5Utils.md5(password));
		//设置用户状态
		user.setUser_state("1");
		//调用持久层保存用户
		userMapper.saveUser(user);
	}

	/**
	 * 查询用户
	 */
	public User findUser(User user) {
		//获取密码,给密码加密
		String password = user.getUser_password();
		user.setUser_password(MD5Utils.md5(password));
		//调用持久层查询用户
		return userMapper.findUser(user);
	}

	/**
	 * 重置密码
	 */
	public void resetPwd(User user) {
		userMapper.resetPwd(user);
	}

	
	
	
}
