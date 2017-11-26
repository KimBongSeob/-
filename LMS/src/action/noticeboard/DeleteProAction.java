package action.noticeboard;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import noticeboard.DAO.NoticeboardDao;



public class DeleteProAction implements CommandAction {// 湲��궘�젣

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		NoticeboardDao dbPro = NoticeboardDao.getInstance();
		int check = dbPro.deleteArticle(num);

		// �빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));

		return "/LearningManagementSystem/admin/noticeboard/deletePro.jsp";// �빐�떦酉�
	}
}