package Dao;

import java.util.List;
import bean.News;

/**
 * 新闻Dao层接口
 * 
 * @author 胡伟 时间：2017/7/18
 */
public interface NewsDao {
	// 1.创建查找所有新闻的接口
	public List<News> findAllNews(int start, int num);

	// 2.创建添加新闻的接口
	public boolean addNews(News news);

	// 3.创建根据nid删除新闻的接口
	public boolean delNewsById(int nid);

	// 4.创建根据tid删除新闻的接口
	public boolean delNewsBytId(int ntid);

	// 5.创建根据id查找新闻的接口
	public News findNewsById(int nid);

	// 6.创建修改新闻信息的接口
	public boolean updateNews(News news);

	// 7.创建查询新闻总条数的接口
	public int findNewsCount();
	
	//8.查找新闻在首页显示使用
	public List<News> findNewslist();

}
