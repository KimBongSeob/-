package action.Student;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.DTO.RegisterDataBean;
import student.DTO.ReinstatementDataBean;
import student.DTO.StudentDataBean;
import student.DTO.StudentRegisterDataBean;
import student.Service.InsertReinstatementService;
import student.Service.SelectRegisterService;
import student.Service.SelectStudentRegisterService;
import student.Service.UpdateReinstatementService;

import student.Service.modifyStudentService;
import student.reinstatement.Algorithm;

public class modifyStudentAction implements CommandAction {//글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		int id = Integer.parseInt((String) session.getAttribute("member"));
		


		StudentDataBean StudentModifyData = modifyStudentService.getInstance().getItem(id);
		request.setAttribute("StudentModifyData", StudentModifyData);
		return "/LearningManagementSystem/student/modify.jsp";
	}
}
