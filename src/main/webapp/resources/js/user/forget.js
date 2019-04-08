$(function(){
       
        $('#backLog').click(function(){
        	window.location.href = contextPath+"/views/login.jsp";
        });
        $('#findBack').click(function() {
        	/*if($("#id").val()==''){
        		$('input').val('请输入标识');
        	}else{*/
        		var loginForm = $("#form").serialize();
        		$.ajax({     
        			url:contextPath+"/user/findBack",     
        			data:loginForm,
        			dataType : 'json',
        			type:'post',     
        			success:function(data, textStatus, jqXHR){     
        				var resCode = data.resCode;
        				if (resCode == '1') {
        					//找回成功
        					$('input').val(data.resMsg);
        				} else {
        					//找回失败
        					$('input').val(data.resMsg);
        				}
        			},
        			error:function(XMLHttpRequest, textStatus, errorThrown,d){    
        				alert(textStatus + '  :  ' + errorThrown + '!');
        			}
        		});  
        	}
     	);
})