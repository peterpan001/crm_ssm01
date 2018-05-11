package com.crm_ssm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm_ssm01.dao.VisitMapper;
import com.crm_ssm01.pojo.QueryVo;
import com.crm_ssm01.pojo.Visit;
/**
 * 拜访客户业务层
 * @author Peter
 */
@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitMapper visitMapper;

	/**
	 * 保存客户拜访记录
	 */
	public void saveVisit(Visit visit) {

		visitMapper.saveVisit(visit);
	}

	/**
	 * 通过qVo查询拜访客户列表
	 */
	public List<Visit> findVisitByVo(QueryVo qVo) {
		return visitMapper.findVisitByVo(qVo);
	}

	/**
	 * 通过qVo查询拜访客户的总数
	 */
	public Integer findVisitCountByVo(QueryVo qVo) {
		return visitMapper.findVisitCountByVo(qVo);
	}
	
}
