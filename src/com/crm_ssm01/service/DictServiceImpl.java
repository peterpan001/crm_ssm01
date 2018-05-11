package com.crm_ssm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm_ssm01.dao.DictMapper;
import com.crm_ssm01.pojo.Dict;
/**
 * 字典的业务层
 * @author Peter
 *
 */
@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictMapper dictMapper;

	//通过dict_type_code查询dict_item_name
	public List<Dict> findDictByCode(String dict_type_code) {
		return dictMapper.findDictByCode(dict_type_code);
	}
	
	
}
