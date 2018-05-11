package com.crm_ssm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm_ssm01.dao.LinkmanMapper;
import com.crm_ssm01.pojo.Linkman;
import com.crm_ssm01.pojo.QueryVo;
/**
 * 联系人的Service层业务层
 * @author Peter
 *
 */
@Service
public class LinkmanServiceImpl implements LinkmanService {

	@Autowired
	private LinkmanMapper linkmanMapper;

	/**
	 * 保存联系人
	 */
	public void saveLinkman(Linkman linkman) {
		linkmanMapper.saveLinkman(linkman);
	}

	/**
	 * 通过qVo查询联系人列表
	 */
	public List<Linkman> findLinkmanByVo(QueryVo qVo) {
		return linkmanMapper.findLinkmanByVo(qVo);
	}

	/**
	 * 通过qVo查询联系人数量
	 */
	public Integer findLinkmanCountByVo(QueryVo qVo) {
		return linkmanMapper.findLinkmanCountByVo(qVo);
	}

	/**
	 * 查找联系人
	 */
	public Linkman findLinkmanById(Long lkm_id) {
		return linkmanMapper.findLinkmanById(lkm_id);
	}

	/**
	 * 更新联系人信息
	 */
	public void updateLinkman(Linkman linkman) {
		linkmanMapper.updateLinkman(linkman);
	}

	/**
	 * 删除联系人
	 */
	public void deteleLinkman(Long lkm_id) {
		linkmanMapper.deleteLinkman(lkm_id);
	}

	/**
	 * 通过联系人客户id查询联系人列表
	 */
	public List<Linkman> findLinkmanByLkmCustId(Long cust_id) {
		// TODO Auto-generated method stub
		return linkmanMapper.findLinkmanByLkmCustId(cust_id);
	}
	
	
}
