package action.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.DeleteDepartmentService;

public class DeleteDepartmentAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String d_num = request.getParameter("d_num");
		int check = DeleteDepartmentService.getInstance().delItem(d_num);
		request.setAttribute("check", check);
				

	return"/LearningManagementSystem/admin/deleteDepartment.jsp";
}}