package action.noticeboard;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import noticeboard.DAO.NoticeboardDao;
import noticeboard.DTO.NoticeboardDataBean;

public class UpdateProAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		String pageNum = request.getParameter("pageNum");

		NoticeboardDataBean article = new NoticeboardDataBean();
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));

		NoticeboardDao dbPro = NoticeboardDao.getInstance();
		int check = dbPro.updateArticle(article);

		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));

		return "/LearningManagementSystem/admin/noticeboard/updatePro.jsp";
	}
}