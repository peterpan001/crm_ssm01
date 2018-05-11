package com.crm_ssm01.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm_ssm01.pojo.Dict;
import com.crm_ssm01.service.DictService;
import com.crm_ssm01.utils.FastJsonUtil;
/**
 * 字段的变现层Controller类
 * @author Peter
 *
 */
@Controller
@RequestMapping("/dict")
public class DictController {

	@Autowired
	private DictService dictService;
	
	/**
	 * 通过dict_type_code查询dict_item_name
	 * @param dict_type_code
	 */
	@RequestMapping("/findDictByCode")
	public void findDictByCode(String dict_type_code, HttpServletResponse response){
		List<Dict> list = dictService.findDictByCode(dict_type_code);
		String jsonStr = FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(response, jsonStr);
	}
	
}
