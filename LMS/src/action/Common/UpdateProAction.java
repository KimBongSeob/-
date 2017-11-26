package action.Common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.DTO.Mvc_BoardDataBean;
import board.DAO.LMSDBBean;

public class UpdateProAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		String pageNum = request.getParameter("pageNum");

		Mvc_BoardDataBean article = new Mvc_BoardDataBean();
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setPasswd(request.getParameter("passwd"));

		LMSDBBean dbPro = LMSDBBean.getInstance();
		int check = dbPro.updateArticle(article);

		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));

		return "/LearningManagementSystem/common/MVC/updatePro.jsp";
	}
}