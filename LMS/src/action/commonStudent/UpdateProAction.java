package action.commonStudent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import board.DAO.LMSDBBean;
import board.DTO.Mvc_BoardDataBean;

public class UpdateProAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");//로그인 정보 가져오기.
*/		request.setCharacterEncoding("UTF-8");

		String pageNum = request.getParameter("pageNum");

		Mvc_BoardDataBean article = new Mvc_BoardDataBean();		
		HttpSession session = request.getSession(false);
		String id = (String)session.getAttribute("member");	
		
		article.setWriter(request.getParameter("writer"));
		
		article.setNum(Integer.parseInt(request.getParameter("num")));
		//article.setWriter(request.getParameter("writer"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setPasswd(request.getParameter("passwd"));

		LMSDBBean dbPro = LMSDBBean.getInstance();
		int check = dbPro.updateArticle(article);

		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));

		return "/LearningManagementSystem/student/commonStudent/MVC/updatePro.jsp";
	}
}