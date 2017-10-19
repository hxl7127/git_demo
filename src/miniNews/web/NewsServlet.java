package miniNews.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniNews.biz.NewsBiz;
import miniNews.biz.impl.NewsBizImpl;
import miniNews.entity.News;
import miniNews.entity.Page;
import miniNews.utils.DateUtils;

/**
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//新闻处理页
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");//取值之前设置编码方式，否则无效
		String opr = null;//判断是何种操作

		opr = request.getParameter("opr");

		NewsBiz biz = new NewsBizImpl();

		if ("getAll".equals(opr)) {
			List<News> list = biz.showAllNews();
			session.setAttribute("news", list);
			response.sendRedirect("index.jsp");
		} else if ("del".equals(opr)) {
			String id = request.getParameter("id");//要删除的新闻编号 
			int i = biz.delNews(Integer.valueOf(id));
			if (i > 0) {
				out.print("<script>alert('删除成功！');location.href='index.jsp'</script>");

			}

		} else if ("add".equals(opr)) {

			String title = request.getParameter("title");
			String date = request.getParameter("createdate");
			//构造News对象
			News news = new News();
			news.setNtitle(title);
			news.setNcreateDate(DateUtils.string2Date(date));
			//执行保存业务
			int i = biz.addNews(news);
			if (i > 0) {
				out.print("<script>alert('添加成功！');location.href='index.jsp'</script>");

			}
		} else if ("toUpdate".equals(opr)) {
			String id = request.getParameter("id");
			News news = biz.showNewsById(Integer.valueOf(id));
			session.setAttribute("objNews", news);
			response.sendRedirect("editNews.jsp");
		} else if ("update".equals(opr)) {
			String nid = request.getParameter("nid");
			String title = request.getParameter("title");
			String date = request.getParameter("createdate");
			//构造News对象
			News news = new News();
			news.setNid(Integer.valueOf(nid));
			news.setNtitle(title);
			news.setNcreateDate(DateUtils.string2Date(date));

			if (biz.updateNews(news) > 0) {
				out.print("<script>alert('修改成功！');location.href='index.jsp'</script>");
			}
		}else if("page".equals(opr)){
			int pageIndex=1,pageSize=5;
			String index=request.getParameter("i");
			if(index!=null){
				pageIndex=Integer.valueOf(index);
			}
			
			NewsBizImpl impl=new NewsBizImpl();
			Page<News> pageObj=impl.showNewsByPage(pageIndex, pageSize);
			session.setAttribute("pageObj", pageObj);
			response.sendRedirect("index.jsp");
		}
	}

}
