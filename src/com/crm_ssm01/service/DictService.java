package com.crm_ssm01.service;

import java.util.List;

import com.crm_ssm01.pojo.Dict;

public interface DictService {

	List<Dict> findDictByCode(String dict_type_code);

}
