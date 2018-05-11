package com.crm_ssm01.pojo;

import java.util.List;
/**
 * 客户的pojo
 * @author Peter
 */
public class Customer {

	/**
	 * CREATE TABLE `cst_customer` (
		  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
		  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
		  `cust_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
		  `cust_create_id` bigint(32) DEFAULT NULL COMMENT '创建人id',
		  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
		  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
		  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
		  `cust_linkman` varchar(64) DEFAULT NULL COMMENT '联系人',
		  `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
		  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
		  PRIMARY KEY (`cust_id`)
		) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
	 */
	private Long cust_id;
	private String cust_name;
	private Long cust_user_id;
	private Long cust_create_id;
	
	//客户资源、行业、级别和字典表是多对一的关系，客户表是多方，字典表是一方，故外键维护交给多方去维护，一方放弃外键的维护
	private Dict source;
	private Dict industry;
	private Dict level;

	private String cust_linkman;
	private String cust_phone;
	private String cust_mobile;
	private String cust_pic;
	private String cust_address;
	private String cust_zip;
	
	//联系人和客户是多对一的关系，客户一方的编写
	private List<Linkman> linkmans;
	
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_zip() {
		return cust_zip;
	}
	public void setCust_zip(String cust_zip) {
		this.cust_zip = cust_zip;
	}
	
	public String getCust_pic() {
		return cust_pic;
	}
	public void setCust_pic(String cust_pic) {
		this.cust_pic = cust_pic;
	}
	
	public List<Linkman> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(List<Linkman> linkmans) {
		this.linkmans = linkmans;
	}
	
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Long getCust_user_id() {
		return cust_user_id;
	}
	public void setCust_user_id(Long cust_user_id) {
		this.cust_user_id = cust_user_id;
	}
	public Long getCust_create_id() {
		return cust_create_id;
	}
	public void setCust_create_id(Long cust_create_id) {
		this.cust_create_id = cust_create_id;
	}
	
	public Dict getSource() {
		return source;
	}
	public void setSource(Dict source) {
		this.source = source;
	}
	public Dict getIndustry() {
		return industry;
	}
	public void setIndustry(Dict industry) {
		this.industry = industry;
	}
	public Dict getLevel() {
		return level;
	}
	public void setLevel(Dict level) {
		this.level = level;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name
				+ ", cust_user_id=" + cust_user_id + ", cust_create_id="
				+ cust_create_id + ", source=" + source + ", industry="
				+ industry + ", level=" + level + ", cust_linkman="
				+ cust_linkman + ", cust_phone=" + cust_phone
				+ ", cust_mobile=" + cust_mobile + ", linkmans=" + linkmans
				+ "]";
	}
	
}
