package miniNews.dao;

import java.util.List;

import miniNews.entity.News;

public interface NewsDao {
	// ������������
		public List<News> getAllNews();

		// �������
		public int saveNews(News news);

		// �޸�
		public int updateNews(News news);

		// ɾ��
		public int delNews(Integer id);
		
		//��������ѯ
		public News getNewsById(Integer id);
		
		//��ǰҳ������
		public List<News> getNewsByPage(int pageIndex,int pageSize);
		
		//�ܼ�¼��
		public int getCount();
}
