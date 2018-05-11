package com.crm_ssm01.service;

import java.util.List;

import com.crm_ssm01.pojo.Customer;
import com.crm_ssm01.pojo.CustomerDict;
import com.crm_ssm01.pojo.QueryVo;

public interface CustomerService {

	void saveCustomer(Customer customer);

	List<CustomerDict> findCustomerByVo(QueryVo qVo);

	Integer findCustomerCountByVo(QueryVo qVo);

	CustomerDict findCustomerById(Long cust_id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long cust_id);

	List<Customer> findAllCustomer();

}
