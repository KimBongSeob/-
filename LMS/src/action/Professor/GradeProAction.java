package action.Professor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import professor.Service.GraderProService;
import action.CommandAction;
import professor.DAO.Professor_All_DataBean;

public class GradeProAction implements CommandAction {

	// 글 입력 폼 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");// 로그인 정보 가져오기.

		int cp_num = -1;
		if(request.getParameter("cp_num") == null){
			cp_num = 0;
		}else{
			
		cp_num = Integer.parseInt(request.getParameter("cp_num"));

		

		List<Professor_All_DataBean> getGradeProlist = GraderProService.getInstance().getItemList(id, cp_num);
		List<Professor_All_DataBean> StudentGradelist = GraderProService.getInstance().getItemList(cp_num);

		request.setAttribute("cp_num", cp_num);
		request.setAttribute("getGradeProlist", getGradeProlist);
		request.setAttribute("StudentGradelist", StudentGradelist);

		}
		

		
		return "/LearningManagementSystem/professor/gradePro.jsp";// 해당 뷰
	}
}
