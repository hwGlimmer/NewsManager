package Dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.NewsDao;
import Dao.TopicDao;
import bean.Topic;
import util.JDBC;
/**
 * 新闻主题dao层接口实现
 * @author 胡伟
 * 时间：2017/7/15
 */
public class TopicDaoImpl implements TopicDao {
	//1.分页查看数据库里的主题
	@Override
	public List<Topic> findAllTopic(int start,int num) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		List<Topic> list = new ArrayList<Topic>();
		jdbc.openConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select *from topic limit ?,? ";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setInt(1, start);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while(rs.next()){
				Topic t = new Topic();
				t.setTid(rs.getInt("tid"));
				t.setTname(rs.getString("tname"));
				list.add(t);
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
		
		return list;
	}
	
	//2.查看数据库里的主题
	@Override
	public List<Topic> findAllTopic1() {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		List<Topic> list = new ArrayList<Topic>();
		jdbc.openConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select *from TOPIC";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Topic t = new Topic();
				t.setTid(rs.getInt("tid"));
				t.setTname(rs.getString("tname"));
				list.add(t);
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
		
		return list;
	}
	
	//3.添加新闻主题
	@Override
	public boolean addTopic(String tname) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		jdbc.openConn();
		PreparedStatement pstm = null;
		int rs = 0;
		boolean flag = false;
		String sql = "insert into topic(tname) values(?)";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, tname);
			rs = pstm.executeUpdate();
			if(rs>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(pstm!=null){
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
	
	//4.修改新闻主题
	public boolean modifyTopic(String id, String name) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		jdbc.openConn();
		PreparedStatement pstm = null;
		int rs = 0;
		boolean flag = false;
		String sql = "update topic set tname=? where tid=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, id);
			rs = pstm.executeUpdate();
			if(rs>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(pstm!=null){
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
	
	//5.根据tid删除主题
	public boolean delTopic(String tid) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		jdbc.openConn();
		PreparedStatement pstm = null;
		int rs = 0;
		boolean flag = false;
		String sql = "delete from topic where tid=?";
		
		try {
			NewsDao nd = new NewsDaoImpl();
			nd.delNewsBytId(Integer.parseInt(tid));
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, tid);
			rs = pstm.executeUpdate();
			if(rs>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(pstm!=null){
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

	//6.查询新闻主题信息总条数
	@Override
	public int findTopicCount() {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		jdbc.openConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select count(*) from TOPIC";
		int i = 0;
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				i=rs.getInt(1);
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
		return i;
	}

	
}
