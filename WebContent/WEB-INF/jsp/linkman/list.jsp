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
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=basePath%>css/Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath%>css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
	}
	
	$(function(){
		url="<%=basePath%>customer/findAllCustomer.action";
		$.post(url, function(data){
			$(data).each(function(){
				var lkm_cust_id = '<%=request.getAttribute("lkm_cust_id")%>';
				if(lkm_cust_id == this.cust_id){
					$("#customerId").append("<option value='"+this.cust_id+"' selected>"+this.cust_name+"</option>");
				}else{
					$("#customerId").append("<option value='"+this.cust_id+"'>"+this.cust_name+"</option>");
				}
			});
		},"json");
	});
	
</SCRIPT>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="<%=basePath%>linkman/findByPage.action"
		method=post>
		
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
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>联系人名称：</TD>
													<TD>
														<INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="lkm_name" value="${lkm_name}">
													</TD>
													<td>客户名称</td>
													<td>
														<select id="customerId" name="customer.cust_id">
															<option value="">--请选择--</option>
														</select>
													</td>
													<TD>
														<INPUT class=button id=sButton2 type=submit value=" 筛选 " name=sButton2>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>联系人名称</TD>
													<td>所属客户</td>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<td>邮箱</td>
													<td>QQ</td>
													<td>职位</td>
													<td>备注</td>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${page.beanList }" var="linkman">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${linkman.lkm_name }</TD>
													<td>${linkman.customer.cust_name }</td>
													<TD>
													<c:if test="${linkman.lkm_gender == '1'}">
														男
													</c:if>
													<c:if test="${linkman.lkm_gender == '2'}">
														女
													</c:if>
													</TD>
													<TD>${linkman.lkm_phone }</TD>
													<TD>${linkman.lkm_mobile }</TD>
													<td>${linkman.lkm_email }</td>
													<td>${linkman.lkm_qq }</td>
													<td>${linkman.lkm_position }</td>
													<td>${linkman.lkm_memo }</td>
													<TD>
													<a href="<%=basePath%>linkman/initEdit.action?lkm_id=${linkman.lkm_id}">修改</a>
													&nbsp;&nbsp;
													<a href="<%=basePath%>linkman/delete.action?lkm_id=${linkman.lkm_id}">删除</a>
													</TD>
												</TR>
												
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${page.totalCount}</B>]条记录,[<B>${page.totalPage}</B>]页
												,每页显示
												<select name="pageSize">
												
												<option value="5" <c:if test="${page.pageSize==5 }">selected</c:if>>5</option>
												<option value="10" <c:if test="${page.pageSize==10 }">selected</c:if>>10</option>
												</select>
												条
												<c:if test="${page.pageCode > 1 }">
												[<A href="javascript:to_page(${page.pageCode-1})">前一页</A>]
												</c:if>
												<B>${page.pageCode}</B>
												<c:if test="${page.pageCode < page.totalPage }">
												[<A href="javascript:to_page(${page.pageCode+1})">后一页</A>]
												</c:if>
												到
												<input type="text" size="3" id="page" name="pageCode" />
												页
												
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="<%=basePath%>images/new_023.jpg"><IMG
						src="<%=basePath%>images/new_023.jpg" border=0></TD>
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
