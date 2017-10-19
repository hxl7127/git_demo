<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,miniNews.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑新闻</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<form action="NewsServlet" method="post">
		<table align="center" cellpadding="0" cellspacing="0" border="1px">
			<caption><%=session.getAttribute("objNews") == null ? "添加新闻" : "修改新闻"%></caption>
			<input type="hidden" name="opr"
				value='<%=session.getAttribute("objNews") == null ? "add"
					: "update"%>' />
			<!-- 隐藏域 -->
			<input type="hidden" name="nid"
				value='<%=session.getAttribute("objNews") == null ? ""
					: ((News) session.getAttribute("objNews")).getNid()%>' />
			<!-- 隐藏域 -->
			<tr>
				<td>新闻标题：</td>
				<td><input name="title"
					value='<%=session.getAttribute("objNews") == null ? ""
					: ((News) session.getAttribute("objNews")).getNtitle()%>' /></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><input name="createdate"
					value='<%=session.getAttribute("objNews") == null ? ""
					: ((News) session.getAttribute("objNews")).getNcreateDate()%>'
					onclick="WdatePicker()"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
				<td><input type="reset" value="取消" /></td>
			</tr>
		</table>

	</form>
	<%
		session.removeAttribute("objNews");
	%>
</body>
</html>