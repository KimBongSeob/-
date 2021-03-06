package action.Admin;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ProfessorDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectProfessorListService;


public class AllDepartmentProfessorAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
		//request.setCharacterEncoding("UTF-8");
		String select_option = request.getParameter("select_option");
		SelectAllDepartmentService AllDepartmentService = SelectAllDepartmentService.getInstance();
		
		if(select_option==null){
			select_option="";
			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
		}
		if(select_option.equals("")){
			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
		}
		
		if(!select_option.equals("")){
			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
			StringTokenizer token = new StringTokenizer(select_option, ",");
			String option1 = token.nextToken();
			String option2 = token.nextToken();
			List<ProfessorDataBean> ProfessorList = SelectProfessorListService.getInstance().getItemList(option1);
			request.setAttribute("select_option", option1);
			request.setAttribute("d_num",option2);
			request.setAttribute("DepartmentList", DepartmentList);
			request.setAttribute("ProfessorList", ProfessorList);
		}
		return "/LearningManagementSystem/admin/SelectProfessorList.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
