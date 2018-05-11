package com.crm_ssm01.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 配置全局异常处理器
 * @author Peter
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception) {
		//保存异常信息
		String msg = "";
		//判断异常类型
		if(exception instanceof GlobalException){
			//处理业务级别异常
			msg = ((GlobalException)exception).getMessage();
		}else{
			//处理运行时异常
			msg = "系统异常，亲，对不起哦，请及时联系管理员哦";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("error1");
		return modelAndView;
	}

}
