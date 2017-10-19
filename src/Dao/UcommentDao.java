package Dao;

import java.util.List;

import bean.Ucomment;

/**
 * 评论数据库控层
 * 
 * @author 胡伟 
 * 时间：2017/7/17
 */
public interface UcommentDao {
	// 1.创建根据新闻id查找用户评论的接口
	public List<Ucomment> findUcommentByNid(String cnid);
	
	// 2.创建根据新闻id删除用户评论的接口
	public boolean deleteUcommentByNid(String cid);

}