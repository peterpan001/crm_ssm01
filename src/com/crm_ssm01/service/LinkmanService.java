package com.crm_ssm01.service;

import java.util.List;

import com.crm_ssm01.pojo.Linkman;
import com.crm_ssm01.pojo.QueryVo;

public interface LinkmanService {

	void saveLinkman(Linkman linkman);

	List<Linkman> findLinkmanByVo(QueryVo qVo);

	Integer findLinkmanCountByVo(QueryVo qVo);

	Linkman findLinkmanById(Long lkm_id);

	void updateLinkman(Linkman linkman);

	void deteleLinkman(Long lkm_id);

	List<Linkman> findLinkmanByLkmCustId(Long cust_id);

}
