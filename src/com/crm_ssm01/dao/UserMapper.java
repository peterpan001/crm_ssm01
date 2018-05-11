package com.crm_ssm01.dao;

import com.crm_ssm01.pojo.User;
/**
 * Mapper动态代理的方式
 * @author Peter
 *
 */
public interface UserMapper {

	/**
	 * 通过用户名查询用户是否存在接口
	 * @param user_code
	 * @return
	 */
	public User checkCode(String user_code);

	/**
	 * 保存用户接口
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 查询用户
	 * @param user
	 */
	public User findUser(User user);

	/**
	 * 重置密码
	 * @param user
	 */
	public void resetPwd(User user);

}
