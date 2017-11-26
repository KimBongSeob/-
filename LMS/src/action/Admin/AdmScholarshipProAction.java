package action.Admin;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.InsertScholarshipService;


public class AdmScholarshipProAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
    	String Year_option = request.getParameter("Year_option");
    	String Semester_option = request.getParameter("Semester_option");
    	String Department_option = request.getParameter("Department_option");
    	String sd_num = request.getParameter("sd_num");
    	String AdmScholarship_option = request.getParameter("AdmScholarship_option");
    	String Grade_option = request.getParameter("Grade_option");
    	
    	if(Year_option == null){
    		Year_option="";
    	}
    	if(Semester_option == null){
    		Semester_option="";
    	}
    	if(Department_option == null){
    		Department_option="";
    	}
    	if(sd_num == null){
    		sd_num="";
    	}
    	if(AdmScholarship_option == null){
    		AdmScholarship_option="";
    	}
    	if(Grade_option == null){
    		Grade_option="";
    	}

    	if(!AdmScholarship_option.equals("")){
    		StringTokenizer token = new StringTokenizer(AdmScholarship_option, "/");
    		int count = InsertScholarshipService.getInstance().addItem(Integer.parseInt(sd_num), Year_option, Integer.parseInt(Grade_option), Semester_option, token.nextToken(),Integer.parseInt(token.nextToken()));
    		request.setAttribute("count", count);
    	}
    	request.setAttribute("Year_option", Year_option);
		request.setAttribute("Semester_option", Semester_option);
		request.setAttribute("Grade_option", Grade_option);
		request.setAttribute("Department_option", Department_option);
		request.setAttribute("sd_num",sd_num);
    	
    	
    	return "/LearningManagementSystem/admin/AdmScholarshipPro.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}


	