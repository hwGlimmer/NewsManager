package Dao;

import java.util.List;
import bean.News;

/**
 * ����Dao��ӿ�
 * 
 * @author ��ΰ ʱ�䣺2017/7/18
 */
public interface NewsDao {
	// 1.���������������ŵĽӿ�
	public List<News> findAllNews(int start, int num);

	// 2.����������ŵĽӿ�
	public boolean addNews(News news);

	// 3.��������nidɾ�����ŵĽӿ�
	public boolean delNewsById(int nid);

	// 4.��������tidɾ�����ŵĽӿ�
	public boolean delNewsBytId(int ntid);

	// 5.��������id�������ŵĽӿ�
	public News findNewsById(int nid);

	// 6.�����޸�������Ϣ�Ľӿ�
	public boolean updateNews(News news);

	// 7.������ѯ�����������Ľӿ�
	public int findNewsCount();
	
	//8.������������ҳ��ʾʹ��
	public List<News> findNewslist();

}
