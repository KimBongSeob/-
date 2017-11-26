package action.Student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.DTO.EvaluationItemDataBean;
import student.Service.SelectEvalItemService;

public class ClassEvaluationAction implements CommandAction {

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
        
    	/*HttpSession session = request.getSession(false);
    	int sd_num = Integer.parseInt((String)session.getAttribute("member"));*/
    	
    	String result = "EvaluationItem.jsp";
    	
    	if(request.getParameter("eval1") == null){
    	
    		HttpSession session = request.getSession(false);
        	int sd_num = Integer.parseInt((String)session.getAttribute("member"));
    		
    	int cr_num = Integer.parseInt(request.getParameter("cr_num")); // 수강신청 번호
    	
    	System.out.println("cr_num:::"+cr_num);
    	
    	SelectEvalItemService EvalItemService = SelectEvalItemService.getInstance();
    	
    	EvaluationItemDataBean EvalList = EvalItemService.getEvalItem1(sd_num, cr_num);
    	
    	request.setAttribute("EvalList", EvalList);
    	request.setAttribute("cr_num", cr_num);
    	result = "EvaluationItem.jsp";
    	}
    	
    	else if(!request.getParameter("eval1").equals("")){
    		
    	int eval1 = 0;
    	int eval2 = 0;
    	int eval3 = 0;
    	int eval4 = 0;
    	int eval5 = 0;
    	
    	if(request.getParameter("eval1").equals("5"))
    	eval1 = 5;
    	else if(request.getParameter("eval1").equals("4"))
    		eval1 = 4;
    	else if(request.getParameter("eval1").equals("3"))
    		eval1 = 3;
    	else if(request.getParameter("eval1").equals("2"))
    		eval1 = 2;
    	else if(request.getParameter("eval1").equals("1"))
    		eval1 = 1;
    	
    	if(request.getParameter("eval2").equals("5"))
    		eval2 = 5;
        	else if(request.getParameter("eval2").equals("4"))
        		eval2 = 4;
        	else if(request.getParameter("eval2").equals("3"))
        		eval2 = 3;
        	else if(request.getParameter("eval2").equals("2"))
        		eval2 = 2;
        	else if(request.getParameter("eval2").equals("1"))
        		eval2 = 1;
    	
    	if(request.getParameter("eval3").equals("5"))
        	eval3 = 5;
        	else if(request.getParameter("eval3").equals("4"))
        		eval3 = 4;
        	else if(request.getParameter("eval3").equals("3"))
        		eval3 = 3;
        	else if(request.getParameter("eval3").equals("2"))
        		eval3 = 2;
        	else if(request.getParameter("eval3").equals("1"))
        		eval3 = 1;
    	
    	if(request.getParameter("eval4").equals("5"))
        	eval4 = 5;
        	else if(request.getParameter("eval4").equals("4"))
        		eval4 = 4;
        	else if(request.getParameter("eval4").equals("3"))
        		eval4 = 3;
        	else if(request.getParameter("eval4").equals("2"))
        		eval4 = 2;
        	else if(request.getParameter("eval4").equals("1"))
        		eval4 = 1;
    	
    	if(request.getParameter("eval5").equals("5"))
        	eval5 = 5;
        	else if(request.getParameter("eval5").equals("4"))
        		eval5 = 4;
        	else if(request.getParameter("eval5").equals("3"))
        		eval5 = 3;
        	else if(request.getParameter("eval5").equals("2"))
        		eval5 = 2;
        	else if(request.getParameter("eval5").equals("1"))
        		eval5 = 1;
    	
    	
    	int e_sum = eval1 + eval2 + eval3 + eval4 + eval5;
    	
    		//~서비스.메소드명(sd_num, sum, );
    	
    	System.out.println("e_sum:::" + e_sum);
    	
    	
    	HttpSession session = request.getSession(false);
    	int sd_num = Integer.parseInt((String)session.getAttribute("member"));
    	
    	System.out.println("sd_num:::"+sd_num);
    	
    	int cr_num = Integer.parseInt(request.getParameter("cr_num")); // 왜 null값이야 !!!!!!!!!!!!!!!!!!!!!!!!!
    	
    	System.out.println("cr_num:::"+cr_num);
    	
    	SelectEvalItemService EvalItemService = SelectEvalItemService.getInstance();
    	
    	List<EvaluationItemDataBean> EvalList = EvalItemService.getEvalItem2(sd_num, cr_num, e_sum);
    	
    	request.setAttribute("EvalList", EvalList);
    	//result = "index.jsp";
    	result = "reindex.jsp";
    			
    	}
    	
    	
    	return "/LearningManagementSystem/student/"+result;
        
    }
}


	