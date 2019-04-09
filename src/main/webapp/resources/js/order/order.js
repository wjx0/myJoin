$(function() {
	var dataList;
	
	$('#find').click(function() {
		findOrderList();
	});
	
	findOrderList = function(){
		var o = $("#form").serialize();
		$.ajax({
			url : contextPath + "/order/order/findOrderList",
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
		var roleName = dataList.roleName;
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
							if(item.productName != undefined){
								tableHtml += "<td>" + item.productName + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.name != undefined){
								tableHtml += "<td>" + item.name + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.quantity != undefined){
								tableHtml += "<td>" + item.quantity + "</td>";
							}else{
								tableHtml += "<td></td>" ;
							}
							if(item.status != undefined){
								tableHtml += "<td>" + item.status + "</td>";
							}else{
								tableHtml += "<td></td>" ;
							}
							if(roleName != 'ROLE_ADMIN'){
								tableHtml += "<td><a title='修改' class='glyphicon glyphicon-pencil' data-id='" + item.id 
								+ "' data-quantity='" + item.quantity + "' data-productName='" + item.productName 
								+ "' onclick='updateData(this);' ></a>&nbsp;&nbsp;&nbsp;&nbsp;" +
								"<a title='删除' class='glyphicon glyphicon-minus' data-id='" + item.id + "' onclick='deleteData(this);'></a>"
								+"</td>"
							}else{
								tableHtml += "<td><a data-id='" + item.id + "'  onclick='pass(this);' ><strong>√</strong></a>&nbsp;&nbsp;&nbsp;&nbsp;" +
								"<a data-id='" + item.id + "' onclick='loseData(this);'><strong>×</strong></a>"
								+"</td>"
							}
						+ "</tr>"
						$("table").append(tableHtml);
					if(i == rows){
						return false;
					}
			});
			$("table").append(
				"<tr class='tableData appendTr'><td colspan='2'><strong>共"+ total +"条数据</strong></td>"
					+ "<td colspan='2'><a href='javascript:void(0)' onclick='previous();'>" 
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
						+ "<td colspan='6'><h4>暂无数据！</h4></td>" 
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
	
	passData = function(e){
		var id = e.getAttribute("data-id");
		var isTrue = confirm("确定通过？");
		if(!isTrue){
			return false;
		}
		$.ajax({
			url : contextPath + "/order/order/pass/"+id,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				findOrderList();
				alert(data.resMsg);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	};
	
	loseData = function(e){
		var id = e.getAttribute("data-id");
		var isTrue = confirm("确定退回？");
		if(!isTrue){
			return false;
		}
		$.ajax({
			url : contextPath + "/order/order/lose/"+id,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				findOrderList();
				alert(data.resMsg);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	};
	
	deleteData = function(e){
		var id = e.getAttribute("data-id");
		var isTrue = confirm("确定删除？");
		if(!isTrue){
			return false;
		}
		$.ajax({
			url : contextPath + "/order/order/delete/"+id,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				findOrderList();
				alert(data.resMsg);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	};
	
	updateData = function(e){
		var id = e.getAttribute("data-id");
		var quantity = e.getAttribute("data-quantity");
		var productName = e.getAttribute("data-productName");
		if(id != "undefined"){
			$('#updateForm #id').val(id);
		}
		if(quantity != "undefined"){
			$('#updateForm #quantity').val(quantity);
		}
		if(productName != "undefined"){
			$('#updateForm #productName').val(productName);
		}
		$('#updateModal').modal('show');
	};
	
	$('#cancel').click(function(){
		$('#updateModal').modal('hide');
	});
	
	
	$('#update').click(function() {
		var loginForm = $("#updateForm").serialize();
			$.ajax({
				url : contextPath + "/order/order/update",
				data :loginForm,
				dataType : 'json',
				type : 'post',
				success : function(data, textStatus, jqXHR) {
					findOrderList();
					alert(data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown, d) {
					alert(textStatus + '  :  ' + errorThrown + '!');
				}
			});
	});
	
	$('#insert').click(function() {
		var loginForm = $("#insertForm").serialize();
		$.ajax({
			url : contextPath + "/order/order/insert",
			data :loginForm,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				findOrderList();
				$("#insertForm")[0].reset();
				alert(data.resMsg);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
		
	});
	
	$('#toOrder').removeClass('navT');
	
	$('#container1 .dropdown-menu a').hover(function() {
		$(this).css('color', 'black');
	}, function() {
		$(this).css('color', '#FFFFFF');
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