package bean;
/**
 * ��������ʵ����
 * @author ��ΰ
 * ʱ�䣺2017/7/16
 */
public class Topic {
	private int tid;//����id
	private String tname;//��������
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
