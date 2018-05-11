﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取到项目的跟路径即WebContent
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=basePath%>css/Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath%>css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	//页面加载时就异步查询客户级别，客户来源，客户行业三个下拉框
	
	$(function(){
		
		url="<%=basePath%>dict/findDictByCode.action";
		param={"dict_type_code":"006"};//客户级别
		$.post(url, param, function(data){
			$(data).each(function(i, n){
				var cust_level = '<%=request.getAttribute("cust_level")%>';
				if(cust_level == n.dict_id){
					$("#levelId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#levelId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
		
		param={"dict_type_code":"002"}; //客户来源
		$.post(url, param, function(data){
			$(data).each(function(i, n){
				var cust_source = '<%=request.getAttribute("cust_source")%>';
				if(cust_source == n.dict_id){
					$("#sourceId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#sourceId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
	
		param={"dict_type_code":"001"}; //客户行业
		$.post(url, param, function(data){
			$(data).each(function(i, n){
				var cust_industry = '<%=request.getAttribute("cust_industry")%>';
				if(cust_industry == n.dict_id){
					$("#industryId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#industryId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
	});

</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="<%=basePath%>customer/edit.action"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="cust_id" value="${customer.cust_id }"/>
		<input type="hidden" name="cust_pic" value="${customer.cust_pic }"/>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="<%=basePath%>images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="<%=basePath%>images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="<%=basePath%>images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="<%=basePath%>images/new_022.jpg"><IMG
						src="<%=basePath%>images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_name" value="${customer.cust_name }">
								</td>
								<td>客户级别 ：</td>
								<td>
									<select id="levelId" style="WIDTH: 180px" maxLength=50 name="level.dict_id"></select>
								</td>
							</TR>
				
							<TR>
								<td>信息来源：</td>
								<td>
									<select id="sourceId" style="WIDTH: 180px" maxLength=50 name="source.dict_id"></select>
								</td>
								<td>客户行业：</td>
								<td>
									<select id="industryId" style="WIDTH: 180px" maxLength=50 name="industry.dict_id"></select>
								</td>
							</TR>
							
							<TR>								
								<td>固定电话 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${customer.cust_phone }">
								</td>
								<td>移动电话 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="${customer.cust_mobile }">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_address" value="${customer.cust_address }">
								</td>
								<td>邮政编码 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_zip" value="${customer.cust_zip }">
								</td>
							</TR>
							<TR>
								<td>联系人：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_linkman" value="${customer.cust_linkman }">
								</td>
								<td>上传附件 ：</td>
								<td>
									<input type="file" style="WIDTH: 180px" maxLength=50 name="pictureFile"/>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
					</TD>
					<TD width=15 background="<%=basePath%>images/new_023.jpg">
					<IMG src="<%=basePath%>images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="<%=basePath%>images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="<%=basePath%>images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="<%=basePath%>images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
