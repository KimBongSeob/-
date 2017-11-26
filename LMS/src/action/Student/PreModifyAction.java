package action.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.Service.modifyStudentService;

public class PreModifyAction implements CommandAction {
	

	    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
	       
	        

	    	HttpSession session = request.getSession(false);
	    	int member = Integer.parseInt((String)session.getAttribute("member"));
	        
	        //호출했던 ControllerUsingURI
	    	request.setAttribute("member",member);
	    	
	    	 return "/LearningManagementSystem/student/PreModify.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	    }
	}

