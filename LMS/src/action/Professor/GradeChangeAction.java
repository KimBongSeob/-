package action.Professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import professor.Service.GraderProService;


public class GradeChangeAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
	       HttpSession session = request.getSession(false);
	       String id = (String) session.getAttribute("member");//로그인 정보 가져오기.
		
	       
			String g_sum = request.getParameter("g_sum");
			int cr_num = Integer.parseInt(request.getParameter("cr_num"));
			
			int count = GraderProService.getInstance().getGradeList(g_sum, cr_num);
			
			String cp_num = request.getParameter("cp_num");
			request.setAttribute("cp_num", cp_num);
			request.setAttribute("count",count);
			
		return "/LearningManagementSystem/professor/gradeChange.jsp";// 해당 뷰
	}


}
