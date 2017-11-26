package action.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.SubjectDataBean;
import admin.Service.SelectDepartmentDnumService;
import admin.Service.SelectSubjectMaxService;

public class SubjectFormAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String d_num = request.getParameter("d_num");
		DepartmentDataBean DepartmentData = SelectDepartmentDnumService.getInstance().getItem(d_num);

		SubjectDataBean data = SelectSubjectMaxService.getInstance().getItem("AA");

		String result = "";

		if (data == null) {
			result = "AA" + "001";
		} else {
			String sub = data.getS_num().substring(2);
			int s_int = Integer.parseInt(sub);
			s_int++;
			String suffix = String.format("%03d", s_int);
			result = data.getS_num().substring(0, 2) + suffix;
		}
		request.setAttribute("result", result);
		request.setAttribute("DepartmentData", DepartmentData);
		
		return "/LearningManagementSystem/admin/SubjectForm.jsp";
	}
}
