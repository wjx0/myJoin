$(function() {
	$('.list a').hover(function() {
		$(this).css('color', 'yellow');
	}, function() {
		$(this).css('color', '#00ff00');
	})
	$('#lw').click(function() {
		var content = $('textarea').val();
		console.log(content.length);
		if (content != null && content != '' && content != undefined) {
			$.ajax({
				url : contextPath + "/system/advice/insert/" + content,
				dataType : 'json',
				type : 'post',
				success : function(data, textStatus, jqXHR) {
					$('textarea').val(data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown, d) {
					alert(textStatus + '  :  ' + errorThrown + '!');
				}
			});
		} else {
			$('textarea').val("请输入内容！");
		}
	});

})