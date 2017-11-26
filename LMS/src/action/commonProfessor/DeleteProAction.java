package action.commonProfessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.DAO.LMSDBBean;

public class DeleteProAction implements CommandAction {// 글삭제

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");

		LMSDBBean dbPro = LMSDBBean.getInstance();
		int check = dbPro.deleteArticle(num, passwd);

		// 해당 뷰에서 사용할 속성
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));

		return "/LearningManagementSystem/common/MVC/deletePro.jsp";// 해당뷰
	}
}