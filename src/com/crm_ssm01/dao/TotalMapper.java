package com.crm_ssm01.dao;

import java.util.List;

import com.crm_ssm01.pojo.OutVo;
/**
 * total的Mapper代理类
 * @author Peter
 */
public interface TotalMapper {
	/**
	 * 查询客户来源统计
	 * @return
	 */
	List<OutVo> findSource();

	/**
	 * 查询客户行业统计
	 * @return
	 */
	List<OutVo> findVocation();

}
