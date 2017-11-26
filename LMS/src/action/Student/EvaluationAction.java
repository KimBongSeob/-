package action.Student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.DTO.EvaluationDataBean;
import student.Service.SelectEvaluationService;


public class EvaluationAction implements CommandAction {

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
        
    	HttpSession session = request.getSession(false);
    	int sd_num = Integer.parseInt((String)session.getAttribute("member"));
    	
    	SelectEvaluationService EvaluationService = SelectEvaluationService.getInstance();
    	
    	String cp_year = "2017";
    	String cp_semester = "2";
    	String registration = "1";
    	
    	List<EvaluationDataBean> ClassList = EvaluationService.getClassList(sd_num, cp_year, cp_semester, registration);
    	
    	request.setAttribute("ClassList", ClassList);
    	
    	return "/LearningManagementSystem/student/Evaluation.jsp";
        
    }
}


	