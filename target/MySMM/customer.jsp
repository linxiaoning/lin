<%@ page language="java" import="java.util.*,cn.com.bean.*"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Customer.jsp' starting page</title>
<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="Style/ks.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.1.min.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
	/* var pages = ${page}; */
	
	 function ajaxpage(page) {
		alert("ajax");
		var page = page;
		$.ajax({
					type : "post",
					url : "customer_ajaxPaget.action",
					dataType : "json",
					data : 'page=' + page,
					success : function(data) {
					//alert(data.customerList.length);
						//alert(data.json_Customers.length);
						//var cus=JSON.parse(data);    				   				 
						$('#tableCustomer tr:not(:first)').remove();
						//var rownum=$("#tableCustomer tr").length-2;
						for ( var indexs in data.customerList) {
							var first_name = data.customerList[indexs].first_name;
							var last_name = data.customerList[indexs].last_name;
							var address = data.customerList[indexs].address_id.address_id;
							var email = data.customerList[indexs].email;
							var customer_id = data.customerList[indexs].customer_id;
							var last_update = data.customerList[indexs].last_update;
							var row = $("<tr><td><a href=\"Customer?parm=delete&Customer_id="
									+ customer_id
									+ "\">删除</a>|<a href=\"Customer?parm=update1&Customer_id="
									+ customer_id
									+ "\">修改</a></td>"
									+ "<td>"
									+ first_name
									+ "</td><td>"
									+ last_name
									+ "</td><td>"
									+ address
									+ "</td><td>"
									+ email
									+ "</td><td>"
									+ customer_id
									+ "</td><td>" + last_update + "</td></tr>");
							$("#tableCustomer").append(row)
						}
					}

				});
	} 
</script>
<body>
	<div>
		<a href="cuntomer.jsp">Customer管理</a>
	</div>
	<div>
		<a href="FilmIndex.jsp">Film设置</a>
	</div>
	<div>
		<a href="Customer?parm=quit">admin退出</a>
	</div>
	<div class="cztable">
		<p>客户管理</p>
		<a><a href="/MySMM/film/toAllAddress">新增</a>
			<table id="tableCustomer" width="100%" border="0" cellspacing="0"
				cellpadding="0" style="text-align:center;">
				<tr>
					<td>操作</td>
					<td>first_name</td>
					<td>last_name</td>
					<td>address_id</td>
					<td>email</td>
					<td>customer_id</td>
					<td>last_update</td>
				</tr>
				
				
				<c:forEach items="${list}" var="m">
					<tr>
						<td><a href="customer!delete.action?customer_id=618">删除</a>|<a
							href="Customer?parm=delete&Customer_id=">修改</a></td>
						<td><s:property value="#first_name" /></td>
						<td><s:property value="#last_name" /></td>
						<td><s:property value="#address_id.address_id" /></td>
						<td><s:property value="#email" /></td>
						<td><s:property value="#customer_id" /></td>
						<td><s:property value="#last_update.toString()" /></td>
					</tr>
			    </c:forEach>
				
				<!-- <s:iterator value="#attr.customerList" var="customer">
					<tr>
						<td><a href="customer!delete.action?customer_id=618">删除</a>|<a
							href="Customer?parm=delete&Customer_id=">修改</a></td>
						<td><s:property value="#first_name" /></td>
						<td><s:property value="#last_name" /></td>
						<td><s:property value="#address_id.address_id" /></td>
						<td><s:property value="#email" /></td>
						<td><s:property value="#customer_id" /></td>
						<td><s:property value="#last_update.toString()" /></td>
					</tr>
				</s:iterator> -->

			</table>
			<div class='MainStyle'>
				<div class=''>
					<a href="javascript:void(0);" onclick="ajaxpage(1)" value="1">首页</a>
				</div>
				<div class=''>
					<a href='javascript:void(0)' onclick="previouspage()">上一页</a>
				</div>
				<div class='NowItemStyle'>
					<a href='javascript:void(0)' target='_self'>1</a>
				</div>
				<div class=''>
					<a href="javascript:void(0);" onclick="ajaxpage(2)" value="1">2</a>
				</div>
				<div class=''>
					<a href="javascript:void(0);" onclick="ajaxpage(3)" value="1">3</a>
				</div>
				<div class=''>
					<a href='javascript:void(0)' onclick="nextpage()">下一页</a>
				</div>
				<div class=''>
					<a href='javascript:void(0)' onclick="ajaxpage(${allPage})">尾页</a>
				</div>
				<div class=''>
					总共<b>${allnumber}</b>条数据${page}
				</div>
				<div class=''>
					有<b>${allPage}</b>页
				</div>
				<div class=''>
					<b>1</b>/${allPage}
				</div>
				<div class='SearchStyle'>
					<input type='text' id='john_Page_Search'
						onkeydown="if(event.keyCode == 13){page_searchIndex();}" />
				</div>
				<div class=''>
					<input type='button' value='Go' onclick="page_searchIndex()" />
				</div>
			</div> <script>
				//上一页
				function previouspage() {
					if (pages != 1) {
						pages = pages - 1
						ajaxpage(pages);
					} else {
						alert("当前是首页");
					}
				}
				//下一页
				function nextpage() {
					int pageno=${allPage};
					if (pages != pageno) {
						pages = pages + 1
						ajaxpage(pages);
					} else {
						alert("当前是最后一页");
					}
				}

				function page_searchIndex() {
					var searchText = $("#john_Page_Search").val();
					var flag = parseFloat(searchText);
					if (!isNaN(flag)) {
						int pageno=${allPage};
						if (flag > 0 && flag <= pageno) {
							ajaxpage(flag);
						} else {
							alert('需要跳转的页码不能超出范围！');
						}

					} else {
						alert('输入错误！');
					}

				};
			</script>
	</div>
	</div>

</body>
</html>
