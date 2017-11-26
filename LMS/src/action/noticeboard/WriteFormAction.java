package action.noticeboard;

import action.CommandAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriteFormAction implements CommandAction {// 湲� �엯�젰 �뤌 泥섎━

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");// 로그인 정보 가져오기.
		
		request.setAttribute("id_size",id.length());
		
		// �젣紐⑷�怨� �떟蹂�湲��쓽 援щ텇
		int num = 0;/*, ref = 1, re_step = 0, re_level = 0;*/
		try {
			if (request.getParameter("num") != null) {
				num = Integer.parseInt(request.getParameter("num"));
			/*	ref = Integer.parseInt(request.getParameter("ref"));
				re_step = Integer.parseInt(request.getParameter("re_step"));
				re_level = Integer.parseInt(request.getParameter("re_level"));*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦
		request.setAttribute("num", new Integer(num));
		/*request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_step", new Integer(re_step));
		request.setAttribute("re_level", new Integer(re_level));
*/
		return "/LearningManagementSystem/admin/noticeboard/writeForm.jsp";// �빐�떦 酉�
	}
}