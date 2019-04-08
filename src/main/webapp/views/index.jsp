<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商铺加盟管理系统-首页</title>
<%@ include file="/views/common/headIncludeFile.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=contextPath %>/resources/css/index/index.css">
<script type="text/javascript" charset="UTF-8"
	src="<%=contextPath %>/resources/js/index/index.js"></script>
</head>

<style>
body {
	background: url('<%=contextPath %>/resources/images/index/209179-106.jpg')
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	color: #fff;
	background-color: #333;
}
#interval14{
background: url('<%=contextPath %>/resources/images/index/212938-106.jpg')
		no-repeat center center fixed;
}
#interval13{
background: url('<%=contextPath %>/resources/images/index/51335-106.jpg')
		no-repeat center center fixed;
}
.example{
background: url('<%=contextPath %>/resources/images/index/132040.jpg')
		no-repeat center center fixed;
}
.prow1{
background: url('<%=contextPath %>/resources/images/index/jianyue15.png')
		no-repeat center center fixed;
}
.prow2{
background: url('<%=contextPath %>/resources/images/index/jianyue15.png')
		no-repeat center center fixed;
}
#log1{
background: url('<%=contextPath %>/resources/images/index/2010071906113618.jpg')
		no-repeat center center fixed;
}
#log2{
background: url('<%=contextPath %>/resources/images/index/132040.jpg')
		no-repeat center center fixed;
}
#log3{
background: url('<%=contextPath %>/resources/images/index/jianyue15.png')
		no-repeat center center fixed;
}
.characteristic{
background: url('<%=contextPath %>/resources/images/index/2010071906113618.jpg')
		no-repeat center center fixed;
}
</style>
<body data-spy="scroll" data-target="#navbar">
	<jsp:include page="/views/common/navbar.jsp"/>
	<div id="carousel-example-generic" class="carousel slide carousel-fade"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			<li data-target="#carousel-example-generic" data-slide-to="3"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<a href="javascript:void(0)"><img
					src="<%=contextPath %>/resources/images/index/317521-106.jpg" alt="0 slide"></a>
				<div class="carousel-caption ">
					<h1 id="h1"><strong>欢&nbsp;迎&nbsp;进&nbsp;入&nbsp;MyJoin&nbsp;!</strong></h1>
				</div>
			</div>
			<div class="item">
				<a href="javascript:void(0)"><img
					src="<%=contextPath %>/resources/images/index/212937-106.jpg"
					alt="1 slide"></a>
				<div class="carousel-caption">
					<h1 id="h2">我们更了解您</h1>
					<a>优 质 的 产 品 ， 提 供 给 顾 客 更 好 的 选 择<br>
						低 价 的 货 源 ， 降 低 您 的 成 本<br>
						广 泛 的 网 点 ， 更 加 便 捷 的 服 务
					</a>
				</div>
			</div>
			<div class="item">
				<a href="javascript:void(0)"><img
					src="<%=contextPath %>/resources/images/index/320079-106.jpg" alt="2 slide"></a>
				<div class="carousel-caption">
					<h1 id="h3">我们的理念</h1>
					<div>
						<span class="glyphicon glyphicon-check"></span>
						<span class="glyphicon glyphicon-th"></span>
						<span class="glyphicon glyphicon-shopping-cart"></span>
						<br>
						<strong>优 质</strong><strong>便 捷</strong><strong>多 样</strong>
					</div>
				</div>
			</div>
			<div class="item">
				<a href="javascript:void(0)"><img
					src="<%=contextPath %>/resources/images/index/272686-106.jpg"
					alt="3 slide"></a>
				<div class="carousel-caption">
					<h1 id="h4">MyJoin</h1>
					<p><strong>最 值 得 投 资 的 加 盟 企 业 ！</strong></p>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span class="sr-only">Next</span>
		</a>
	</div>
	<div class="interval1">
		<div id="i1" class="interval">
			<img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/148343345919760.png">
		</div>
	</div>
	<div class="bg4">
		<div class="bg">
			<div id="vercontainer" class="container">
				<div id="carousel-example-vertical" class="carousel vertical slide">
					<div id="ver" class="carousel-inner" role="listbox"></div>
					<!-- 上下箭头按钮 -->
					<a class="up carousel-control" href="#carousel-example-vertical"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="down carousel-control" href="#carousel-example-vertical"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
		<div class="bg2">
			<strong><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MyJoin商铺加盟有限公司，xxxx年xx月创立于上海。秉承着“铁腕执行｜用户第一｜专注专业｜创新分享”的核心价值观，
					一直孜孜不倦地追求技术的创新和服务品类的拓广、延伸，依托近年来国内连锁企业迅猛发展，招商需求不断扩大的宏观背景和大众日益将加盟作为一种创业首选方式的大趋势，
					公司持续为用户提供“高质、安全、放心”的加盟项目。为加盟创业者创建从初期寻找项目、下店考察、签订合作意向、缴纳加盟费到后期开店、信赖的一套标准化系统流程。
					未来，连锁网坚持不懈努力，不断完善企业服务内容，创业者保障机制，必将会使得中国的连锁事业变得更美好！</p></strong>
		</div>
	</div>

	<div class="bg1">
		<label for="success">达成规划：</label>
		<div id="success" class="progress progress-striped active">
			<div class="progress-bar progress-bar-success" role="progressbar"
				aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"
				style="width: 90%;"></div>
		</div>
		<label for="info">商户反馈：</label>
		<div id="info" class="progress progress-striped active">
			<div class="progress-bar progress-bar-info" role="progressbar"
				aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
				style="width: 80%;"></div>
		</div>
		<label for="warning">市场影响：</label>
		<div id="warning" class="progress progress-striped active">
			<div class="progress-bar progress-bar-warning" role="progressbar"
				aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
				style="width: 70%;"></div>
		</div>
		<label for="danger">存在问题：</label>
		<div id="danger" class="progress progress-striped active">
			<div class="progress-bar progress-bar-danger" role="progressbar"
				aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
				style="width: 10%;"></div>
		</div>
	</div>

	<div class="interval1">
		<div class="interval">
			<img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/148343383091190.png">
		</div>
	</div>
	<div id="log1" class="logo">
		<a href="javascript:void(0)" id="logo1" class="thumbnail"> <img
			src="<%=contextPath %>/resources/images/index/148299633512973.png"
			alt="...">
		</a>
		<div id="title1" class="caption">
			<h3 align="center">
				<strong>我们的特点</strong>
			</h3>
		</div>
	</div>
	<div id="characteristic" class="characteristic characteristicl">
		<a href="javascript:void(0)" class="thumbnail"> <img
			src="<%=contextPath %>/resources/images/index/ea6a23110d0dd8d1a753657152559068.jpg"
			alt="...">
		</a>
		<div class="caption">
			<h2><strong>温馨自然</strong></h2>
			<p>以人为本的设计，给您家的感觉。</p>
		</div>
	</div>
	<div id="characteristic1" class="characteristic characteristicr">
		<a href="javascript:void(0)" class="thumbnail"> <img
			src="<%=contextPath %>/resources/images/index/4f3a75031a1193ccf9086fdc3c122037.jpg"
			alt="...">
		</a>
		<div class="caption">
			<h2><strong>简约纯真</strong></h2>
			<p>饮一杯咖啡，无需复杂。</p>
		</div>
	</div>
	<div id="characteristic2" class="characteristic characteristicl">
		<a href="javascript:void(0)" class="thumbnail"> <img
			src="<%=contextPath %>/resources/images/index/394ef93caf474023dcc9729acc49f3e9.jpg"
			alt="...">
		</a>
		<div class="caption">
			<h2><strong>健康绿色</strong></h2>
			<p>美食不止美味。</p>
		</div>
	</div>
	<div id="characteristic3" class="characteristic characteristicr">
		<a href="javascript:void(0)" class="thumbnail"> <img
			src="<%=contextPath %>/resources/images/index/b871b3032a89511432c42726c3803e03.jpg"
			alt="...">
		</a>
		<div class="caption">
			<h2><strong>现代时尚</strong></h2>
			<p>时尚前沿的设计，绚丽并不代表另类。</p>
		</div>
	</div>
	<div id="characteristic4" class="characteristic characteristicl">
		<a href="javascript:void(0)" class="thumbnail"> <img
			src="<%=contextPath %>/resources/images/index/2b5ba25ae395eee9378fc158c857ccd7.jpg"
			alt="...">
		</a>
		<div class="caption">
			<h2><strong>风格多样</strong></h2>
			<p>不只简单，还有惊喜的不同。</p>
		</div>
	</div>
	<div id="interval13" class="interval1">
		<div id="i3" class="interval">
			<img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/148343500776877.png">
		</div>
	</div>
	<div id="log2" class="logo">
		<a href="javascript:void(0)" id="logo2" class="thumbnail"> <img class="img-responsive"
			src="<%=contextPath %>/resources/images/index/148299633512973.png"
			alt="...">
		</a>
		<div id="title2" class="caption">
			<h3 align="center">
				<strong>商铺实景</strong>
			</h3>
		</div>
	</div>
	<div class="example">
		<div id="e1" class="thumbnail ">
			<img
				src="<%=contextPath %>/resources/images/index/f94cb859ddd6a2bc1a971e9f91e90d72.jpg"
				alt="...">
			<div id="e11" class="caption">
				<h3 align="center"><strong>上 海 MyRestaurant 优 秀 餐 厅</strong></h3>
			</div>
		</div>
	</div>
	<div class="example">
		<div id="e2" class="thumbnail ">
			<img
				src="<%=contextPath %>/resources/images/index/00b88b99baec46192b3b3ab399119b05.jpg"
				alt="...">
			<div id="e22" class="caption">
				<h3 align="center"><strong>北 京 MyClothing 优 秀 服 装 店</strong></h3>
			</div>
		</div>
	</div>
	<div class="example">
		<div id="e3" class="thumbnail ">
			<img
				src="<%=contextPath %>/resources/images/index/071019a526fa748b6c416fa0e2c43338.jpg"
				alt="...">
			<div id="e33" class="caption">
				<h3 align="center"><strong>黑 龙 江 MyCoffee 优 秀 咖 啡 厅 </strong></h3>
			</div>
		</div>
	</div>
	<div class="example">
		<div id="e4" class="thumbnail ">
			<img src="<%=contextPath %>/resources/images/index/摄图网-简洁大方的房间.jpg"
				alt="...">
			<div id="e44" class="caption">
				<h3 align="center"><strong>山 东 MyHome 优 秀 设 计 样 房</strong></h3>
			</div>
		</div>
	</div>
	<div id="interval14" class="interval1">
		<div id="i4" class="interval">
			<img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/148343599349780.png">
		</div>
	</div>
	<div id="log3" class="logo">
		<a href="javascript:void(0)" id="logo3" class="thumbnail"> <img class="img-responsive"
			src="<%=contextPath %>/resources/images/index/148299633512973.png"
			alt="...">
		</a>
		<div id="title3" class="caption">
			<h3 align="center">
				<strong>我们的伙伴</strong>
			</h3>
		</div>
	</div>
	<div class="prow1">
		<div class="paterner1 paterner">
			<a href="javascript:void(0)"> <img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/logo3.png.png">
			</a>
		</div>
		<div class="paterner2 paterner">
			<a href="javascript:void(0)"> <img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/logo2.png.png">
			</a>
		</div>
		<div class="paterner3 paterner">
			<a href="javascript:void(0)"> <img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/logo5.png.png">
			</a>
		</div>
	</div>
	<div class="prow2">
		<div class="paterner1 paterner">
			<a href="javascript:void(0)"> <img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/logo4.png.png">
			</a>
		</div>
		<div class="paterner2 paterner">
			<a href="javascript:void(0)"> <img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/logo.png.png">
			</a>
		</div>
		<div class="paterner3 paterner">
			<a href="javascript:void(0)"> <img class="img-responsive" alt=""
				src="<%=contextPath %>/resources/images/index/logo1.png.png">
			</a>
		</div>
	</div>
<jsp:include page="/views/common/foot.jsp"/>
</body>
</html>

