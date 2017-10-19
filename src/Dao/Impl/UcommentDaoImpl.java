package Dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.UcommentDao;
import bean.Ucomment;
import util.JDBC;
/**
 * 用户评论dao层接口实现
 * @author 胡伟
 * 时间：2017/7/15
 */
public class UcommentDaoImpl implements UcommentDao {
	// 1.根据新闻id查找用户评论
	@Override
	public List<Ucomment> findUcommentByNid(String cnid) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		List<Ucomment> list = new ArrayList<Ucomment>();
		jdbc.openConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from Ucomment where cnid=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, cnid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Ucomment n = new Ucomment(
				rs.getInt(1),
				rs.getInt(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5),
				rs.getString(6)
						);
				list.add(n);
				}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			jdbc.closeConn();
		}
		return list;
	}
	
	// 2.根据新闻id删除用户评论
	@Override
	public boolean deleteUcommentByNid(String cid) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		jdbc.openConn();
		PreparedStatement pstm = null;
		int rs = 0;
		boolean flag = false;
		String sql = "delete from Ucomment where cid=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, cid);
			rs = pstm.executeUpdate();
			if(rs>0){
				flag = true;
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstm != null) {
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
