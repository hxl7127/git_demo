<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		if(name != null){
			String role = "普通员工";
			if("sa".equals(name)&&"123".equals(pwd)){
				session.setAttribute("user", name);
				role="管理员";
			}else if("zs".equals(name)&&"456".equals(pwd)){
				session.setAttribute("user", name);
				role="总监";
			}else{
				request.setAttribute("errmsg", "用户名或密码错误！");
			}
			request.setAttribute("role", role);
		}
	%>

	<c:set var="isLogin" value="${empty sessionScope.user }"></c:set>

	<c:remove var="user"/>

	<c:if test="${isLogin }">
		<span style="color:red;">${errmsg }</span>
		<c:remove var="errmsg"/>
		<form name="form1" method="post" action="login.jsp">
			<table border="0" align="center">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="pwd"></td>
				</tr>

				<tr>
					<td><input type="submit" value="提交"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</c:if>
	
	<c:if test="${!isLogin }">
		<c:choose>
			<c:when test='${role eq "管理员"}'>管理员页面</c:when>
			<c:when test='${role eq "总监"}'>总监页面</c:when>
			<c:otherwise>普通员工页面</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>

<script>
	function changeCode() {
		document.getElementById("code").src = "image.jsp?id=" + Math.random();
	}
</script>