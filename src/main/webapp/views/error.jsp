<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商铺加盟管理系统-错误</title>
<%@ include file="/views/common/headIncludeFile.jsp"%>
</head>
<style>
body {
	background:
		url('<%=contextPath%>/resources/images/error/104926-106.jpg')
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	color: #fff;
	background-color: #333;
}

h1 {
	text-align: center;
	margin: 15% 28% 2% 30%;
	color: red;
	font-size: 4vw;
}

.btn {
	background-color: rgba(0, 0, 0, 0.1);
	width: 13%;
	margin: 0 auto;
	font-size: 1.3vw;
}
</style>
<body>
	<h1><strong>出 错 了 ！</strong></h1>
	<button type="button" class="btn btn-default btn-block" onclick="javascript:window.history.back(-1);">
		<span class="glyphicon glyphicon-circle-arrow-left"></span>&nbsp;&nbsp;返回 上 一 页
	</button>
</body>
</html>