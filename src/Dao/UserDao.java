package Dao;

import bean.User;
/**
 * 用户信息Dao层接口
 *
 * @author 胡伟
 * 时间：2017/7/15
 */

public interface UserDao {
	// 1.创建检查用户登陆信息检验的接口
	public boolean checkUser(User user);
	
}
