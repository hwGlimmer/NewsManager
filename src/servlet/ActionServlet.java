package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.NewsDao;
import Dao.TopicDao;
import Dao.UcommentDao;
import Dao.UserDao;
import Dao.Impl.NewsDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Dao.Impl.UcommentDaoImpl;
import Dao.Impl.UserDaoImpl;
import bean.News;
import bean.Topic;
import bean.Ucomment;
import bean.User;
import net.sf.json.JSONArray;
/**
 * ����ҵ����
 * @author ��ΰ
 * ʱ�䣺2017/7/15
 */

public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/*��ȡ���ݿ����ӳ���Դ
	 * @Resource(name="jdbc/databaseWeb")
	javax.sql.DataSource ds;*/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		PrintWriter pw = response.getWriter();
		//��ȡ����·��
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		
		if(action.equals("login")){//��½��֤
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			
			User user = new User(name,pwd);
			UserDao ud = new UserDaoImpl();
			boolean flag = ud.checkUser(user);
		/* servlet ֱ�ӻ�ȡ���ӳ���Դ����jdbc����
		 * try {
				Connection conn = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			HttpSession session = request.getSession();
			if(flag){
				session.setAttribute("uname", name);
			}
			pw.print(flag);
		
		}else if(action.equals("admin")){//���ŷ�ҳ�߼�����
			int page = 1;
			if(request.getParameter("page")!=null&&!request.getParameter("page").equals("")){
				page = Integer.parseInt(request.getParameter("page"));
			}
			NewsDao nd = new NewsDaoImpl();
			int totalPage = 0;
			int total = nd.findNewsCount();
			int num = 5;
			if (total % num != 0) {
				totalPage = total / num + 1;

			} else {
				totalPage = total / num;
			}
			if (page > 1 && page <= totalPage) {
				request.setAttribute("page", page);
			} else if (page <= 1) {
				request.setAttribute("page", 1);
			} else {
				request.setAttribute("page", totalPage);
			}
			request.setAttribute("totalPage", totalPage);
			request.getRequestDispatcher("newspages/admin.jsp").forward(request, response);
		
		}else if(action.equals("quoto")){//��ҳ��ʾ���е�����
			int page = Integer.parseInt(request.getParameter("page"));
			int start = (page - 1) * 5;
			int num = 5;
			NewsDao nd = new NewsDaoImpl();
			List<News> list = nd.findAllNews(start, num);
			JSONArray ja = JSONArray.fromObject(list);
			String str = ja.toString();
			pw.print(str);
		
		}else if(action.equals("findNewslist")){//�����ͻ����,��ʾ���Ų���ҳ��
			NewsDao nd = new NewsDaoImpl();
			List<News> list = nd.findNewslist();
			JSONArray ja = JSONArray.fromObject(list);
			String str = ja.toString();
			pw.print(str);
		}
		
		else if(action.equals("topic")){//�����ҳ�߼�����
			int page = 1;
			if(request.getParameter("page")!=null&&!request.getParameter("page").equals("")){
				page = Integer.parseInt(request.getParameter("page"));
			}
			TopicDao nd = new TopicDaoImpl();
			int totalPage = 0;
			int total = nd.findTopicCount();
			int num = 5;
			if (total % num != 0) {
				totalPage = total / num + 1;

			} else {
				totalPage = total / num;
			}
			if (page > 1 && page <= totalPage) {
				request.setAttribute("page", page);
			} else if (page <= 1) {
				request.setAttribute("page", 1);
			} else {
				request.setAttribute("page", totalPage);
			}
			request.setAttribute("totalPage", totalPage);
			request.getRequestDispatcher("newspages/topic_list.jsp").forward(request, response);
		
		}
		
		else if(action.equals("findtopic1")){//�����ͻ���⣬ѡ����ȡ����
			TopicDao td = new TopicDaoImpl();
			List<Topic> list = td.findAllTopic1();
			JSONArray ja = JSONArray.fromObject(list);
			String str = ja.toString();
			pw.print(str);
		}
		
		else if(action.equals("findtopic")){//��ҳ��ʾ���ҵ�����
			int page = Integer.parseInt(request.getParameter("page"));
			int start = (page - 1) * 5;
			int num = 5;
			TopicDao td = new TopicDaoImpl();
			List<Topic> list = td.findAllTopic(start,num);
			JSONArray ja = JSONArray.fromObject(list);
			String str = ja.toString();
			pw.print(str);
		}
		
		else if(action.equals("addnew")){//�������
			String ntid = request.getParameter("ntid");
			String ntitle = request.getParameter("ntitle");
			String nauthor = request.getParameter("nauthor");
			String ncontent = request.getParameter("ncontent");
			String nsummary = request.getParameter("nsummary");
			News ns =  new News(0,ntid,ntitle,nauthor,"", "",ncontent,"", nsummary);
			NewsDao nd = new NewsDaoImpl();
			boolean flag = nd.addNews(ns);
			if(flag){
				response.sendRedirect("admin.do");
			}else{
				pw.print("���ű��ⲻ���ظ�");
			}
		}else if(action.equals("delete")){//����idɾ������
			int nid =Integer.valueOf(request.getParameter("nid"));
			NewsDao nd = new NewsDaoImpl();
			boolean flag = nd.delNewsById(nid);
			if(flag){
				response.sendRedirect("admin.do?page=1");
			}
		}else if(action.equals("upmanage")){//����id��������
			int nid =Integer.valueOf(request.getParameter("nid"));
			NewsDao nd = new NewsDaoImpl();
			News news = nd.findNewsById(nid);
			request.setAttribute("news1",news);
			pw.print(news);
			if(news!=null){
				request.getRequestDispatcher("newspages/news_modify.jsp").forward(request,response);
			}
		}else if(action.equals("update")){//�޸�������Ϣ
			int nid =Integer.parseInt(request.getParameter("nid"));
			String ntid = request.getParameter("ntid");
			String ntitle = request.getParameter("ntitle");
			String nauthor = request.getParameter("nauthor");
			String ncontent = request.getParameter("ncontent");
			String nsummary = request.getParameter("nsummary");
			
			News ns = new News(nid, ntid, ntitle, nauthor, "", "", ncontent,"", nsummary);			
			NewsDao nd = new NewsDaoImpl();
			boolean flag = nd.updateNews(ns);
			if(flag){
				response.sendRedirect("admin.do");
			}else{
				pw.print("���ű��ⲻ���ظ�");
			}
		}else if(action.equals("topicadd")){//�����������
			String tname = request.getParameter("tname");
			TopicDao td = new TopicDaoImpl();
			boolean flag = td.addTopic(tname);
			if(flag){
				response.sendRedirect("topic.do");
			}else{
				pw.print("�������ⲻ���ظ�");
			}
		}else if(action.equals("topicmodify")){//�޸���������
			String tname = request.getParameter("tname");
			String tid = request.getParameter("tid");
			TopicDao td = new TopicDaoImpl();
			boolean flag = td.modifyTopic(tid, tname);
			if (flag) {
				response.sendRedirect("topic.do?page=1");
			}else{
				pw.print("�������ⲻ���ظ�");
			}
		}else if(action.equals("topic_delete")){//ɾ����������
			String tid = request.getParameter("tid");
			TopicDao td = new TopicDaoImpl();
			boolean flag = td.delTopic(tid);
			if (flag) {

				response.sendRedirect("topic.do?page=1");
			}
		}
		
		else if(action.equals("findcomment")){//������������
			String cnid = request.getParameter("cnid");
			UcommentDao cd = new UcommentDaoImpl();
			List<Ucomment> list = cd.findUcommentByNid(cnid);
			JSONArray ja = JSONArray.fromObject(list);
			String str = ja.toString();
			pw.print(str);
		}else if(action.equals("commentdel")){//ɾ����������
			String cid = request.getParameter("cid");
			String cnid = request.getParameter("nid");
			UcommentDao cd = new UcommentDaoImpl();
			
			boolean flag = cd.deleteUcommentByNid(cid);
			if(flag){
				response.sendRedirect("upmanger.do?nid="+cnid);
				//request.getRequestDispatcher("/newspages/news_modify.jsp").forward(request,response);
			}
		}

	}
}
