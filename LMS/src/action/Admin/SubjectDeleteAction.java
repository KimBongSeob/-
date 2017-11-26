package action.Admin;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.DeleteSubjectService;



public class SubjectDeleteAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
    	
    	String s_num = request.getParameter("s_num");
    	String d_num = request.getParameter("d_num");
    	
    	int count = DeleteSubjectService.getInstance().delItem(s_num, d_num);
    	
    	request.setAttribute("count", count);
    	request.setAttribute("d_num", d_num);
    	
    	return "/LearningManagementSystem/admin/SubjectDelete.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}


	