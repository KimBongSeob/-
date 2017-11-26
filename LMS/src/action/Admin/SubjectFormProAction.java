package action.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.InsertSubjectService;


public class SubjectFormProAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
    	
    	String d_num = request.getParameter("d_num");
    	String s_num = request.getParameter("s_num");
    	String s_name = request.getParameter("subject_name");
    	
		String s_cp_credits = request.getParameter("s_cp_credits");
		
		String sub = s_num.substring(0,2);
		String s_cp_division ="";
		
		if(sub.equals("AA")){
			s_cp_division ="교선";
		}else if(sub.equals("BB")){
			s_cp_division ="교필";
		}else if(sub.equals("CC")){
			s_cp_division ="전선";
		}else if(sub.equals("DD")){
			s_cp_division ="전필";
		}
		
		int count = InsertSubjectService.getInstance().addItem(s_num, s_name, s_cp_division, Integer.parseInt(s_cp_credits), d_num);
		request.setAttribute("count", count);
		request.setAttribute("d_num", d_num);
    	return "/LearningManagementSystem/admin/SubjectFormPro.jsp";
    }
}


	