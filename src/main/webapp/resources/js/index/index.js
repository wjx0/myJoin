$(function() {

	window.onload = function() {
		$.ajax({
			url : contextPath + "/system/notice/findList",
			dataType : 'json',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				var rows = data.resultList;
				if (rows != null) {
					// 查询成功
					$.each(rows, function(i, item) {
						if (i == 0) {
							$("#ver").append( 
									"<div class='item active'>"
											+ "<p class='ticker-headline'>"
										+ "<a href='" + contextPath
												+ "/system/notice/findNotice/"
											+ item.title + "'>" + "<span>"
											+ item.title + "</span>" + "</a>"
											+ "</p>" + "</div>");
						} else {
							$("#ver").append(
									"<div class='item'>"
											+ "<p class='ticker-headline'>"
											+ "<a href='" + contextPath
											+ "/system/notice/findNotice/"
											+ item.title + "'>" + "<span>"
											+ item.title + "</span>" + "</a>"
											+ "</p>" + "</div>");
						}
					});
				} else {
					// 查询失败
					$("#ver").append(
							"<div class='item'>"
									+ "<p class='ticker-headline'>"
									+ "<a href='#'>" + "<span>" + 暂无公告
									+ "</span>" + "</a>" + "</p>" + "</div>")
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, d) {
				alert(textStatus + '  :  ' + errorThrown + '!');
			}
		});
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
	}

	var a2 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 3900) {
			if (a2 == 0) {
				a2++;
				$('#e1').animate({
					'opacity' : '1'
				}, 900);

			}
		}
	});
	var a3 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 4700) {
			if (a3 == 0) {
				a3++;
				$('#e2').animate({
					'opacity' : '1'
				}, 900);

			}
		}
	});
	var a4 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 5500) {
			if (a4 == 0) {
				a4++;
				$('#e3').animate({
					'opacity' : '1'
				}, 900);

			}
		}
	});
	var a5 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 6300) {
			if (a5 == 0) {
				a5++;
				$('#e4').animate({
					'opacity' : '1'
				}, 900);

			}
		}
	});
	var a6 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 7600) {
			if (a6 == 0) {
				a6++;
				$('.paterner').animate({
					'opacity' : '1',
				}, 1500, function() {
					var c1 = 0;
					$('.paterner').hover(function() {
						if (c1 == 0) {
							c1++;
							$(this).stop();
							$(this).animate({
								boxShadow : '10px 10px 5px rgba(0,0,0,.3)',
								'margin-top' : '3%',
								'margin-bottom' : '2%',
								'background-color' : 'rgba(255,255,255,.7)',
							}, 300);
						}
					}, function() {
						if (c1 == 1) {
							c1--;
							$(this).stop();
							$(this).animate({
								boxShadow : 'none',
								'margin-top' : '4%',
								'margin-bottom' : '1%',
								'background-color' : 'rgba(0,0,0,0)',
							}, 300);
						}
					})
				});
			}
		}
	});
	var a7 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 1300) {
			if (a7 == 0) {
				a7++;
				$('#characteristic a').animate({
					'opacity' : '1'
				}, 1500);
				$('#characteristic .caption').animate({
					'margin-left' : '15%',
					'opacity' : '1'
				}, 1500);
			}
		}
	});
	var a8 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 1700) {
			if (a8 == 0) {
				a8++;
				$('#characteristic1 a').animate({
					'opacity' : '1'
				}, 1500);
				$('#characteristic1 .caption').animate({
					'margin-right' : '15%',
					'opacity' : '1'
				}, 1500);
			}
		}
	});
	var a9 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 2100) {
			if (a9 == 0) {
				a9++;
				$('#characteristic2 a').animate({
					'opacity' : '1'
				}, 1500);
				$('#characteristic2 .caption').animate({
					'margin-left' : '15%',
					'opacity' : '1'
				}, 1500);
			}
		}
	});
	var a10 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 2500) {
			if (a10 == 0) {
				a10++;
				$('#characteristic3 a').animate({
					'opacity' : '1'
				}, 1500);
				$('#characteristic3 .caption').animate({
					'margin-right' : '15%',
					'opacity' : '1'
				}, 1500);
			}
		}
	});
	var a11 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 2900) {
			if (a11 == 0) {
				a11++;
				$('#characteristic4 a').animate({
					'opacity' : '1'
				}, 1500);
				$('#characteristic4 .caption').animate({
					'margin-left' : '15%',
					'opacity' : '1'
				}, 1500);
			}
		}
	});
	var a13 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 1100) {
			if (a13 == 0) {
				a13++;
				$('#logo1').animate({
					'opacity' : '1',
				}, 1500);
				$('#title1').animate({
					'opacity' : '1',
					'margin-top' : '-2%',
					'margin-bottom' : '4%'
				}, 1500);
			}
		}
	});
	var a14 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 3500) {
			if (a14 == 0) {
				a14++;
				$('#logo2').animate({
					'opacity' : '1',
				}, 1500);
				$('#title2').animate({
					'opacity' : '1',
					'margin-top' : '-2%',
					'margin-bottom' : '4%'
				}, 1500);
			}
		}
	});
	var a15 = 0;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 7000) {
			if (a15 == 0) {
				a15++;
				$('#logo3').animate({
					'opacity' : '1',
				}, 1500);
				$('#title3').animate({
					'opacity' : '1',
					'margin-top' : '-2%',
					'margin-bottom' : '4%'
				}, 1500);
			}
		}
	});
	var c2 = 0;
	$('.bg').hover(function() {
		if (c2 == 0) {
			c2++;
			$(this).stop();
			$(this).animate({
				boxShadow : '-10px -10px 5px #444',
				'margin-bottom' : '-2%',
				'margin-top' : '2%',
				'background-color' : 'rgba(0,0,0,0.5)',
			}, 300);
		}
	}, function() {
		if (c2 == 1) {
			c2--;
			$(this).stop();
			$(this).animate({
				boxShadow : 'none',
				'margin-top' : '0%',
				'margin-bottom' : '0%',
				'background-color' : 'rgba(0,0,0,0.2)',
			}, 300);
		}
	})
	var c3 = 0;
	$('.bg2').hover(function() {
		if (c3 == 0) {
			c3++;
			$(this).stop();
			$(this).animate({
				boxShadow : '-10px -10px 5px #444',
				'margin-top' : '10%',
				'margin-bottom' : '1%',
				'background-color' : 'rgba(0,0,0,0.5)',
			}, 300);
		}
	}, function() {
		if (c3 == 1) {
			c3--;
			$(this).stop();
			$(this).animate({
				boxShadow : 'none',
				'margin-top' : '8%',
				'margin-bottom' : '3%',
				'background-color' : 'rgba(0,0,0,0.2)',
			}, 300);
		}
	})
	var c4 = 0;
	$('.bg1').hover(function() {
		if (c4 == 0) {
			c4++;
			$(this).stop();
			$(this).animate({
				boxShadow : '-10px -10px 5px #444',
				'margin-bottom' : '-1%',
				'margin-top' : '6%',
				'background-color' : 'rgba(0,0,0,0.5)',
			}, 300);
		}
	}, function() {
		if (c4 == 1) {
			c4--;
			$(this).stop();
			$(this).animate({
				boxShadow : 'none',
				'margin-bottom' : '0%',
				'margin-top' : '5%',
				'background-color' : 'rgba(0,0,0,0.2)',
			}, 300);
		}
	})

	$('.carousel-caption h1').animate({
		'margin-top' : '12%',
		'opacity' : '1'
	}, 1000);
	$('#carousel-example-generic').on('slide.bs.carousel', function() {
		$('.carousel-caption #h1').stop();
		$('.carousel-caption #h2').stop();
		$('.carousel-caption #h3').stop();
		$('.carousel-caption #h4').stop();
		$('.carousel-caption p').stop();
		$('.carousel-caption div').stop();
		$('.carousel-caption a').stop();
		$('.carousel-caption #h1').animate({
			'opacity' : '0',
			'margin-top' : '5%',
		}, 1);
		$('.carousel-caption #h2').animate({
			'opacity' : '0',
			'margin-top' : '5%',
		}, 1);
		$('.carousel-caption #h3').animate({
			'opacity' : '0',
			'margin-top' : '5%',
		}, 1);
		$('.carousel-caption #h4').animate({
			'opacity' : '0',
			'margin-top' : '5%',
		}, 1);
		$('.carousel-caption a').animate({
			'opacity' : '0',
			'margin-top' : '1%',
		}, 1);
		$('.carousel-caption p').animate({
			'opacity' : '0',
		}, 1);
		$('.carousel-caption div').animate({
			'opacity' : '0',
			'margin-top' : '20%',
		}, 1);

		$('.carousel-caption #h1').animate({
			'opacity' : '1',
			'margin-top' : '12%',
		}, 1500);

		$('.carousel-caption #h2').animate({
			'opacity' : '1',
			'margin-top' : '12%',
		}, 1500, function() {
			$('.carousel-caption a').animate({
				'opacity' : '1',
				'margin-top' : '5%',
			}, 1500);
		});
		$('.carousel-caption #h3').animate({
			'opacity' : '1',
			'margin-top' : '12%',
		}, 1500);
		$('.carousel-caption #h4').animate({
			'opacity' : '1',
			'margin-top' : '12%',
		}, 1500, function() {
			$('.carousel-caption p').animate({
				'opacity' : '1',
			}, 1500);
		});

		$('.carousel-caption div').animate({
			'opacity' : '.9',
			'margin-top' : '10%',
		}, 1500);
	});

	$('#toIndex').removeClass('navT');
	$('#ver').mouseover(function() {
		$('#ver span').css('color', 'red');
	})
	$('#ver').mouseout(function() {
		$('#ver span').css('color', '#FFFFFF');
	})
	$('.example h3').mouseover(function() {
		$(this).stop();
		$(this).animate({
			'color' : 'rgba(255,255,255,0.9)',
			'font-size' : '3vw'
		}, 500);
	})
	$('.example h3').mouseout(function() {
		$(this).stop();
		$(this).animate({
			'color' : 'rgba(0,0,0,0)',
			'font-size' : '5vw'
		}, 500);
	})
	$('.carousel').carousel({
		interval : 5000
	})

})