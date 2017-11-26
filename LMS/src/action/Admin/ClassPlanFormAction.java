package action.Admin;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import professor.DTO.ProfessorSubDataBean;

import professor.Service.SelectProfessorNameService;
public class ClassPlanFormAction implements CommandAction {//글목록 처리
    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
	/*	int CP_MAX_NO = -1;
		int count = -1; //성공 카운트

		if(request.getParameter("CP_MAX_NO") != null){
			CP_MAX_NO = Integer.parseInt(request.getParameter("CP_MAX_NO"));
		} 
		String CP_YEAR = request.getParameter("CP_YEAR");
		String CP_SEMESTER = request.getParameter("CP_SEMESTER");
		String Subject_option = request.getParameter("Subject_option");//s_num을 value로 가지고 있음
		String CP_TIME = request.getParameter("CP_TIME");
		String Department_option = request.getParameter("Department_option");//d_num value
		String CR_NUM = request.getParameter("CR_NUM");
		String PF_NUM = request.getParameter("PF_NUM");
		String PF_EMAIL = request.getParameter("PF_EMAIL");
		String CP_OUTLINE = request.getParameter("CP_OUTLINE");
		String CP_TEXTBOOK = request.getParameter("CP_TEXTBOOK");
		String CP_SUB_TEXTBOOK = request.getParameter("CP_SUB_TEXTBOOK");
		String CP_VALUATION = request.getParameter("CP_VALUATION");
		
		
		//if(CP_DATE== null){} 작성일자기 때문에 무조건 들어옴.
		if(CP_YEAR == null){
			CP_YEAR = "";
		}
		if(CP_SEMESTER == null){
			CP_SEMESTER = "";
		}
		if(Subject_option == null){
			Subject_option = "";
		}
		if(CP_TIME == null){
			CP_TIME = "";
		}
		if(Department_option == null){
			Department_option = "";
		}
		if(CR_NUM == null){
			CR_NUM = "";
		}
		if(PF_NUM == null){
			PF_NUM = "";
		}
		if(PF_EMAIL == null){
			PF_EMAIL = "";
		}
		if(CP_OUTLINE == null){
			CP_OUTLINE = "";
		}
		if(CP_TEXTBOOK == null){
			CP_TEXTBOOK = ""; 
		}
		if(CP_SUB_TEXTBOOK == null){
			CP_SUB_TEXTBOOK = "";
		}
		if(CP_VALUATION == null){
			CP_VALUATION = "";
		}
		//강의시간/요일, 강의실, 부교재는 검사에서 제외
		if((!CP_YEAR.equals("")) && (!CP_SEMESTER.equals("")) && (!Subject_option.equals(""))
				&& (!Department_option.equals("")) 
				&& (!PF_NUM.equals("")) && (!PF_EMAIL.equals(""))
				&& (!CP_OUTLINE.equals("")) && (!CP_TEXTBOOK.equals(""))
				&& (!CP_VALUATION.equals("")) && (CP_MAX_NO != -1)){
			
			count = InsertClassplanService.getInstance().addItem(CP_MAX_NO, CP_YEAR, CP_SEMESTER, Subject_option, CP_TIME, Department_option, CR_NUM, PF_NUM, PF_EMAIL, CP_OUTLINE, CP_TEXTBOOK, CP_SUB_TEXTBOOK, CP_VALUATION);
		}
		request.setAttribute("count", count);
		
		//
    	Date date_now = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(date_now).toString();
		request.setAttribute("date", date);
		
		ProfessorSubDataBean ProfessorData = SelectProfessorNameService.getInstance().getItem(id);
		
		request.setAttribute("ProfessorData", ProfessorData);
		*/
		
		
    	return "/LearningManagementSystem/admin/ClassRegister.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}

