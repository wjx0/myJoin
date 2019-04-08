<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/headIncludeFile.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/resources/css/common/navbar.css">
<script type="text/javascript" charset="UTF-8"
	src="<%=contextPath%>/resources/js/common/navbar.js"></script>
</head>
<body>
	<nav id="navbar"
		class="navbar navbar-inverse navbar-fixed-top navbar-text"
		role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a id="title" class="navbar-brand" href="javascript:void(0)"><strong>商铺管理系统</strong></a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<ul class="nav navbar-nav navbar-right" id="nav">
			<li><a id="toIndex" class="navT" href="<%=contextPath%>/views/index.jsp"><strong>首页</strong></a></li>
			<li><a id="toUser" class="navT" href="<%=contextPath%>/views/user/user.jsp"><strong>用户管理</strong></a></li>
			<li><a id="toNotice" class="navT" href="<%=contextPath%>/views/system/notice.jsp"><strong>商铺管理</strong></a></li>
			<li><a id="shu" href="javascript:void(0)"><strong>丨</strong></a></li>
			<li><a id="message" class="navT" href="<%=contextPath%>/views/system/message.jsp">
					<span class="glyphicon glyphicon-envelope"></span> <span id="mc"
					class="badge"></span>
			</a></li>
			<li class="dropdown"><a id="userName" class="navT"
				href="javascript:void(0)" class="dropdown-toggle"
				data-toggle="dropdown"> <strong>${SPRING_SECURITY_CONTEXT.authentication.principal.userRole.userName}</strong>
					<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a id="userDetail" href="javascript:void(0)"><strong>个人信息</strong></a></li>
					<li class="divider"></li>
					<li><a id="logout" href="<%=contextPath%>/logout"><strong>注销</strong></a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<nav id="bnav" class="navbar navbar-inverse navbar-fixed-bottom"
		role="navigation"> <a href="javascript:void(0)"><span
		class="glyphicon glyphicon-chevron-up"></span></a> </nav>
</body>
</html>