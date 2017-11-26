package action.Admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.InsertDepartmentService;

public class RegisterDepartmentAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {   
		request.setCharacterEncoding("UTF-8");

		
		String d_num = request.getParameter("d_num");

		String d_name = request.getParameter("d_name");

		
		if(d_num == null) {
			d_num = "";
		}
		if(d_name == null) {
			d_name = "";
		}
	
		if(!(d_num.equals("")) && !(d_name.equals(""))) {
			
			InsertDepartmentService.getInstance().addItem(d_num, d_name);
		}	
		return "/LearningManagementSystem/admin/RegisterDepartmentPro.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
