package com.crm_ssm01.dao;

import java.util.List;

import com.crm_ssm01.pojo.Customer;
import com.crm_ssm01.pojo.CustomerDict;
import com.crm_ssm01.pojo.QueryVo;
/**
 * 客户的Mapper动态代理类
 * @author Peter
 */
public interface CustomerMapper {

	/**
	 * 保存客户接口
	 * @param customer
	 */
	public void saveCustomer(Customer customer);

	/**
	 * 通过qVo查询客户列表
	 * @param qVo
	 * @return
	 */
	public List<CustomerDict> findCustomerByVo(QueryVo qVo);

	/**
	 * 通过qVo查询客户总记录数
	 * @param qVo
	 * @return
	 */
	public Integer findCustomerCountByVo(QueryVo qVo);

	/**
	 * 通过id查询客户
	 * @param cust_id
	 * @return
	 */
	public CustomerDict findCustomerById(Long cust_id);

	/**
	 * 修改客户信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer);

	/**
	 * 通过id删除客户
	 * @param cust_id
	 */
	public void deleteCustomer(Long cust_id);

	/**
	 * 查找所有客户
	 * @return
	 */
	public List<Customer> findAllCustomer();
	
}
