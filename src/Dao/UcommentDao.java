package Dao;

import java.util.List;

import bean.Ucomment;

/**
 * �������ݿ�ز�
 * 
 * @author ��ΰ 
 * ʱ�䣺2017/7/17
 */
public interface UcommentDao {
	// 1.������������id�����û����۵Ľӿ�
	public List<Ucomment> findUcommentByNid(String cnid);
	
	// 2.������������idɾ���û����۵Ľӿ�
	public boolean deleteUcommentByNid(String cid);

}