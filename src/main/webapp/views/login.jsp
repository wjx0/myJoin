<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商铺加盟管理系统-登录</title>
<%@ include file="/views/common/headIncludeFile.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=contextPath%>/resources/css/login/login.css">
<script type="text/javascript" charset="UTF-8"
	src="<%=contextPath%>/resources/js/login/login.js"></script>
</head>
<style type="text/css">
body {
	background: url('<%=contextPath%>/resources/images/login/269547.jpg')
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	color: #fff;
	background-color: #333;
	padding-top: 10%;
}
</style>
<body class="container">
	<div>
		<img src="<%=contextPath%>/resources/images/common/148220569029864.png"
			class="img-responsive" alt="系统LOGO">
	</div>
	<h2>
		<b>系&nbsp;&nbsp;&nbsp;&nbsp;统&nbsp;&nbsp;&nbsp;&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录</b>
	</h2>
	<form id="form" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="userName">用户名：</label> <input type="text" name="userName"
				class="form-control" id="userName" placeholder="Username"> <input
				id="ub" type="hidden"><span id="us"></span></input>
		</div>
		<div class="form-group">
			<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label> <input
				type="password" name="password" class="form-control" id="password"
				placeholder="Password"> <input id="pb" type="hidden"><span
				id="ps"></span></input>
		</div>
		<input id="log" type="button" value="登&nbsp;&nbsp;&nbsp;&nbsp;录" class="btn btn-default"> 
		<input id="forget" type="button" value="忘记用户名或密码" class="btn btn-default">
	</form>
</body>
</html>
