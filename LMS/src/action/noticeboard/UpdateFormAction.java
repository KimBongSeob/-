package action.noticeboard;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import noticeboard.DAO.NoticeboardDao;
import noticeboard.DTO.NoticeboardDataBean;

public class UpdateFormAction implements CommandAction {// 湲��닔�젙 �뤌

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");// 로그인 정보 가져오기.
		
		request.setAttribute("id_size",id.length());
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		NoticeboardDao dbPro = NoticeboardDao.getInstance();
		NoticeboardDataBean article = dbPro.updateGetArticle(num);

		// �빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "/LearningManagementSystem/admin/noticeboard/updateForm.jsp";// �빐�떦酉�
	}
}
