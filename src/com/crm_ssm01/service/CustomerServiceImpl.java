package com.crm_ssm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm_ssm01.dao.CustomerMapper;
import com.crm_ssm01.pojo.Customer;
import com.crm_ssm01.pojo.CustomerDict;
import com.crm_ssm01.pojo.QueryVo;
/**
 * 客户的业务层
 * @author Peter
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	
	//保存客户
	public void saveCustomer(Customer customer) {
		customerMapper.saveCustomer(customer);
	}


	/**
	 * 通过qVo查询客户列表
	 */
	public List<CustomerDict> findCustomerByVo(QueryVo qVo) {
		return customerMapper.findCustomerByVo(qVo);
	}


	/**
	 * 通过qVo查询客户总记录数
	 */
	public Integer findCustomerCountByVo(QueryVo qVo) {
		return customerMapper.findCustomerCountByVo(qVo);
	}


	/**
	 * 通过id查找客户
	 */
	public CustomerDict findCustomerById(Long cust_id) {
		return customerMapper.findCustomerById(cust_id);
	}


	/**
	 * 修改客户信息
	 */
	public void updateCustomer(Customer customer) {

		customerMapper.updateCustomer(customer);
	}


	/**
	 * 通过id删除客户
	 */
	public void deleteCustomer(Long cust_id) {
		
		customerMapper.deleteCustomer(cust_id);
	}


	/**
	 * 查找所有客户
	 */
	public List<Customer> findAllCustomer() {
		return customerMapper.findAllCustomer();
	}
	
	
}
