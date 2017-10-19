package miniNews.dao.impl;

import java.util.List;

import miniNews.dao.NewsDao;
import miniNews.entity.News;

public class NewsDaoImplMyBatis implements NewsDao {

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveNews(News news) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delNews(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public News getNewsById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> getNewsByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
