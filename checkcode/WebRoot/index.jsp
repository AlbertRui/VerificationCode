<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function reloadCode() {
		var time = new Date().getTime();
		// 给URL传递参数可以清空浏览器的缓存，让浏览器认为这是一个新的请求
		document.getElementById("imagecode").src = "<%=request.getContextPath()%>/servlet/ImageServlet?d=" + time;
	}
</script>
</head>

<body>
	<form action="servlet/LoginServlet" method="post">
		验证码：<input type="text" name="checkcode" /> 
		<img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/servlet/ImageServlet" /> 
		<a href="javascript:reloadCode();">看不清楚</a> 
		<input type="submit" value="submit" />
	</form>
</body>
</html>
