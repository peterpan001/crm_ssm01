package com.crm_ssm01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm_ssm01.pojo.Linkman;
import com.crm_ssm01.pojo.PageBean;
import com.crm_ssm01.pojo.QueryVo;
import com.crm_ssm01.service.LinkmanService;
/**
 * 联系人的表现层
 * @author Peter
 */
@Controller
@RequestMapping("/linkman")
public class LinkmanController {
	
	@Autowired
	private LinkmanService linkmanService;
	
	/**
	 * 跳转到初始化的添加联系人页面
	 * @return
	 */
	@RequestMapping("/initAddUI")
	public String initAddUI(){
		return "linkman/add";
	}
	
	/**
	 * 保存联系人
	 * @param linkman
	 * @return
	 */
	@RequestMapping("/add")
	public String saveLinkman(Linkman linkman){
		linkmanService.saveLinkman(linkman);
		return "success";
	}
	
	/**
	 * 分页查询联系人
	 * @param qVo
	 * @param model
	 * @return
	 */
	@RequestMapping("/findByPage")
	public String findByPage(QueryVo qVo,Model model){
		if(qVo.getPageCode() == null){
			qVo.setPageCode(1);
		}
		qVo.setStart((qVo.getPageCode()-1)*qVo.getPageSize());
		PageBean<Linkman> page = new PageBean<Linkman>();
		//通过qVo查询联系人列表
		List<Linkman> list = linkmanService.findLinkmanByVo(qVo);
		//通过qVo查询联系人数量
		Integer totalCount = linkmanService.findLinkmanCountByVo(qVo);
		page.setPageCode(qVo.getPageCode());
		page.setPageSize(qVo.getPageSize());
		page.setBeanList(list);
		page.setTotalCount(totalCount);
		
		model.addAttribute("page", page);
		//数据回显
		if(qVo.getLkm_name()!=null){
			model.addAttribute("lkm_name", qVo.getLkm_name());
		}
		if(qVo.getCustomer()!=null && qVo.getCustomer().getCust_id()!=null){
			model.addAttribute("lkm_cust_id", qVo.getCustomer().getCust_id());
		}
		return "linkman/list";
	}
	
	/**
	 * 初始化修改联系人页面
	 * @param lkm_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/initEdit")
	public String initEdit(Long lkm_id, Model model){
		Linkman linkman = linkmanService.findLinkmanById(lkm_id);
		model.addAttribute("linkman", linkman);
		model.addAttribute("custId", linkman.getCustomer().getCust_id());
		return "linkman/edit";
	}
	
	/**
	 * 更新联系人
	 * @param linkman
	 * @return
	 */
	@RequestMapping("/edit")
	public String updateLinkman(Linkman linkman){
		linkmanService.updateLinkman(linkman);
		return "success";
	}
	
	/**
	 * 删除联系人
	 */
	@RequestMapping("/delete")
	public String deleteLinkman(Long lkm_id){
		linkmanService.deteleLinkman(lkm_id);
		return "success";
	}
}
