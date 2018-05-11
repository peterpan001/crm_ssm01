package com.crm_ssm01.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 将字符串转化为时间Date格式
 * @author Peter
 *
 */
public class GlobalStrToDateConverter implements Converter<String, Date> {

	
	public Date convert(String source) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(!source.trim().isEmpty()){
				return format.parse(source);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
