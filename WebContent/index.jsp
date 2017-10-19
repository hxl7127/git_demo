<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,miniNews.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻列表</title>
</head>
<body>

	<%
		Object obj = session.getAttribute("pageObj");//session属性
		session.removeAttribute("pageObj");
		
		Page<News> pageObj = null;
		if (obj == null) {//跳转到处理页
			response.sendRedirect("NewsServlet?opr=page");
			return;

		} else {

			pageObj = (Page<News>) obj;//属性值强转，得到需要的集合

		}
	%>
	<a href="editNews.jsp">添加新闻</a>
	<table align="center" cellpadding="0" cellspacing="0" border="1px">
		<caption>新闻列表</caption>
		<tr>
			<th>编号</th>
			<th>标题</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>

		<%
			for (News n : pageObj.getPageList()) {
		%>
		<tr>
			<td><%=n.getNid()%></td>
			<td><%=n.getNtitle()%></td>
			<td><%=n.getNcreateDate()%></td>
			<td><a href="NewsServlet?opr=toUpdate&id=<%=n.getNid()%>">修改</a>
				&nbsp;&nbsp;<a href="javascript:void(0);"
				onclick="del(<%=n.getNid()%>);">删除</a></td>
		</tr>
		<%
			}
		%>



	</table>
	<div style="margin: 0 auto;width:800px;text-align:center;">
		【<%=pageObj.getPageIndex() %>/<%=pageObj.getPageTotal() %>】
		
		<%
			if(pageObj.getPageIndex()>1){
		%>
				<a href="NewsServlet?opr=page&i=1">首页</a>&nbsp;
				<a href="NewsServlet?opr=page&i=<%=pageObj.getPageIndex()-1 %>">上一页</a>&nbsp;
		<%
			}
		%>
		
		<%
			if(pageObj.getPageIndex()<pageObj.getPageTotal()){
		%>
				<a href="NewsServlet?opr=page&i=<%=pageObj.getPageIndex()+1 %>">下一页</a>&nbsp;
				<a href="NewsServlet?opr=page&i=<%=pageObj.getPageTotal() %>">尾页</a>
		<%
			}
		%>
	</div>

</body>
</html>

<script>
  function del(id){
	  if(confirm("确定要删除吗？")){//选择确定
		 location.href="NewsServlet?id="+id+"&opr=del";
	  }
  }
</script>