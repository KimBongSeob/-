package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectStudentListService;
import student.DTO.StudentDataBean;


public class AllDepartmentAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
		//request.setCharacterEncoding("UTF-8");
		SelectAllDepartmentService AllDepartmentService = SelectAllDepartmentService.getInstance();
		List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
		request.setAttribute("DepartmentList", DepartmentList);

		return "/LearningManagementSystem/admin/SelectDepartmentList.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
