package miniNews.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ��һ��Java�࣬�����ڷ������ˣ�����ͻ�������������Ӧ
 * @author Administrator
 *
 */
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		response.setContentType("text/html;charset=utf-8");		//��ֹ������������       д�ڴ�����֮ǰ
		//��ӡ�����
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Servlet</title></head><body><h1>Hello,Servlet!��һ��Servlet��</h1></body></html>");
		out.close();
		
	}

}
