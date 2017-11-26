package action.Professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import professor.Service.ecaluationService;

public class EcaluationProAction implements CommandAction {// 글 입력 폼 처리
	

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
	       HttpSession session = request.getSession(false);
	       String id = (String) session.getAttribute("member");//로그인 정보 가져오기.
		
	       int cp_num = Integer.parseInt(request.getParameter("cp_num"));
	       int gnum = ecaluationService.getInstance().getResult(cp_num);
	       
	       request.setAttribute("cp_num",cp_num);
	       request.setAttribute("gnum", gnum);

		
		return "/LearningManagementSystem/professor/ecaluationPro.jsp";// 해당 뷰
	}

}
