package com.crm_ssm01.service;

import com.crm_ssm01.pojo.User;

public interface UserService {

	User checkCode(String user_code);

	void saveUser(User user);

	User findUser(User user);

	void resetPwd(User user);

}
