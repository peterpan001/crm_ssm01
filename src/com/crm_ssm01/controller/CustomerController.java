package com.crm_ssm01.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.crm_ssm01.pojo.Customer;
import com.crm_ssm01.pojo.CustomerDict;
import com.crm_ssm01.pojo.Linkman;
import com.crm_ssm01.pojo.PageBean;
import com.crm_ssm01.pojo.QueryVo;
import com.crm_ssm01.service.CustomerService;
import com.crm_ssm01.service.LinkmanService;
import com.crm_ssm01.utils.FastJsonUtil;
import com.crm_ssm01.utils.UploadUtils;
/**
 * Customer的表现层Controller
 * @author Peter
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LinkmanService linkmanService;
	
	/**
	 * 跳转到初始化的添加页面
	 * @return
	 */
	@RequestMapping("/initAddUI")
	public String initAddUI(){
		return "/customer/add";
	}
	/**
	 * 保存用户
	 * @param pictureFile
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveCustomer(MultipartFile pictureFile, Customer customer)throws Exception{
		
		if(pictureFile.getSize() > 0){
			//获取图片的完整名称
			String fileStr = pictureFile.getOriginalFilename();
			//利用uuid生成唯一的名称 + 截取图片的后缀名称 = 组成新的图片的名称
			String uuidName = UploadUtils.getUUIDName(fileStr);
			//声明保存的路径
			String path = "F:\\picture\\crm_ssm01\\";
			//将图片保存到硬盘
			pictureFile.transferTo(new File(path + uuidName));
			//将图片的路径保存到数据库
			customer.setCust_pic(path + uuidName);
		}
		
		//保存客户
		customerService.saveCustomer(customer);
		return "success";
	}
	/**
	 * 按条件分页查询用户
	 * @param qVo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findByPage")
	public String findByPage(QueryVo qVo, Model model)throws Exception{
		if(qVo.getPageCode() == null){
			qVo.setPageCode(1);
		}
		//设置查询的起始记录数
		qVo.setStart((qVo.getPageCode()-1) * qVo.getPageSize());
		PageBean<CustomerDict> page = new PageBean<CustomerDict>();
		//通过qVo查询条件查询客户字典列表
		List<CustomerDict> list = customerService.findCustomerByVo(qVo);
		//通过qVo查询客户总记录数
		Integer totalCount = customerService.findCustomerCountByVo(qVo);
		page.setPageCode(qVo.getPageCode());
		page.setPageSize(qVo.getPageSize());
		page.setBeanList(list);
		page.setTotalCount(totalCount);
		model.addAttribute("page", page);
		
		//数据回显
		if(qVo.getCust_name()!=null){
			model.addAttribute("cust_name", qVo.getCust_name());
		}
		if(qVo.getSource()!=null && qVo.getSource().getDict_id()!=""){
			model.addAttribute("cust_source", qVo.getSource().getDict_id());
		}
		if(qVo.getIndustry()!=null && qVo.getIndustry().getDict_id()!=""){
			model.addAttribute("cust_industry", qVo.getIndustry().getDict_id());
		}
		if(qVo.getLevel()!=null && qVo.getLevel().getDict_id()!=""){
			model.addAttribute("cust_level", qVo.getLevel().getDict_id());
		}
		return "customer/list";
	}
	
	/**
	 * 跳转到初始化的编辑客户页面
	 * @param cust_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/initEdit")
	public String initEdit(Long cust_id, Model model){
		//通过id查找客户
		CustomerDict customerDict = customerService.findCustomerById(cust_id);
		model.addAttribute("customer", customerDict);
		//数据回显，显示原来数据
		model.addAttribute("cust_level", customerDict.getCust_level());
		model.addAttribute("cust_source", customerDict.getCust_source());
		model.addAttribute("cust_industry", customerDict.getCust_industry());
		return "/customer/edit";
	}
	
	/**
	 * 更新修改客户信息
	 * @param customer
	 * @return
	 * @throws  
	 * @throws Exception 
	 */
	@RequestMapping("/edit")
	public String updateCustomer(MultipartFile pictureFile,Customer customer) throws Exception{
		//先判断是否有老照片,有如果还要修改的话,就删除老照片,增加新照片
		if(pictureFile.getSize() > 0){
			String cust_pic = customer.getCust_pic();
			File file = new File(cust_pic);
			if(file.exists()){
				file.delete();
			}
			//获取原始图片完整名字
			String filename = pictureFile.getOriginalFilename();
			//利用uuid生成唯一的名称 + 截取图片的后缀名称 = 组成新的图片的名称			
			String uuidName = UploadUtils.getUUIDName(filename);
			//声明保存路径
			String path = "F:\\picture\\crm_ssm01\\";
			//将图片保存到硬盘
			pictureFile.transferTo(new File(path + uuidName));
			//将图片的路径保存到数据库
			customer.setCust_pic(path + uuidName);
		}
		customerService.updateCustomer(customer);
		return "success";
	}
	
	/**
	 * 根据id删除客户
	 * @param cust_id
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteCustomer(Long cust_id){
		CustomerDict customerDict = customerService.findCustomerById(cust_id);
		String cust_pic = customerDict.getCust_pic();
		//判断是否有附件，有的话删除附件
		if(cust_pic!=null){
			File file = new File(cust_pic);
			if(file.exists()){
				file.delete();
			}
		}
		List<Linkman> list = linkmanService.findLinkmanByLkmCustId(cust_id);
		if(list.size() > 0){
			return "error";
		}
		customerService.deleteCustomer(cust_id);
		
		return "success";
	}
	
	/**
	 * 查找所有客户
	 */
	@RequestMapping("/findAllCustomer")
	public void findAllCustomer(HttpServletResponse response){
		List<Customer> list = customerService.findAllCustomer();
		String jsonStr = FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(response, jsonStr);
	}
}
