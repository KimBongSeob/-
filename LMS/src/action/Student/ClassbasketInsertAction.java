package action.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.Service.InsertClassrequestService;

public class ClassbasketInsertAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		int id = Integer.parseInt((String) session.getAttribute("member"));// 로그인 정보 가져오기.
		int size = 0;
		
		int cp_num = Integer.parseInt(request.getParameter("cp_num"));
		
		int count = InsertClassrequestService.getInstance().addItem(cp_num,id);
		request.setAttribute("count", count);
		
		return "/LearningManagementSystem/student/ClassbasketInsert.jsp";
	}
}
