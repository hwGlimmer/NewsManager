package bean;
/**
 * �û�ʵ����
 * @author ��ΰ
 * ʱ�䣺2017/7/15
 */
public class User {
	private int id;//�û�id
	private String name;//�û���
	private String pwd;//�û�����
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
