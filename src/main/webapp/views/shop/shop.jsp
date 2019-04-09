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
	href="<%=contextPath%>/resources/css/shop/shop.css">
<script type="text/javascript" charset="UTF-8"
	src="<%=contextPath%>/resources/js/shop/shop.js"></script>
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
	<div id="container1" class="container">
		<form id="form" role="form">
			<div class="form-group sel">
				<label for="name">商铺名：</label> <input type="text"
					name="name" class="form-control" id="name"
					placeholder="name">
			</div>
			<div class="form-group sel">
				<label for="address">地&nbsp;&nbsp;&nbsp;&nbsp;址：</label> <input type="text"
					name="address" class="form-control" id="address"
					placeholder="address">
			</div>
			<div class="form-group sel">
				<label for="userName">加盟商：</label> <input type="text"
					name="userName" class="form-control" id="userName"
					placeholder="userName">
			</div>
			
			<input type="hidden" name="page" class="form-control" id="page"
				value="1"> <input type="hidden" name="rows"
				class="form-control" id="rows" value="10">
			<div class="form-group">
				<label for="find">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input id="find"
					type="button" value="查&nbsp;&nbsp;&nbsp;&nbsp;询"
					class="btn btn-default fb selbtn form-control">
			</div>
			<div class="form-group">
				<label for="reset">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
					id="reset" type="reset" value="重&nbsp;&nbsp;&nbsp;&nbsp;置"
					class="btn btn-default fb selbtn form-control">
			</div>
			<c:if test="${SPRING_SECURITY_CONTEXT.authentication.principal.userRole.roleName == 'ROLE_ADMIN'}">
			<div class="form-group">
				<label for="toInsert">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
					id="toInsert" type="button" value="新&nbsp;&nbsp;&nbsp;&nbsp;增"
					class="btn btn-default fb selbtn form-control" data-toggle="modal"
					data-target="#insertModal">
			</div>
			</c:if>
		</form>
	</div>
	<div id="container2" class="container">
		<table class="table table-striped table-hover table-responsive">
			<tr>
				<th>#</th>
				<th>商 铺 名</th>
				<th>地&nbsp;&nbsp;&nbsp;&nbsp;址</th>
				<th>加盟商</th>
				<th>操&nbsp;&nbsp;&nbsp;&nbsp;作</th>
			</tr>
		</table>
	</div>
	<!-- 新增面板 -->
	<div class="modal fade" id="insertModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增商铺</h4>
				</div>
				<div class="modal-body">
					<form id="insertForm" role="form">
						<div class="form-group sel">
							<label for="name">商铺名：</label> <input type="text"
								name="name" class="form-control" id="name"
								placeholder="name">
						</div>
						<div class="form-group sel">
							<label for="address">地&nbsp;&nbsp;&nbsp;&nbsp;址：</span></label> <input type="password"
								name="address" class="form-control" id="address"
								placeholder="address">
						</div>
						<div class="form-group sel">
							<label for="userName">加盟商：</label> <input
								type="text" name="userName" class="form-control" id="userName" 
								placeholder="userName">
						</div>
						</form>
						</div>
				<div class="modal-footer">
					<div class="form-group">
						<label for="insert">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
							id="insert" type="button" value="新&nbsp;&nbsp;&nbsp;&nbsp;增"
							class="btn btn-default fb addbtn form-control">
					</div>
					<div class="form-group">
						<label for="reset">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
							id="reset" type="reset" value="重&nbsp;&nbsp;&nbsp;&nbsp;置"
							class="btn btn-default fb addbtn form-control">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 修改面板 -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改商铺</h4>
				</div>
				<div class="modal-body">
					<form id="updateForm" role="form">
						<input type="hidden" name="id" id="id">
						<div class="form-group sel">
							<label for="name">商铺名：</label><input type="text"
								name="name" class="form-control" id="name" readonly="readonly"
								placeholder="name">
						</div>
						<div class="form-group sel">
							<label for="address">地&nbsp;&nbsp;&nbsp;&nbsp;址：</label> <input
								type="text" name="address" class="form-control" id="address" 
								placeholder="address">
						</div>
						<div class="form-group sel">
							<label for="userName">加盟商：</label> <input
								type="text" name="userName" class="form-control" id="userName" 
								placeholder="userName">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="form-group">
						<label for="uplaod">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
							id="update" type="button" value="修&nbsp;&nbsp;&nbsp;&nbsp;改"
							class="btn btn-default fb updbtn form-control">
					</div>
					<div class="form-group">
						<label for="cancel">&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
							id="cancel" type="button" value="取&nbsp;&nbsp;&nbsp;&nbsp;消"
							class="btn btn-default fb updbtn form-control">
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/views/common/foot.jsp" />
</body>
</html>

