<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String contextPath = request.getContextPath();
	session.setAttribute("path", contextPath);
%>
<link rel="stylesheet" href="<%=contextPath %>/resources/css/bootstrap.min.css">
<script type="text/javascript" charset="UTF-8" src="<%=contextPath %>/resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=contextPath %>/resources/js/jquery.color.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=contextPath %>/resources/js/jquery.animate-colors.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=contextPath %>/resources/js/jquery.animate-colors-min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=contextPath %>/resources/js/jquery.animate-shadow.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=contextPath %>/resources/js/jquery.animate-shadow-min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=contextPath %>/resources/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
        <script src="js/html5shiv.min.js"></script>
        <script src="js/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
var contextPath='<%=contextPath %>';
</script>