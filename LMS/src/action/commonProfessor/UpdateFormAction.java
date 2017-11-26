package action.commonProfessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.DAO.LMSDBBean;
import board.DTO.Mvc_BoardDataBean;

public class UpdateFormAction implements CommandAction {// 글수정 폼

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		LMSDBBean dbPro = LMSDBBean.getInstance();
		Mvc_BoardDataBean article = dbPro.updateGetArticle(num);

		// 해당 뷰에서 사용할 속성
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "/LearningManagementSystem/professor/commonProfessor/MVC/updateForm.jsp";// 해당뷰
	}
}
