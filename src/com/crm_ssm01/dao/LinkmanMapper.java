package com.crm_ssm01.dao;

import java.util.List;

import com.crm_ssm01.pojo.Linkman;
import com.crm_ssm01.pojo.QueryVo;

/**
 * 联系人的Mapper动态代理类
 * @author Peter
 *
 */
public interface LinkmanMapper {

	/**
	 * 保存联系人
	 * @param linkman
	 */
	public void saveLinkman(Linkman linkman);

	/**
	 * 分页查询联系人列表
	 * @param qVo
	 * @return
	 */
	public List<Linkman> findLinkmanByVo(QueryVo qVo);

	/**
	 * 查询联系人数量
	 * @param qVo
	 * @return
	 */
	public Integer findLinkmanCountByVo(QueryVo qVo);

	/**
	 * 通过id查找联系人
	 * @param lkm_id
	 * @return
	 */
	public Linkman findLinkmanById(Long lkm_id);

	/**
	 * 更新联系人信息
	 * @param linkman
	 */
	public void updateLinkman(Linkman linkman);

	/**
	 * 删除联系人
	 * @param lkm_id
	 */
	public void deleteLinkman(Long lkm_id);

	/**
	 * 通过联系人客户id查询联系人列表
	 * @param cust_id
	 * @return
	 */
	public List<Linkman> findLinkmanByLkmCustId(Long cust_id);

}
