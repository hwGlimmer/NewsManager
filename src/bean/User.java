package bean;
/**
 * 用户实体类
 * @author 胡伟
 * 时间：2017/7/15
 */
public class User {
	private int id;//用户id
	private String name;//用户名
	private String pwd;//用户密码
	public User() {
		super();
	}
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
