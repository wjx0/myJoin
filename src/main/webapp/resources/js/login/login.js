$(function() {
	// 文本框失去焦点后
	$('form :input').blur(function() {
		var $parent = $(this).parent();
		$('#us').html(' ');
		$('#ps').html(' ');
		// 验证用户名
		if ($(this).is('#userName')) {
			if (this.value == "" || this.value.length < 5) {
				$('#us').removeClass();
				$('#us').addClass('glyphicon glyphicon-remove');
				$('#us').html('请输入格式正确的用户名');
			} else {
				$('#us').removeClass();
				$('#us').addClass('glyphicon glyphicon-ok');
			}
		}
		// 验证密码
		if ($(this).is('#password')) {
			if (this.value == "" || this.value.length < 5) {
				$('#ps').removeClass();
				$('#ps').addClass('glyphicon glyphicon-remove');
				$('#ps').html('请输入格式正确的密码.');
			} else {
				$('#ps').removeClass();
				$('#ps').addClass('glyphicon glyphicon-ok');
			}
		}
	}).keyup(function() {
		$(this).triggerHandler("blur");
	}).focus(function() {
		$(this).triggerHandler("blur");
	});// end blur
	$('#log').click(function() {
		var loginForm = $("#form").serialize();
		$.ajax({
			url : contextPath + "/login/login",
			data : loginForm,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				var resCode = data.resCode;
				if (resCode == '1') {
					// 登陆成功 跳转到首页
					window.location.href = contextPath + "/views/index.jsp";
				} else {
					// 登陆失败 清空表单数据
					alert(data.resMsg);
					loginForm.form('clear');
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	});
	$('#forget').click(function() {
		window.location.href = contextPath + "/views/user/forget.jsp";
	});
})