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
	
	$('#find').click(function() {
		findUserList();
	});
	
	findUserList = function(){
		var o = $("#form").serialize();
		$.ajax({
			url : contextPath + "/user/findUserList",
			data :o,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				dataList = data;
				showData();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	};
	
	showData = function(){
		var total = dataList.totalCount;
		var page = dataList.page + 1;
		var start = dataList.start;
		var rows = dataList.rows;
		var list = dataList.resultList;
		var totalPage = dataList.totalPage;
		list = list.slice(start,total);
		$(".appendTr").remove();
		if (total != 0) {
			// 查询成功
			$.each(list, function(i, item) {
				var tableHtml;
				i++;
							tableHtml += "<tr class='appendTr'>" + "<td>" + i + "</td>";
							if(item.userName != undefined){
								tableHtml += "<td>" + item.userName + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.name != undefined){
								tableHtml += "<td>" + item.name + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.mail != undefined){
								tableHtml += "<td>" + item.mail + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.tel != undefined){
								tableHtml += "<td>" + item.tel + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.roleName != undefined){
								tableHtml += "<td>" + item.roleName + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.updator != undefined){
								tableHtml += "<td>" + item.updator + "</td>";
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.updateTime != undefined){
								tableHtml += "<td>" + item.updateTime + "</td>";
							}else{
								tableHtml += "<td></td>" ;
							}
							tableHtml += "<td><a title='修改' class='glyphicon glyphicon-pencil' data-id='" + item.id 
										+ "' data-userName='" + item.userName + "' data-name='" + item.name 
										+ "' data-mail='" + item.mail + "' data-tel='" + item.tel + "' data-roleName='" 
										+ item.roleName + "' onclick='updateData(this);' ></a>&nbsp;&nbsp;&nbsp;&nbsp;" +
									"<a title='删除' class='glyphicon glyphicon-minus' data-id='" + item.id + "' onclick='deleteData(this);'</a>"
							+"</td>"
						+ "</tr>"
						$("table").append(tableHtml);
					if(i == rows){
						return false;
					}
			});
			$("table").append(
				"<tr class='tableData appendTr'><td colspan='3'><strong>共"+ total +"条数据</strong></td>"
					+ "<td colspan='4'><a href='javascript:void(0)' onclick='previous();'>" 
					+ "<span class='glyphicon glyphicon-chevron-left'></span></a><span><strong>" + page + "</strong></span>"
					+ "<a href='javascript:void(0)' onclick='next();'><span class='glyphicon glyphicon-chevron-right'>"
					+ "</span></a></td><td colspan='2'><span id='totalPage'>共"+ totalPage +"页</span>" 
				  	+ "<input type='text' id='turnNum' /><a title='跳转' href='javascript:void(0)' onclick='turn();'>"
				  	+ "<span class='glyphicon glyphicon-share-alt'></span></a></td>"
				+ "</tr>");
			  
		} else {
			// 查询失败
			$("table").append(
					"<tr class='appendTr'>"
						+ "<td colspan='9'><h4>暂无数据！</h4></td>" 
					+ "</tr>");
		}
	};
	
	previous = function(){
		if(dataList.page == 0){
			alert("已经是第一页!");
			return false;
		}
		dataList.page -- ;
		dataList.start -= dataList.rows;
		showData();
	};
	
	next = function(){
		if(dataList.start + dataList.rows >= dataList.totalCount){
			alert("已经是最后一页!");
			return false;
		}
		dataList.page ++ ;
		dataList.start += dataList.rows;
		showData();
	};
	
	turn = function(){
		if($('#turnNum').val() == ''){
			alert("请输入页码！");
			$('#turnNum').val("");
			return false;
		}
		if(!/^\+?[1-9][0-9]*$/.test($('#turnNum').val())){
			alert("页码必须是正整数！");
			$('#turnNum').val("");
			return false;
		}
		if($('#turnNum').val() > dataList.totalPage){
			alert("输入页码大于总页码！");
			$('#turnNum').val("");
			return false;
		}
		dataList.page = $('#turnNum').val() - 1;
		dataList.start = dataList.page * dataList.rows;
		showData();
	};
	
	deleteData = function(e){
		var id = e.getAttribute("data-id");
		var isTrue = confirm("确定删除？");
		if(!isTrue){
			return false;
		}
		$.ajax({
			url : contextPath + "/user/delete/"+id,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				findUserList();
				alert(data.resMsg);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	};
	
	updateData = function(e){
		var id = e.getAttribute("data-id");
		var userName = e.getAttribute("data-userName");
		var name = e.getAttribute("data-name");
		var mail = e.getAttribute("data-mail");
		var tel = e.getAttribute("data-tel");
		var roleName = e.getAttribute("data-roleName");
		if(id != "undefined"){
			$('#updateForm #id').val(id);
		}
		if(userName != "undefined"){
			$('#updateForm #userName').val(userName);
		}
		if(name != "undefined"){
			$('#updateForm #name').val(name);
		}
		if(mail != "undefined"){
			$('#updateForm #mail').val(mail);
		}
		if(tel != "undefined"){
			$('#updateForm #tel').val(tel);
		}
		if(roleName != "undefined"){
			$('#updateForm #roleName').val(roleName);
		}else{
			$('#updateForm #roleName').val("");
		}
		$('#updateModal').modal('show');
	};
	
	$('#cancel').click(function(){
		$('#updateModal').modal('hide');
	});
	
	$('#updateForm #mail').blur(function(){
		if($(this).val()!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test($(this).val())){
			$('#validMailMsg1').css('color', 'red');
			$('#update').attr('disabled',"true");
			$('#validMailMsg1').text("邮箱格式不正确");
		}else{
			$('#update').removeAttr("disabled"); 
			$('#validMailMsg1').text(" ");
		}
	});
	
	$('#updateForm #tel').blur(function(){
			if($(this).val()!="" && !/^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/.test($(this).val())){
				$('#validTelMsg1').css('color', 'red');
				$('#update').attr('disabled',"true");
				$('#validTelMsg1').text("电话格式不正确");
			}else{
				$('#update').removeAttr("disabled"); 
				$('#validTelMsg1').text(" ");
			}
	});
	
	$('#update').click(function() {
		var loginForm = $("#updateForm").serialize();
			$.ajax({
				url : contextPath + "/user/update",
				data :loginForm,
				dataType : 'json',
				type : 'post',
				success : function(data, textStatus, jqXHR) {
					findUserList();
					alert(data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown, d) {
					alert(textStatus + '  :  ' + errorThrown + '!');
				}
			});
	});
	
	$('#insert').click(function() {
		if($('#insertForm #userName').val().length < 5 || $('#insertForm #userName').val() == "" 
				|| $('#insertForm #userName').val().length > 10){
			$('#validUserNameMsg').css('color', 'red');
			$('#insert').attr('disabled',"true");
			$('#validUserNameMsg').text("用户名应该在5到10位");
		}else if($('#insertForm #password').val().length < 5 || $('#insertForm #password').val() == "" 
				|| $('#insertForm #password').val().length > 10){
			$('#validPasswordMsg').css('color', 'red');
			$('#insert').attr('disabled',"true");
			$('#validPasswordMsg').text("密码应该在5到10位");
		}else{
			var loginForm = $("#insertForm").serialize();
			$.ajax({
				url : contextPath + "/user/insert",
				data :loginForm,
				dataType : 'json',
				type : 'post',
				success : function(data, textStatus, jqXHR) {
					findUserList();
					$("#insertForm")[0].reset();
					alert(data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown, d) {
					alert(textStatus + '  :  ' + errorThrown + '!');
				}
			});
		}
	});
	
	$('#insertForm #userName').blur(function(){
		if($(this).val().length < 5 || $(this).val() == "" || $(this).val().length > 10){
			$('#validUserNameMsg').css('color', 'red');
			$('#insert').attr('disabled',"true");
			$('#validUserNameMsg').text("用户名应该在5到10位");
		}else{
			$.ajax({
				url : contextPath + "/user/validUser/"+$(this).val(),
				type : 'post',
				dataType : 'json',
				success : function(data, textStatus, jqXHR) {
					if(data.resMsg == "用户名已存在"){
						$('#validUserNameMsg').css('color', 'red');
						$('#insert').attr('disabled',"true");
					}else{
						$('#validUserNameMsg').css('color', 'green');
						$('#insert').removeAttr("disabled"); 
					}
					$('#validUserNameMsg').text(data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown, d) {
					alert(textStatus + '  :  ' + errorThrown + '!');
				}
			});
		}
	});
	
	$('#insertForm #password').blur(function(){
			if($(this).val().length < 5 || $(this).val() == "" || $(this).val().length > 10){
				$('#validPasswordMsg').css('color', 'red');
				$('#insert').attr('disabled',"true");
				$('#validPasswordMsg').text("密码应该在5到10位");
			}else{
				$('#insert').removeAttr("disabled"); 
				$('#validPasswordMsg').text(" ");
			}
	});
	
	$('#insertForm #mail').blur(function(){
			if($(this).val()!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test($(this).val())){
				$('#validMailMsg').css('color', 'red');
				$('#insert').attr('disabled',"true");
				$('#validMailMsg').text("邮箱格式不正确");
			}else{
				$('#insert').removeAttr("disabled"); 
				$('#validMailMsg').text(" ");
			}
	});
	
	$('#insertForm #tel').blur(function(){
			if($(this).val()!="" && !/^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/.test($(this).val())){
				$('#validTelMsg').css('color', 'red');
				$('#insert').attr('disabled',"true");
				$('#validTelMsg').text("电话格式不正确");
			}else{
				$('#insert').removeAttr("disabled"); 
				$('#validTelMsg').text(" ");
			}
	});
	
	$('#toUser').removeClass('navT');
	
	$('#container1 .dropdown-menu a').hover(function() {
		$(this).css('color', 'black');
	}, function() {
		$(this).css('color', '#FFFFFF');
	});
	
	$('#container1 .dropdown-menu a').click(function() {
		$('#roleName').val($(this).text());
	});
	
	$('#insertForm .dropdown-menu a').click(function() {
		$('#insertForm #roleName').val($(this).text());
	});
	
	$('#updateForm .dropdown-menu a').click(function() {
		$('#updateForm #roleName').val($(this).text());
	});
	
	var a1 = 0;
	$('#container1').hover(function() {
		if (a1 == 0) {
			a1++;
			$(this).stop();
			$(this).animate({
				boxShadow : '-10px -10px 5px #444',
				'margin-bottom' : '-1%',
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
				'margin-bottom' : '0%',
				'margin-top' : '10%',
				'background-color' : 'rgba(0,0,0,0.2)',
			}, 300);
		}
	});
	
	var a2 = 0;
	$('#container2').hover(function() {
		if (a2 == 0) {
			a2++;
			$(this).stop();
			$(this).animate({
				boxShadow : '-10px -10px 5px #444',
				'margin-bottom' : '7%',
				'margin-top' : '6%',
				'background-color' : 'rgba(0,0,0,0.5)',
			}, 300);
		}
	}, function() {
		if (a2 == 1) {
			a2--;
			$(this).stop();
			$(this).animate({
				boxShadow : 'none',
				'margin-bottom' : '8%',
				'margin-top' : '5%',
				'background-color' : 'rgba(0,0,0,0.2)',
			}, 300);
		}
	});
})