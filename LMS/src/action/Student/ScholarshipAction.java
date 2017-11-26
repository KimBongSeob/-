package action.Student;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.DTO.ScholarshipDataBean;
import student.DTO.StudentDataBean;
import student.Service.SelectScholarshipService;
import student.Service.SelectStudentService;

public class ScholarshipAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          

    	String select_option = request.getParameter("select_option");
    	SelectScholarshipService ScholarshipService = SelectScholarshipService.getInstance();
    	SelectStudentService AccountService = SelectStudentService.getInstance();
    	HttpSession session = request.getSession(false);
    	int member = Integer.parseInt((String)session.getAttribute("member"));
    	
    	int size = 0;

    	if(select_option==null){//맨 처음
    		select_option="";
        	List<ScholarshipDataBean> ScholarshipList = ScholarshipService.getItemList(member);
        	List<ScholarshipDataBean> ScholarshipAllList = ScholarshipList;
        	size = ScholarshipList.size();
        	
        	request.setAttribute("select_option", select_option);
        	request.setAttribute("size", size);
    		request.setAttribute("ScholarshipList",ScholarshipList);
    		request.setAttribute("ScholarshipAllList",ScholarshipAllList);

    	}
    	
    	if(!select_option.equals("")){
    		if(select_option.equals("전체조회")){// 전체 선택을 했을 때
        		
            	List<ScholarshipDataBean> ScholarshipList = ScholarshipService.getItemList(member);
            	List<ScholarshipDataBean> ScholarshipAllList = ScholarshipList;
            	size = ScholarshipList.size();
            	
            	request.setAttribute("select_option", select_option);
            	request.setAttribute("size", size);
            	request.setAttribute("ScholarshipList",ScholarshipList);
            	request.setAttribute("ScholarshipAllList",ScholarshipAllList);
    		}else{
    			List<ScholarshipDataBean> ScholarshipAllList = ScholarshipService.getItemList(member);
    			StringTokenizer token = new StringTokenizer(select_option, "/");
            	List<ScholarshipDataBean> ScholarshipList = ScholarshipService.getItemList_content(member,token.nextToken(),Integer.parseInt(token.nextToken()),token.nextToken());
            	size = ScholarshipList.size();
            	request.setAttribute("select_option", select_option);
            	request.setAttribute("size", size);
            	request.setAttribute("ScholarshipAllList",ScholarshipAllList);
        		request.setAttribute("ScholarshipList",ScholarshipList);
    			
    		}
    	}
    	
    	/*계좌정보 select*/
    	
    	StudentDataBean data = AccountService.getItem(member);
    	
    	request.setAttribute("accountData", data);
    	return "/LearningManagementSystem/student/Scholarship.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}


	