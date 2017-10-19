package miniNews.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
    /**
     * 连接对象
     */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建Connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=utf-8","root","meng");
			
//			Context initContext = new InitialContext();
//			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/TestDB");
			
//			conn = ds.getConnection();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 关闭资源xxx
	 */
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		
		try {
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
				
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 更新操作
	 */
	public static int exeuteUpdate(String sql,Object[]objs){
		int n=0;
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		
		try {
			conn=BaseDao.getConnection();
			pst=conn.prepareStatement(sql);
			
			if(objs!=null){
				for(int i=0;i<objs.length;i++){
					pst.setObject(i+1, objs[i]);
				}
			}
			
			
			n=pst.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, pst, null);
		}
		return n;
	}

}
