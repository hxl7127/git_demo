package miniNews.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 是一个Java类，运行在服务器端，处理客户端请求并作出响应
 * @author Administrator
 *
 */
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		response.setContentType("text/html;charset=utf-8");		//防止出现中文乱码       写在创建流之前
		//打印输出流
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Servlet</title></head><body><h1>Hello,Servlet!第一个Servlet。</h1></body></html>");
		out.close();
		
	}

}
