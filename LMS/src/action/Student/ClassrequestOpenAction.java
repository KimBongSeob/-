package action.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import classplan.DTO.ClassplanModifyDataBean;
import professor.Service.selectClassplanModifyService;
import student.Service.InsertClassrequestService;


public class ClassrequestOpenAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
    	
    	
    	int cp_num = 0;
    	int sd_num = 0;
    	if(request.getParameter("cp_num") != null){
    		cp_num= Integer.parseInt(request.getParameter("cp_num"));
    		request.setAttribute("cp_num", cp_num);
    	}
    	if(request.getParameter("sd_num") != null){
    		sd_num = Integer.parseInt(request.getParameter("sd_num"));
    		request.setAttribute("sd_num", sd_num);
    	}
    	
    	String submit = request.getParameter("ClassPlan_Submitbutton");

    	if(submit == null){
    		submit = "";
    	}
    	if(submit.equals("신청")){
    		int count = InsertClassrequestService.getInstance().addItem(Integer.parseInt(request.getParameter("CP_NUM")),
    				Integer.parseInt(request.getParameter("SD_NUM")));
    		request.setAttribute("count", count);
    		
    	}
    	ClassplanModifyDataBean data = selectClassplanModifyService.getInstance().getItem(""+cp_num);

    	request.setAttribute("data", data);
    	
        return "/LearningManagementSystem/student/ClassrequestOpen.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}


	