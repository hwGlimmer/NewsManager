package bean;
/**
 * 用户评论实体类
 * @author 胡伟
 * 时间：2017/7/16
 */
public class Ucomment {
	private int cid;//评论id
	private int cnid;//评论新闻id
	private String ccontent;//用户评论内容
	private String cdate;//用户评论日期
	private String cip;//评论者ip
	private String cauthor;//评论者
	public Ucomment() {
		super();
	}
	public Ucomment(int cid, int cnid, String ccontent, String cdate, String cip, String cauthor) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cip = cip;
		this.cauthor = cauthor;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCnid() {
		return cnid;
	}
	public void setCnid(int cnid) {
		this.cnid = cnid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	@Override
	public String toString() {
		return "Ucomment [cid=" + cid + ", cnid=" + cnid + ", ccontent=" + ccontent + ", cdate=" + cdate + ", cip="
				+ cip + ", cauthor=" + cauthor + "]";
	}
	
}
