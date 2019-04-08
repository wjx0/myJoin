$(function() {

	var a1 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 1800) {
			if (a1 == 0) {
				a1++;
				$('#navbar').stop();
				$('#nav').stop();
				$('title').stop();
				$('#title').animate({
					'margin-top' : '-15%'
				}, 1000);
				$('#navbar').animate({
					'background-color' : 'rgba(0,0,0,0.9)',
					'border-radius' : '0',
					'margin' : '0',
					'padding' : '1%'
				}, 1000);
				$('#nav').animate({
					'margin-top' : '0'
				}, 1000);

			}
		} else {
			if (a1 == 1) {
				a1--;
				$('#navbar').stop();
				$('#nav').stop();
				$('title').stop();
				$('#title').animate({
					'margin-top' : '-22%'
				}, 1000);
				$('#navbar').animate({
					'background-color' : 'rgba(0,0,0,0)',
					'border-radius' : '25%',
					'margin-left' : '3%',
					'margin-right' : '3%',
					'padding' : '2%'
				}, 1000);
				$('#nav').animate({
					'margin-top' : '-1%'
				}, 1000);

			}
		}
	});
	var a12 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 2100) {
			if (a12 == 0) {
				a12++;
				$('#bnav').stop();
				$('#bnav').animate({
					'opacity' : '.8'
				}, 1000);

			}
		} else {
			if (a12 == 1) {
				a12--;
				$('#bnav').stop();
				$('#bnav').animate({
					'opacity' : '0'
				}, 1000);

			}
		}
	});
	
	$('.navT').hover(function() {
		$(this).css('border-bottom', '2px solid red');
	}, function() {
		$(this).css('border', 'none');
	})
	$('#bnav a').hover(function() {
		$(this).css('color', 'red');
	}, function() {
		$(this).css('color', 'rgba(0,0,0,0.6)');
	})
	$('#bnav a').click(function() {
		$('body').animate({
			scrollTop : '0'
		}, 1300);
	})
	$('#nav .dropdown-menu a').hover(function() {
		$(this).css('color', 'black');
	}, function() {
		$(this).css('color', '#FFFFFF');
	})
	$('#shu').hover(function() {
		$(this).css('color', 'red');
	}, function() {
		$(this).css('color', '#FFFFFF');
	})
	$('#userDetail').click(function() {
		var userName = $('#userName').text();
		window.location.href = contextPath + "/user/findUser/" + userName;
	});
})