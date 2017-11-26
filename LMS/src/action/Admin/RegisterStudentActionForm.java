package action.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.SelectStudentSdnumService;
import admin.reinstatement.Algorithm;
import student.DTO.StudentDataBean;

public class RegisterStudentActionForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String select_option = request.getParameter("select_option");
		String d_num = request.getParameter("d_num");
		request.setAttribute("select_option", select_option);
		request.setAttribute("d_num",d_num);
		
		
		
		String sd_passwd = request.getParameter("sd_passwd");
		String sd_name = request.getParameter("sd_name");
		String sd_jumin = request.getParameter("sd_jumin");
		
		if(sd_passwd == null) {
			sd_passwd = "";
		}
		if(sd_name == null) {
			sd_name = "";
		}
		if(sd_jumin == null) {
			sd_jumin = "";
		}
		
		int c_date = Algorithm.getCurrent_year();
		
		request.setAttribute("c_date", c_date);
		//submit_student_button
		String sd_num = (c_date-6)+d_num;
		
		StudentDataBean data = SelectStudentSdnumService.getInstance().getItem(sd_num);
		
		String result = "";
		
		if(data.getSd_num() != 0){
			result = ""+data.getSd_num();
		}else{
			sd_num+="001";
			result=sd_num;
		}
		request.setAttribute("sd_num", result);
		
		return "/LearningManagementSystem/admin/RegisterStudent.jsp";
	}

}
