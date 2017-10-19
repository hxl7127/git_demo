<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		//String name = request.getParameter("name");
		String[] hs = request.getParameterValues("hobbies");
	%>

	用户名:${param.name }	<br /> 
	爱好:
	<%
		if (hs != null) {
			for (int i = 0; i < hs.length; i++) {
				//out.print(hs[i]+"、");
				request.setAttribute("i", i);
	%>
	${paramValues.hobbies[i] }、
	<%
		}
		}
	%>

	<%-- ${paramValues.hobbies[0] }、${paramValues.hobbies[1] }、${paramValues.hobbies[2] }、${paramValues.hobbies[3] } --%>
</body>
</html>