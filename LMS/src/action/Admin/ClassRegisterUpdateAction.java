package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.ClassplanDataBean2;
import admin.DTO.DepartmentDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectSubjectListService;
import admin.Service.UpdateRegistrationClassplanService;


public class ClassRegisterUpdateAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
		
		int cp_num = Integer.parseInt(request.getParameter("CP_NUM"));
		String cr_num = request.getParameter("CR_NUM");
		String cp_time = request.getParameter("CP_TIME");
		
		
		int count = UpdateRegistrationClassplanService.getInstance().setItem(cp_time, cr_num, cp_num);
	
		request.setAttribute("count", count);
		return "/LearningManagementSystem/admin/ClassRegisterUpdate.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
