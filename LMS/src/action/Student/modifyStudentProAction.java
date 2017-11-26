package action.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import noticeboard.DAO.NoticeboardDao;
import noticeboard.DTO.NoticeboardDataBean;
import student.DAO.StudentDao;
import student.DTO.StudentDataBean;
import student.Service.modifyStudentInfoService;
import student.Service.modifyStudentService;

public class modifyStudentProAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(false);
			
			int id = Integer.parseInt((String) session.getAttribute("member"));
			String sd_passwd = request.getParameter("sd_passwd");
			String sd_hpone = request.getParameter("sd_hpone");
			String sd_address = request.getParameter("sd_address");
			String sd_email = request.getParameter("sd_email");


			modifyStudentInfoService StudentInfoService = modifyStudentInfoService.getInstance();

			StudentInfoService.InfoUpdate(id, sd_passwd,sd_hpone,sd_address,sd_email);
			
			//request.setAttribute("count", new Integer(count));
	
	
		return "/LearningManagementSystem/student/modifyPro.jsp";
		
	}
}