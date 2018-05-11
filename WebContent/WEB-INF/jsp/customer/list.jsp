<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();//获取到项目的跟路径即WebContent
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=basePath%>css/Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath%>css/Manage.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit(); 
	}
	
	$(function(){
		url="<%=basePath%>dict/findDictByCode.action";
		
		param={"dict_type_code":"001"};//客户行业
		$.post(url, param, function(data){
			$(data).each(function(i, n){
				var cust_industry = '<%=request.getAttribute("cust_industry")%>'
				if(cust_industry == n.dict_id){
					$("#industryId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#industryId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
		
		param={"dict_type_code":"002"};//客户来源
		$.post(url, param, function(data){
			$(data).each(function(i, n){
				var cust_source = '<%=request.getAttribute("cust_source")%>'
				if(cust_source == n.dict_id){
					$("#sourceId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#sourceId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
		
		param={"dict_type_code":"006"};//客户级别
		$.post(url, param, function(data){
			$(data).each(function(i, n){
				var cust_level = '<%=request.getAttribute("cust_level")%>'
				if(cust_level==n.dict_id){
					$("#levelId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#levelId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
	});
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="<%=basePath%>customer/findByPage.action"
		method="post">
		
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
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
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
													<TD>客户名称：</TD>
													<TD>
														<INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="cust_name" value="${cust_name}">
													</TD>
													<td>客户行业：</td>
													<td>
														<select id="industryId" name="industry.dict_id">
															<option value="">--请选择--</option>
														</select>
													</td>
													<td>客户来源：</td>
													<td>
														<select id="sourceId" name="source.dict_id">
															<option value="">--请选择</option>
														</select>
													</td>
													<td>客户级别</td>
													<td>
														<select id="levelId" name="level.dict_id">
															<option value="">--请选择</option>
														</select>
													</td>
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
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
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<td>客户行业</td>
													<TD>联系人</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<td>邮编</td>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${page.beanList }" var="customer">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${customer.cust_name }</TD>
													<TD>${customer.cust_level }</TD>
													<TD>${customer.cust_source }</TD>
													<td>${customer.cust_industry }</td>
													<TD>${customer.cust_linkman }</TD>
													<TD>${customer.cust_phone }</TD>
													<TD>${customer.cust_mobile }</TD>
													<td>${customer.cust_zip }</td>
													<TD>
													<a href="<%=basePath%>customer/initEdit.action?cust_id=${customer.cust_id}">修改</a>
													&nbsp;&nbsp;
													<a href="<%=basePath%>customer/delete.action?cust_id=${customer.cust_id}">删除</a>
													</TD>
												</TR>
												
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD>
										<SPAN id=pagelink>
											<DIV 
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${page.totalCount}</B>]条记录,[<B>${page.totalPage}</B>]页
												,每页显示
												<select name="pageSize">
												
												<option value="5" <c:if test="${page.pageSize==5 }">selected</c:if>>5</option>
												<option value="10" <c:if test="${page.pageSize==10 }">selected</c:if>>10</option>
												</select>
												条
												<c:if test="${page.pageCode > 1}">
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
										</SPAN>
									</TD>
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
