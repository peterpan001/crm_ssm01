package com.crm_ssm01.exception;
/**
 * 自定义异常
 * @author Peter
 *
 */
public class GlobalException extends Exception {

	private static final long serialVersionUID = 811251107177828039L;
	
	//保存异常信息
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GlobalException(String message) {
		super();
		this.message = message;
	}
	
}
