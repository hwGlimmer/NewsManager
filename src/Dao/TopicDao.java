package Dao;

import java.util.List;
import bean.Topic;
/**
 * 主题Dao层接口
 *
 * @author 胡伟
 * 时间：2017/7/17
 */
public interface TopicDao {
	// 1.创建查找所有主题的接口
	public List<Topic> findAllTopic1();
	
	// 2.创建添加主题的接口
	public List<Topic> findAllTopic(int start, int num);
	
	// 3.创建添加主题的接口
	public boolean addTopic(String tname);

	// 4.创建根据tid删除主题的接口
	public boolean delTopic(String tid);
	
	// 5.查询新闻主题信息总条数的接口
	public int findTopicCount();
	
	// 6.修改主题的接口
	public boolean modifyTopic(String id,String name);
	
}
