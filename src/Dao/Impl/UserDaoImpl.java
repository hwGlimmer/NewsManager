package Dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.UserDao;
import bean.User;
import util.JDBC;
/**
 * 用户信息dao层接口实现
 * @author 胡伟
 * 时间：2017/7/15
 */
public class UserDaoImpl implements UserDao {
	//检查用户登陆信息
	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		jdbc.openConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select * from user where username=? and upassword=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPwd());

			rs = pstm.executeQuery();
			while(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			jdbc.closeConn();
		}
		return flag;
		
	}

}
