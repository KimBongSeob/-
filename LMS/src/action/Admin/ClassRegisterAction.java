package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.ClassplanDataBean2;
import admin.DTO.DepartmentDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectSubjectListService;


public class ClassRegisterAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
		
		String select_option = request.getParameter("select_option");
		SelectAllDepartmentService AllDepartmentService = SelectAllDepartmentService.getInstance();
		
		if(select_option==null){
			select_option="";
			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
		}
		
		if(!select_option.equals("")){
			
			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
			List<ClassplanDataBean2> SubjectList = SelectSubjectListService.getInstance().getItemList(select_option);
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
			request.setAttribute("SubjectList", SubjectList);
		}
		
		
		
		return "/LearningManagementSystem/admin/ClassRegister.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
