package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 * 数据库连接工具类
 * @author 胡伟
 * 时间：2017/7/15
 */
public class JDBC {
	public  Connection conn = null;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/newsInfo?useUnicode=true&amp;characterEncoding=utf8";
	private static String user = "root";
	private static String password = "root";
	// 1.封装一个数据库连接方法
	public void openConn() {
		try {
			// 1.加载驱动
			//Class.forName(driver);
			// 2.创建连接
			//conn = DriverManager.getConnection(url, user, password);
			
			//初始化查找命名空间(数据库连接池的使用)
            Context context = new InitialContext();  
            //参数java:/comp/env为固定路径   
            Context context2 = (Context)context.lookup("java:/comp/env"); 
            //参数jdbc/databaseWeb为数据源和JNDI绑定的名字
            DataSource ds = (DataSource)context2.lookup("jdbc/databaseWeb"); 
            conn = ds.getConnection();     

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2.封装一个关闭连接方法
	public void closeConn() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
