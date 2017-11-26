package action.commonStudent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import board.DAO.LMSDBBean;
import board.DTO.Mvc_BoardDataBean;

public class ContentAction implements CommandAction {// 글내용 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");//로그인 정보 가져오기.
		
		int num = Integer.parseInt(request.getParameter("num"));// 해당 글번호
		String pageNum = request.getParameter("pageNum");// 해당 페이지 번호

		LMSDBBean dbPro = LMSDBBean.getInstance();// DB처리
		Mvc_BoardDataBean article = dbPro.getArticle(num);// 해당 글번호에 대한 해당 레코드

		// 해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "/LearningManagementSystem/student/commonStudent/MVC/content.jsp";// 해당 뷰
	}
}
