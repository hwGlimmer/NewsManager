package Dao;

import bean.User;
/**
 * �û���ϢDao��ӿ�
 *
 * @author ��ΰ
 * ʱ�䣺2017/7/15
 */

public interface UserDao {
	// 1.��������û���½��Ϣ����Ľӿ�
	public boolean checkUser(User user);
	
}
