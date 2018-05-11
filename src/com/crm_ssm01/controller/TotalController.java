package com.crm_ssm01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm_ssm01.pojo.OutVo;
import com.crm_ssm01.service.TotalService;
/**
 * 统计的Controller
 */
@Controller
@RequestMapping("/totals")
public class TotalController {

	@Autowired
	private TotalService totalService;
	
	/**
	 * 统计客户来源
	 * @return
	 */
	@RequestMapping("/sources")
	public String totalSources(Model model){
		List<OutVo> list =  totalService.findSource();
		model.addAttribute("list", list);
		return "totals/sources";
	}
	
	@RequestMapping("/vocations")
	public String totalVocations(Model model){
		List<OutVo> list = totalService.findVocation();
		model.addAttribute("list", list);
		return "totals/vocations";
	}
	
}
