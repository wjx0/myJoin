<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商铺加盟管理系统-建议管理</title>
<%@ include file="/views/common/headIncludeFile.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=contextPath%>/resources/css/system/advice/advice.css">
<script type="text/javascript" charset="UTF-8"
	src="<%=contextPath%>/resources/js/system/advice/advice.js"></script>
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
	<div id="container2" class="container">
		<table class="table table-striped table-hover table-responsive">
			<tr>
				<th>#</th>
				<th>建&nbsp;&nbsp;&nbsp;&nbsp;议</th>
				<th>操&nbsp;&nbsp;&nbsp;&nbsp;作</th>
			</tr>
		</table>
	</div>
	<jsp:include page="/views/common/foot.jsp" />
</body>
</html>

