package bean;
/**
 * 新闻主题实体类
 * @author 胡伟
 * 时间：2017/7/16
 */
public class Topic {
	private int tid;//主题id
	private String tname;//主题名字
	public Topic() {
		super();
	}
	public Topic(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "TOPIC [tid=" + tid + ", tname=" + tname + "]";
	}
}
