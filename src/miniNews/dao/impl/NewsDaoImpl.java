package miniNews.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import miniNews.dao.BaseDao;
import miniNews.dao.NewsDao;
import miniNews.entity.News;

public class NewsDaoImpl implements NewsDao {

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<News> list = new ArrayList<News>();

		try {
			conn = BaseDao.getConnection();
			pst = conn.prepareStatement("select * from news order by nid desc");
			rs = pst.executeQuery();
			while (rs.next()) {
				News newsObj = new News();
				newsObj.setNid(rs.getInt(1));
				newsObj.setNtitle(rs.getString(3));
				newsObj.setNcreateDate(rs.getDate(5));
				list.add(newsObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pst, rs);
		}

		return list;
	}

	@Override
	public int saveNews(News news) {
		// TODO Auto-generated method stub
		return BaseDao.exeuteUpdate("insert into news(ntitle,ncreatedate) values(?,?)",
				new Object[] { news.getNtitle(), news.getNcreateDate() });
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return BaseDao.exeuteUpdate("update news set ntitle=?,ncreatedate=? where nid=?",
				new Object[] { news.getNtitle(), news.getNcreateDate(), news.getNid() });
	}

	@Override
	public int delNews(Integer id) {
		// TODO Auto-generated method stub
		return BaseDao.exeuteUpdate("delete from news where nid=?", new Object[] { id });
	}

	@Override
	public News getNewsById(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		News newsObj = null;

		try {
			conn = BaseDao.getConnection();
			pst = conn.prepareStatement("select * from news where nid=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				newsObj = new News();
				newsObj.setNid(rs.getInt(1));
				newsObj.setNtitle(rs.getString(3));
				newsObj.setNcreateDate(rs.getDate(5));
				newsObj.setNcontent(rs.getString(7));
				newsObj.setNauthor(rs.getString(4));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pst, rs);
		}

		return newsObj;
	}

	@Override
	public List<News> getNewsByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<News> list = new ArrayList<News>();

		try {
			conn = BaseDao.getConnection();
			pst = conn.prepareStatement("select * from news order by ncreatedate desc limit ?,?");// 查找的起始位置(0),记录个数
			pst.setInt(1, (pageIndex - 1) * pageSize);
			pst.setInt(2, pageSize);
			rs = pst.executeQuery();
			while (rs.next()) {
				News newsObj = new News();
				newsObj.setNid(rs.getInt(1));
				newsObj.setNtitle(rs.getString(3));
				newsObj.setNcreateDate(rs.getDate(5));
				list.add(newsObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pst, rs);
		}

		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		int count = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = BaseDao.getConnection();
			pst = conn.prepareStatement("select count(1) from news"); // count(1)值可以是任意的数字，不写具体哪一列，可以提高执行效率
			rs = pst.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pst, rs);
		}

		return count;
	}

}
