package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.RegisterStudentService;
import admin.Service.SelectStudentListService;
import admin.reinstatement.Algorithm;
import student.DTO.StudentDataBean;


public class RegisterStudentAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		String select_option = request.getParameter("select_option"); // 현재 선택한 학과의 밸류값 = d_name
		String d_num = request.getParameter("d_num"); 
		
		
		int sd_num = 0 ;
		
		if(request.getParameter("sd_num") != null) {
			sd_num = Integer.parseInt(request.getParameter("sd_num"));
		}
		
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

		
		if((sd_num != 0) && !(sd_passwd.equals("")) && !(sd_name.equals("")) && !(sd_jumin.equals(""))) {
			java.sql.Date sd_jumin_date = java.sql.Date.valueOf(sd_jumin);
			//Date sd_jumin_date = new SimpleDateFormat("yyyy-MM-dd").parse(sd_jumin);
			//insert
			String d_sub_num = "";
			
			RegisterStudentService StudentService = RegisterStudentService.getInstance();
			int check = StudentService.insertStudentService(sd_num, sd_passwd, sd_name, sd_jumin_date, d_num);
			// 입력된 값을 넘겨서 DB에 저장하는 서비스. = 학생 정보 등록.
			
			request.setAttribute("select_option", select_option+","+d_num);

		
		}
		
		
		
		return "/LearningManagementSystem/admin/RegisterStudentpro.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
