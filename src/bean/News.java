package bean;
/**
 * ����ʵ����
 * @author ��ΰ
 * ʱ�䣺2017/7/15
 */
public class News {
	private int nid;//����id
	private String ntid;//��������id
	private String ntitle;//���ű���
	private String nauthor;//���ŵ�����
	private String ncreatedate;//���Ŵ���ʱ��
	private String npicpath;//�ϴ�ͼƬ·��
	private String ncontent;//��������
	private String nmodifydate;//�����޸�ʱ��
	private String nsummary;//���Ÿ�Ҫ
	
	public News() {
		super();
	}
	public News(int nid, String ntid, String ntitle, String nauthor,
			String ncreatedate, String npicpath, String ncontent,
			String nmodifydate, String nsummary) {
		super();
		this.nid = nid;
		this.ntid = ntid;
		this.ntitle = ntitle;
		this.nauthor = nauthor;
		this.ncreatedate = ncreatedate;
		this.npicpath = npicpath;
		this.ncontent = ncontent;
		this.nmodifydate = nmodifydate;
		this.nsummary = nsummary;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNtid() {
		return ntid;
	}
	public void setNtid(String ntid) {
		this.ntid = ntid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public String getNcreatedate() {
		return ncreatedate;
	}
	public void setNcreatedate(String ncreatedate) {
		this.ncreatedate = ncreatedate;
	}
	public String getNpicpath() {
		return npicpath;
	}
	public void setNpicpath(String npicpath) {
		this.npicpath = npicpath;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNmodifydate() {
		return nmodifydate;
	}
	public void setNmodifydate(String nmodifydate) {
		this.nmodifydate = nmodifydate;
	}
	public String getNsummary() {
		return nsummary;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", ntid=" + ntid + ", ntitle=" + ntitle
				+ ", nauthor=" + nauthor + ", ncreatedate=" + ncreatedate
				+ ", npicpath=" + npicpath + ", ncontent=" + ncontent
				+ ", nmodifydate=" + nmodifydate + ", nsummary=" + nsummary
				+ "]";
	}
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}

}
