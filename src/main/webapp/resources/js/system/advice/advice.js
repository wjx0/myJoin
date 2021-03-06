$(function() {
	var dataList;
	
	$('#find').click(function() {
		findAdviceList();
	});
	
	findAdviceList = function(){
		var o = $("#form").serialize();
		$.ajax({
			url : contextPath + "/system/advice/findAdviceList",
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
							if(item.content != undefined){
								tableHtml += "<td>" + item.content + "</td>" ;
							}else{
								tableHtml += "<td></td>" ;
							}
							tableHtml += "<td><a title='删除' class='glyphicon glyphicon-minus' data-id='" + item.id + "' onclick='deleteData(this);'</a>"
							+"</td>"
						+ "</tr>"
						$("table").append(tableHtml);
					if(i == rows){
						return false;
					}
			});
			$("table").append(
				"<tr class='tableData appendTr'><td ><strong>共"+ total +"条数据</strong></td>"
					+ "<td ><a href='javascript:void(0)' onclick='previous();'>" 
					+ "<span class='glyphicon glyphicon-chevron-left'></span></a><span><strong>" + page + "</strong></span>"
					+ "<a href='javascript:void(0)' onclick='next();'><span class='glyphicon glyphicon-chevron-right'>"
					+ "</span></a></td><td ><span id='totalPage'>共"+ totalPage +"页</span>" 
				  	+ "<input type='text' id='turnNum' /><a title='跳转' href='javascript:void(0)' onclick='turn();'>"
				  	+ "<span class='glyphicon glyphicon-share-alt'></span></a></td>"
				+ "</tr>");
			  
		} else {
			// 查询失败
			$("table").append(
					"<tr class='appendTr'>"
						+ "<td colspan='3'><h4>暂无数据！</h4></td>" 
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
	
	$('#toAdvice').removeClass('navT');
	
	
	deleteData = function(e){
		var id = e.getAttribute("data-id");
		var isTrue = confirm("确定删除？");
		if(!isTrue){
			return false;
		}
		$.ajax({
			url : contextPath + "/system/advice/delete/"+id,
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				findAdviceList();
				alert(data.resMsg);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
	};
	
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