package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ReinstatementDataBean;
import admin.DTO.SubspecialtyDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectReinstatementService;
import admin.Service.SelectSubspecialtyBfService;


public class AdminSpecialtyAction implements CommandAction{

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
			List<SubspecialtyDataBean> SubspecialtyList = SelectSubspecialtyBfService.getInstance().getItemList(select_option);
			
			request.setAttribute("SubspecialtyList", SubspecialtyList);
			request.setAttribute("DepartmentList", DepartmentList);
			
		}
		if(!select_option2.equals("")){
			List<SubspecialtyDataBean> SubspecialtyList_B = SelectSubspecialtyBfService.getInstance().getItemList_B(select_option2);
			
			request.setAttribute("SubspecialtyList_B", SubspecialtyList_B);
			request.setAttribute("DepartmentList", DepartmentList);
			
		}
		
		
		
		
		
		
		
		
		
		///////////LearningManagementSystem/AdminSpecialty.do
		return "/LearningManagementSystem/admin/AdminSpecialty.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
