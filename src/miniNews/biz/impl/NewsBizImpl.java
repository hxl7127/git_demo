package miniNews.biz.impl;

import java.util.List;

import miniNews.biz.NewsBiz;
import miniNews.dao.NewsDao;
import miniNews.dao.impl.NewsDaoImpl;
import miniNews.entity.News;
import miniNews.entity.Page;

public class NewsBizImpl implements NewsBiz {

	NewsDao dao = new NewsDaoImpl();

	@Override
	public List<News> showAllNews() {
		// TODO Auto-generated method stub
		return dao.getAllNews();
	}

	@Override
	public int delNews(Integer id) {
		// TODO Auto-generated method stub
		return dao.delNews(id);
	}

	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return dao.saveNews(news);
	}

	@Override
	public News showNewsById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getNewsById(id);
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return dao.updateNews(news);
	}

	@Override
	public Page<News> showNewsByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		Page<News> page = new Page<News>();

		List<News> list = dao.getNewsByPage(pageIndex, pageSize);

		// Page������������ֵ
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setCount(dao.getCount());
		page.setPageList(list);

		return page;
	}
	
	public static void main(String[] args) {
		NewsBizImpl impl=new NewsBizImpl();
		Page<News> page=impl.showNewsByPage(1, 5);
		
		System.out.println("������������"+page.getCount());
		System.out.println("ÿҳ��������"+page.getPageSize());
		System.out.println("��ҳ��"+page.getPageTotal());
		System.out.println("��ǰҳ��"+page.getPageIndex()+"ҳ");
		List<News> list=page.getPageList();
		for(News n:list){
			System.out.println(n.getNid()+"\t"+n.getNtitle());
		}
		
	}

}
