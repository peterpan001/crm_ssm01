package com.crm_ssm01.pojo;
/**
 * 客户字典的Pojo
 * @author Peter
 *
 */
public class CustomerDict extends Customer {

	private String cust_industry;
	private String cust_level;
	private String cust_source;
	
	public String getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}
	public String getCust_level() {
		return cust_level;
	}
	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_source() {
		return cust_source;
	}
	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}
	
}
