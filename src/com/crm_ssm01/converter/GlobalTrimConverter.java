package com.crm_ssm01.converter;

import org.springframework.core.convert.converter.Converter;
/**
 * 去除空格字符串
 * @author Peter
 */
public class GlobalTrimConverter implements Converter<String, String>{

	
	public String convert(String source) {
		String str = source.trim();
		if(str!=null && (!str.equals(""))){
			return str;
		}
		return null;
	}
}
