package com.crm_ssm01.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm_ssm01.pojo.PageBean;
import com.crm_ssm01.pojo.QueryVo;
import com.crm_ssm01.pojo.User;
import com.crm_ssm01.pojo.Visit;
import com.crm_ssm01.service.VisitService;
/**
 * 拜访客户表现层
 * @author Peter
 */
@Controller
@RequestMapping("/visit")
public class VisitController {

	@Autowired
	private VisitService visitService;
	
	/**
	 * 跳转到初始化增加拜访客户页面
	 * @return
	 */
	@RequestMapping("/initAddUI")
	public String initAddUI(){
		return "visit/add";
	}
	
	/**
	 * 保存客户拜访记录
	 * @param visit
	 * @return
	 */
	@RequestMapping("/add")
	public String saveVisit(Visit visit, HttpSession session){
		User user = (User) session.getAttribute("existUser");
		visit.setUser(user);
		visitService.saveVisit(visit);
		return "success";
	}
	
	/**
	 * 通过qVo查询拜访的客户
	 * @param qVo
	 * @param model
	 * @return
	 */
	@RequestMapping("/findByPage")
	public String findByPage(QueryVo qVo, Model model, HttpSession session){
		if(qVo.getPageCode()==null){
			qVo.setPageCode(1);
		}
		qVo.setUser((User)session.getAttribute("existUser"));
		//设置起始的查询页
		qVo.setStart((qVo.getPageCode()-1)*qVo.getPageSize());
		PageBean<Visit> page = new PageBean<Visit>();
		//通过qVo查询拜访客户的列表
		List<Visit> list = visitService.findVisitByVo(qVo);
		//通过qVo查询拜访客户的总数
		Integer totalCount = visitService.findVisitCountByVo(qVo);
		
		page.setPageCode(qVo.getPageCode());
		page.setPageSize(qVo.getPageSize());
		page.setBeanList(list);
		page.setTotalCount(totalCount);
		model.addAttribute("page", page);
		//数据回显
		if(qVo.getVisit_interviewee()!=null && !qVo.getVisit_interviewee().trim().isEmpty()){
			model.addAttribute("visit_interviewee",qVo.getVisit_interviewee());
		}
		if(qVo.getBeginDate()!=null){
			model.addAttribute("beginDate",qVo.getBeginDate());
		}
		if(qVo.getEndDate()!=null){
			model.addAttribute("endDate",qVo.getEndDate());
		}
		return "visit/list";
	}
	
}
