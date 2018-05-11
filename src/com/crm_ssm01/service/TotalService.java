package com.crm_ssm01.service;

import java.util.List;

import com.crm_ssm01.pojo.OutVo;

public interface TotalService {

	List<OutVo> findSource();

	List<OutVo> findVocation();

}
