package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ReinstatementDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectReinstatementService;


public class AdminLoaAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
		//request.setCharacterEncoding("UTF-8");
		SelectAllDepartmentService AllDepartmentService = SelectAllDepartmentService.getInstance();
		List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
		request.setAttribute("DepartmentList", DepartmentList);
		
		//
		int select = 1;//선택된 메뉴 위치 선정
		
		if(request.getParameter("select") != null){
			select = Integer.parseInt(request.getParameter("select"));
		}
		
		request.setAttribute("select", select);
		
		
		
		//////////////
		String select_option = request.getParameter("select_option");
		String select_option2 = request.getParameter("select_option2");
		
		
		if(select_option==null){
			select_option="";
		}
		if(select_option2==null){
			select_option2="";
		}
		
		if(!select_option.equals("")){
			List<ReinstatementDataBean> ReinstatementList = SelectReinstatementService.getInstance().getItemList(select_option);
			request.setAttribute("select_option", select_option);
			request.setAttribute("ReinstatementList", ReinstatementList);
			request.setAttribute("DepartmentList", DepartmentList);
			
		}
		if(!select_option2.equals("")){
			List<ReinstatementDataBean> ReinstatementList_B = SelectReinstatementService.getInstance().getItemList_B(select_option2);
			request.setAttribute("select_option2", select_option2);
			request.setAttribute("ReinstatementList_B", ReinstatementList_B);
			request.setAttribute("DepartmentList", DepartmentList);
			
		}
		
		
		
		
		
		
		
		
		
		//////////
		return "/LearningManagementSystem/admin/AdminLoa.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
