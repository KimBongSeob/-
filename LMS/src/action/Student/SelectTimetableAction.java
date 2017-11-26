package action.Student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import classplan.DTO.ClassplanDataBean;
import student.Service.SelectTimetableService;


public class SelectTimetableAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");// 로그인 정보 가져오기.
		
		request.setAttribute("sd_num", id);
		
		List<ClassplanDataBean> ClassRequestList = SelectTimetableService.getInstance().getItemList(id);

		request.setAttribute("ClassRequestList", ClassRequestList);
			
		return "/LearningManagementSystem/student/SelectTimetable.jsp";
	}
}

