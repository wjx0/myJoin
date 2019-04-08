<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商铺加盟管理系统-商铺管理</title>
<%@ include file="/views/common/headIncludeFile.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=contextPath%>/resources/css/user/userDetail.css">
<script type="text/javascript" charset="UTF-8"
	src="<%=contextPath%>/resources/js/notice/noticeDetail.js"></script>
</head>

<style>
body {
	background: url('<%=contextPath%>/resources/images/user/197697-106.jpg')
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	color: #fff;
	background-color: #333;
}
</style>
<body data-spy="scroll" data-target="#navbar">
	<jsp:include page="/views/common/navbar.jsp" />
	<div class="container">
		<form id="detailForm" role="form">
			<div class="form-group sel">
				<label for="userName">商铺名：</label>
				<input type="text" name="userName" class="form-control" readonly="readonly"
					id="userName" placeholder="Username" value="${userVo.userName }">
			</div>
			<div class="form-group sel">
				<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码：<span
					id="validPasswordMsg"></span></label> <input type="password"
					name="password" class="form-control" id="password"
					placeholder="Password" value="${userVo.password }">
			</div>
			<div class="form-group sel">
				<label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label> <input
					type="text" name="name" class="form-control" id="name"
					placeholder="Name" value="${userVo.name }">
			</div>
			<div class="form-group sel">
				<label for="mail">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<span
					id="validMailMsg"></span></label> <input type="text" name="mail"
					class="form-control" id="mail" placeholder="Mail" value="${userVo.mail }">
			</div>
			<div class="form-group sel">
				<label for="tel">电&nbsp;&nbsp;&nbsp;&nbsp;话：<span
					id="validTelMsg"></span></label> <input type="text" name="tel"
					class="form-control" id="tel" placeholder="Tel" value="${userVo.tel }">
			</div>
			<div class="form-group sel">
				<label for="roleName">角&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
				<div class="input-group">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							角&nbsp;&nbsp;&nbsp;&nbsp;色 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">ROLE_FRANCHISEE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(加盟商)</li>
							<li><a href="#">ROLE_AGENT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(代理商)</li>
							<li><a href="#">ROLE_FRANCHISEMANAGER</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(加盟管理员)</li>
							<li><a href="#">ROLE_SYSTEMMANAGER</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(系统管理员)</li>
							<li role="separator" class="divider"></li>
							<li><a class="disabled" href="#">ROLE_ADMIN</a></li>
						</ul>
					</div>
					<!-- /btn-group -->
					<input type="text" name="roleName" id="roleName"
						class="form-control" placeholder="Rolename" value="${userVo.roleName }">
				</div>
				<!-- /input-group -->
			</div>
			<!-- /input-group -->
			<div class="form-group sel">
				<label><span></span></label>
			</div>
			<div class="form-group">
				<label for="update">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
					id="update" type="button" value="修&nbsp;&nbsp;&nbsp;&nbsp;改"
					class="btn btn-default fb form-control">
			</div>
		</form>
	</div>
	<jsp:include page="/views/common/foot.jsp" />
</body>
</html>

