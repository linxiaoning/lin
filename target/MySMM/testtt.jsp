<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'testtt.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		alert(111);
		/* 	$.ajax({
						type : "post",
						url : "customer_ajax.action",
						dataType : "json",
						success : function(data) {
						alert(data.msg);
					}); */

		$.ajax({
			type : "POST",
			url : "testString.action",
			dataType : "json",
			success : function(msg) {
				alert("Data Saved: " + msg.json_Message);
			}
		});

	});
</script>

</head>

<body>
	This is my JSP page.
	<br>
</body>
</html>
