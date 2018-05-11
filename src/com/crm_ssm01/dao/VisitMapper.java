package com.crm_ssm01.dao;

import java.util.List;

import com.crm_ssm01.pojo.QueryVo;
import com.crm_ssm01.pojo.Visit;

/**
 * 拜访客户动态代理Mapper类
 */
public interface VisitMapper {

	/**
	 * 保存客户拜访记录
	 * @param visit
	 */
	public void saveVisit(Visit visit);

	/**
	 * 通过qVo查询拜访客户列表
	 * @param qVo
	 * @return
	 */
	public List<Visit> findVisitByVo(QueryVo qVo);

	/**
	 * 通过qVo查询拜访客户总数
	 * @param qVo
	 * @return
	 */
	public Integer findVisitCountByVo(QueryVo qVo);

	
}
