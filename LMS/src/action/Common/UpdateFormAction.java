package action.Common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import board.DTO.Mvc_BoardDataBean;
import board.DAO.LMSDBBean;

public class UpdateFormAction implements CommandAction {// 글수정 폼

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");// 로그인 정보 가져오기.
		
		request.setAttribute("id_size",id.length());

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		LMSDBBean dbPro = LMSDBBean.getInstance();
		Mvc_BoardDataBean article = dbPro.updateGetArticle(num);

		// 해당 뷰에서 사용할 속성
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "/LearningManagementSystem/common/MVC/updateForm.jsp";// 해당뷰
	}
}
