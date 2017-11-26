package action.Admin;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.SubjectDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectStudentListService;
import admin.Service.SelectSubjectService;
import student.DTO.StudentDataBean;


public class SubjectAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
    	String select_option = request.getParameter("select_option");

		if(select_option==null){
			select_option="";
			List<DepartmentDataBean> DepartmentList = SelectAllDepartmentService.getInstance().getItemList();
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
		}
		if(select_option.equals("")){
			List<DepartmentDataBean> DepartmentList = SelectAllDepartmentService.getInstance().getItemList();
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
		}
		if(!select_option.equals("")){
			List<DepartmentDataBean> DepartmentList = SelectAllDepartmentService.getInstance().getItemList();
			
			List<SubjectDataBean> SubjectList = SelectSubjectService.getInstance().getItemList(select_option);
			request.setAttribute("d_num",select_option);
			request.setAttribute("DepartmentList", DepartmentList);
			request.setAttribute("SubjectList", SubjectList);
			request.setAttribute("size", SubjectList.size());
		}
    	
    	//SelectSubjectService
    	return "/LearningManagementSystem/admin/Subject.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}


	