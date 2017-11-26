package readOnlynoticeStudent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import noticeboard.DAO.NoticeboardDao;
import noticeboard.DTO.NoticeboardDataBean;

public class ContentAction implements CommandAction {// 湲��궡�슜 泥섎━

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");//로그인 정보 가져오기.

		int num = Integer.parseInt(request.getParameter("num"));// �빐�떦 湲�踰덊샇
		String pageNum = request.getParameter("pageNum");// �빐�떦 �럹�씠吏� 踰덊샇

		NoticeboardDao dbPro = NoticeboardDao.getInstance();// DB泥섎━
		NoticeboardDataBean article = dbPro.getArticle(num);// �빐�떦 湲�踰덊샇�뿉 ���븳 �빐�떦 �젅肄붾뱶

		// �빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "/LearningManagementSystem/student/noticeboard/content.jsp";// �빐�떦 酉�
	}
}
