package Dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JDBC;
import bean.News;
import Dao.NewsDao;
/**
 * ����dao��ӿ�ʵ��
 * @author ��ΰ
 * ʱ�䣺2017/7/15
 */
public class NewsDaoImpl implements NewsDao {
	// 1.��ҳ��������
	public List<News> findAllNews(int start, int num) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		List<News> list = new ArrayList<News>();
		jdbc.openConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from news limit ?,?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setInt(1, start);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				News n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNsummary(rs.getString("nsummary"));
				n.setNcreatedate(rs.getString("ncreatedate"));
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

	// 2.���������Ϣ
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		boolean flag = false;
		jdbc.openConn();
		PreparedStatement pstm = null;
		// ��ȡ��ǰʱ��
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		String sql = "insert into NEWS(ntid,ntitle,nauthor,ncreatedate,ncontent,nsummary) values(?,?,?,?,?,?)";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, news.getNtid());
			pstm.setString(2, news.getNtitle());
			pstm.setString(3, news.getNauthor());
			pstm.setObject(4, ts);
			pstm.setString(5, news.getNcontent());
			pstm.setString(6, news.getNsummary());
			int rs = pstm.executeUpdate();
			if (rs > 0) {
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
	
	//3.����idɾ��������Ϣ
	public boolean delNewsById(int nid) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		boolean flag = false;
		jdbc.openConn();
		PreparedStatement pstm = null;
		String sql = "delete from news where nid=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			
			pstm.setInt(1, nid);
			
			int rs = pstm.executeUpdate();
			if (rs > 0) {
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
	
	//4.����id����������Ϣ
	public News findNewsById(int nid) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		News n = new News();
		jdbc.openConn();
		PreparedStatement pstm = null;
		String sql = "select* from news where nid=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			
			pstm.setInt(1, nid);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				n.setNid(rs.getInt("nid"));
				n.setNtid(rs.getInt("ntid") + "");
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNsummary(rs.getString("nsummary"));
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
		return n;
	}

	//5.�޸�������Ϣ
	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		boolean flag = false;
		jdbc.openConn();
		PreparedStatement pstm = null;
		// ��ȡ��ǰʱ��
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		String sql = "update NEWS set ntid=?,ntitle=?,nauthor=?,nmodifydate=?,ncontent=?,nsummary=? where nid=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			pstm.setString(1, news.getNtid());
			pstm.setString(2, news.getNtitle());
			pstm.setString(3, news.getNauthor());
			pstm.setObject(4, ts);
			pstm.setString(5, news.getNcontent());
			pstm.setString(6, news.getNsummary());
			
			System.out.println("nid--"+news.getNid());
			System.out.println("nsummary--"+news.getNsummary());
			
			pstm.setInt(7, news.getNid());
			int rs = pstm.executeUpdate();
			if (rs > 0) {
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
	
	//6.����tidɾ��������Ϣ
	public boolean delNewsBytId(int ntid) {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		boolean flag = false;
		jdbc.openConn();
		PreparedStatement pstm = null;
		String sql = "delete from news where ntid=?";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			
			pstm.setInt(1, ntid);
			
			int rs = pstm.executeUpdate();
			if (rs > 0) {
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
	
	//7.��ѯ����������
	@Override
	public int findNewsCount() {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		jdbc.openConn();
		PreparedStatement pstm = null;
		String sql = "select count(*) from news";
		int i = 0;
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				i = rs.getInt(1);

			}
		} catch (Exception e) {
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
		return i;
	}
	
	//8.��ҳ��������
	public List<News> findNewslist() {
		JDBC jdbc = new JDBC();
		List<News> list = new ArrayList<News>();
		jdbc.openConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from news";
		try {
			pstm = jdbc.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				News n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNsummary(rs.getString("nsummary"));
				n.setNcreatedate(rs.getString("ncreatedate"));
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
}
