package com.crm_ssm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm_ssm01.dao.TotalMapper;
import com.crm_ssm01.pojo.OutVo;
/**
 * total统计的业务层
 * @author Peter
 *
 */
@Service
public class TotalServiceImpl implements TotalService {

	@Autowired
	private TotalMapper totalMapper;

	/**
	 * 统计客户来源
	 */
	public List<OutVo> findSource() {
		return totalMapper.findSource();
	}

	/**
	 * 统计客户职业
	 */
	@Override
	public List<OutVo> findVocation() {
		// TODO Auto-generated method stub
		return totalMapper.findVocation();
	}
}
