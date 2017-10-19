<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List names = new ArrayList();
		names.add(0, "LiYang");
		names.add(1, "WangHua");
		request.setAttribute("names", names);
	%>

	<c:forEach items="${names }" var="name">
		${name }、
	</c:forEach>

</body>
</html>