<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="miniNews.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setAttribute("uname", "张沛");
	pageContext.setAttribute("uname", "董通");
	
	News n = new News();
	n.setNtitle("双十一");
	request.setAttribute("news", n);
	request.setAttribute("ntitle", "ntitle");
%>

<h1>姓名:${requestScope.uname }</h1>
<h1>姓名:${uname }</h1>	<!-- 显示小范围的内容 -->
<h1>新闻标题:${requestScope.news.ntitle}</h1>
<h1>新闻标题:${requestScope.news["ntitle"]}</h1>	<!-- 属性里面有特殊符号时，可以用中括号，不加双引号在el里会当成变量,继续从范围里面找-->
</body>
</html>