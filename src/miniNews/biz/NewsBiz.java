package miniNews.biz;

import java.util.List;

import miniNews.entity.News;
import miniNews.entity.Page;

public interface NewsBiz {
	public List<News> showAllNews();

	public int delNews(Integer id);

	public int addNews(News news);

	public News showNewsById(Integer id);

	public int updateNews(News news);
	
	public Page<News> showNewsByPage(int pageIndex,int pageSize);
}
