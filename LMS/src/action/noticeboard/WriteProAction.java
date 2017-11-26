package action.noticeboard;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import noticeboard.DAO.NoticeboardDao;
import noticeboard.DTO.NoticeboardDataBean;

public class WriteProAction implements CommandAction {// �엯�젰�맂 湲� 泥섎━

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");// �븳湲� �씤肄붾뵫

		

		NoticeboardDataBean article = new NoticeboardDataBean();// �뜲�씠�꽣泥섎━ 鍮�
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setSubject(request.getParameter("subject"));
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		article.setContent(request.getParameter("content"));

		NoticeboardDao dbPro = NoticeboardDao.getInstance();// DB泥섎━
		dbPro.insertArticle(article);

		return "/LearningManagementSystem/admin/noticeboard/writePro.jsp";
	}
}