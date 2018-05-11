package com.crm_ssm01.dao;

import java.util.List;

import com.crm_ssm01.pojo.Dict;
/**
 * 字典的Mapper动态映射类
 * @author Peter
 */
public interface DictMapper {

	//通过dict_type_code查询dict_item_name
	public List<Dict> findDictByCode(String dict_type_code);

}
