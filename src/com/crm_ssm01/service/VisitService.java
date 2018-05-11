package com.crm_ssm01.service;

import java.util.List;

import com.crm_ssm01.pojo.QueryVo;
import com.crm_ssm01.pojo.Visit;

public interface VisitService {

	void saveVisit(Visit visit);

	List<Visit> findVisitByVo(QueryVo qVo);

	Integer findVisitCountByVo(QueryVo qVo);

}
