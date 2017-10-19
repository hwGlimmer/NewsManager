package Dao;

import java.util.List;
import bean.Topic;
/**
 * ����Dao��ӿ�
 *
 * @author ��ΰ
 * ʱ�䣺2017/7/17
 */
public interface TopicDao {
	// 1.����������������Ľӿ�
	public List<Topic> findAllTopic1();
	
	// 2.�����������Ľӿ�
	public List<Topic> findAllTopic(int start, int num);
	
	// 3.�����������Ľӿ�
	public boolean addTopic(String tname);

	// 4.��������tidɾ������Ľӿ�
	public boolean delTopic(String tid);
	
	// 5.��ѯ����������Ϣ�������Ľӿ�
	public int findTopicCount();
	
	// 6.�޸�����Ľӿ�
	public boolean modifyTopic(String id,String name);
	
}
