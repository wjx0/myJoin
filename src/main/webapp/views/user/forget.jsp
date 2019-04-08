<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商铺加盟管理系统-用户找回</title>
<%@ include file="/views/common/headIncludeFile.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=contextPath%>/resources/css/user/forget.css">
<script type="text/javascript" charset="UTF-8"
	src="<%=contextPath%>/resources/js/user/forget.js"></script>
</head>
<style type="text/css">
body {
	background: url('<%=contextPath%>/resources/images/user/forget/225000-106.jpg')
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
		<b>账&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;&nbsp;&nbsp;找&nbsp;&nbsp;&nbsp;&nbsp;回</b>
	</h2>
	<form id="form" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="userName">请输入你的唯一标识：</label> <input type="text" name="id"
				class="form-control" id="id" placeholder="ID">
		</div>
		<button id="backLog" type="button" class="btn btn-default">返&nbsp;&nbsp;回&nbsp;&nbsp;登&nbsp;&nbsp;录</button>
		<a id="findBack" href="#" type="button" class="btn btn-default">确&nbsp;&nbsp;认&nbsp;&nbsp;找&nbsp;&nbsp;回</a>
	</form>
</body>
</html>