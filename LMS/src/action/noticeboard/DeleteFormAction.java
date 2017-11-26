package action.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class DeleteFormAction implements CommandAction {// 湲��궘�젣 �뤌

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		// �빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));

		return "/LearningManagementSystem/admin/noticeboard/deleteForm.jsp";// �빐�떦酉�
	}
}