$(function() {
	var dataList;
	
	window.onload = function() {
		$.ajax({
			url : contextPath + "/system/message/findListCount",
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				var count = data.t;
				if (count != null) {
					$('#mc').text(count);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	};
	
	
	$('#update').click(function() {
		if($('#detailForm #password').val().length < 5 || $('#detailForm #password').val() == "" 
				|| $('#detailForm #password').val().length > 10){
			$('#validPasswordMsg').css('color', 'red');
			$('#update').attr('disabled',"true");
			$('#validPasswordMsg').text("密码应该在5到10位");
		}else{
			var loginForm = $("#detailForm").serialize();
			$.ajax({
				url : contextPath + "/user/update",
				data :loginForm,
				dataType : 'json',
				type : 'post',
				success : function(data, textStatus, jqXHR) {
					alert(data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown, d) {
					alert(textStatus + '  :  ' + errorThrown + '!');
				}
			});
		}
	});
	
	$('#detailForm #userName').blur(function(){
		if($(this).val().length < 5 || $(this).val() == "" || $(this).val().length > 10){
			$('#validUserNameMsg').css('color', 'red');
			$('#update').attr('disabled',"true");
			$('#validUserNameMsg').text("用户名应该在5到10位");
		}else{
			$.ajax({
				url : contextPath + "/user/validUser/"+$(this).val(),
				type : 'post',
				dataType : 'json',
				success : function(data, textStatus, jqXHR) {
					if(data.resMsg == "用户名已存在"){
						$('#validUserNameMsg').css('color', 'red');
						$('#update').attr('disabled',"true");
					}else{
						$('#validUserNameMsg').css('color', 'green');
						$('#update').removeAttr("disabled"); 
					}
					$('#validUserNameMsg').text(data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown, d) {
					alert(textStatus + '  :  ' + errorThrown + '!');
				}
			});
		}
	});
	
	$('#detailForm #password').blur(function(){
			if($(this).val().length < 5 || $(this).val() == "" || $(this).val().length > 10){
				$('#validPasswordMsg').css('color', 'red');
				$('#update').attr('disabled',"true");
				$('#validPasswordMsg').text("密码应该在5到10位");
			}else{
				$('#update').removeAttr("disabled"); 
				$('#validPasswordMsg').text(" ");
			}
	});
	
	$('#detailForm #mail').blur(function(){
			if($(this).val()!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test($(this).val())){
				$('#validMailMsg').css('color', 'red');
				$('#update').attr('disabled',"true");
				$('#validMailMsg').text("邮箱格式不正确");
			}else{
				$('#update').removeAttr("disabled"); 
				$('#validMailMsg').text(" ");
			}
	});
	
	$('#detailForm #tel').blur(function(){
			if($(this).val()!="" && !/^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/.test($(this).val())){
				$('#validTelMsg').css('color', 'red');
				$('#update').attr('disabled',"true");
				$('#validTelMsg').text("电话格式不正确");
			}else{
				$('update').removeAttr("disabled"); 
				$('#validTelMsg').text(" ");
			}
	});
	
	$('.container .dropdown-menu a').hover(function() {
		$(this).css('color', 'black');
	}, function() {
		$(this).css('color', '#FFFFFF');
	});
	
	$('.container .dropdown-menu a').click(function() {
		$('#roleName').val($(this).text());
	});
	
	var a1 = 0;
	$('.container').hover(function() {
		if (a1 == 0) {
			a1++;
			$(this).stop();
			$(this).animate({
				boxShadow : '-10px -10px 5px #444',
				'margin-bottom' : '10%',
				'margin-top' : '11%',
				'background-color' : 'rgba(0,0,0,0.5)',
			}, 300);
		}
	}, function() {
		if (a1 == 1) {
			a1--;
			$(this).stop();
			$(this).animate({
				boxShadow : 'none',
				'margin-bottom' : '11%',
				'margin-top' : '10%',
				'background-color' : 'rgba(0,0,0,0.2)',
			}, 300);
		}
	});
})