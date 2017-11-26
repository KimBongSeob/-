package action.Admin;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.ProfessorDataBean;
import admin.Service.RegisterProfessorService;
import admin.Service.SelectProfessorListService;

public class RegisterProfessorAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {   
		request.setCharacterEncoding("UTF-8");

		String select_option = request.getParameter("select_option"); // 현재 선택한 학과의 밸류값 = d_name
		String d_num = request.getParameter("d_num");
		//request.setAttribute("select_option", select_option);
		
		String pf_num = null ;
		
		if(request.getParameter("pf_num") != null) {
			pf_num = request.getParameter("pf_num");
		}
		
		String pf_passwd = request.getParameter("pf_passwd");
		String pf_name = request.getParameter("pf_name");
		String pf_jumin = request.getParameter("pf_jumin");
		
		if(pf_passwd == null) {
			pf_passwd = "";
		}
		if(pf_name == null) {
			pf_name = "";
		}
		if(pf_jumin == null) {
			pf_jumin = "";
		}
		
		
		if((pf_num !=null) && !(pf_passwd.equals("")) && !(pf_name.equals("")) && !(pf_jumin.equals(""))) {
			java.sql.Date pf_jumin_date = java.sql.Date.valueOf(pf_jumin);
			//Date sd_jumin_date = new SimpleDateFormat("yyyy-MM-dd").parse(sd_jumin);
			//insert
			String d_sub_num = "";
			
			RegisterProfessorService ProfessorService = RegisterProfessorService.getInstance();
			int check = ProfessorService.insertProfessorService(pf_num, pf_passwd, pf_name, pf_jumin_date, d_num);
			// 입력된 값을 넘겨서 DB에 저장하는 서비스. = 학생 정보 등록.

				
			request.setAttribute("select_option", select_option+","+d_num);

		
		}

			
		
		
		return "/LearningManagementSystem/admin/RegisterProfessorpro.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
