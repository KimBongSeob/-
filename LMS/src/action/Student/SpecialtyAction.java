package action.Student;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.DTO.DepartmentDataBean;
import student.Service.InsertSpecialtyService;
import student.Service.SelectAllDepartmentService;
import student.Service.SelectStudentService;


public class SpecialtyAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		
		String major = request.getParameter("major"); // 라디오버튼 값(복수전공 or 부전공) 긁어옴
		String select_option = request.getParameter("select_option"); // 선택한 특정 학과이름 밸류값(d_num)긁어옴 / select_option == d_num
		InsertSpecialtyService SpecialtyService = InsertSpecialtyService.getInstance();
		SelectStudentService StudentService = SelectStudentService.getInstance();
		SelectAllDepartmentService AllDepartmentService = SelectAllDepartmentService.getInstance(); // 모든 학과이름 셀렉트
		
		HttpSession session = request.getSession(false);
    	int sd_num = Integer.parseInt((String)session.getAttribute("member")); // 현재 세션에 저장된 로그인한 학번 값 가져옴
		
//		if(major==null && select_option==null){ // 복수/부전공 and 희망학과 모두 선택하지 않은 경우
//			select_option="";
//			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
//			request.setAttribute("select_option", select_option);
//			request.setAttribute("DepartmentList", DepartmentList);
//		}
//		
//		else if(major.equals("major1") && select_option==null){ // 복수전공으로 선택했지만 희망학과는 선택하지 않은 경우
//			select_option="";
//			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
//			request.setAttribute("select_option", select_option);
//			request.setAttribute("DepartmentList", DepartmentList);
//		}
//		
//		else if(major.equals("major2") && select_option==null){ // 부전공으로 선택했지만 희망학과는 선택하지 않은 경우
//			select_option="";
//			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
//			request.setAttribute("select_option", select_option);
//			request.setAttribute("DepartmentList", DepartmentList);
//		}
//		
//		else 
    	if(select_option == null){
    		select_option="";
    		List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
			request.setAttribute("DepartmentList", DepartmentList);
    	}
    	if(major == null){
    		major="";
    	}
    	if(major.equals("major1") && (!select_option.equals(""))){ // 복수전공버튼을 선택하고 특정 학과명 선택했을 경우
			    // 복수전공 버튼 클릭
			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList(); // DB에서 꺼내온 학과 리스트를 DTO객체에 저장
			request.setAttribute("DepartmentList", DepartmentList); // 학과명 리스트 저장 -> 뷰에서 출력할 때 이용
			
			long time = System.currentTimeMillis();
			Date dm_date = new Date(time); // 복수전공 신청날짜 값
			Date m_date = null; // 부전공 신청날짜 = null값
			
			int count = SpecialtyService.requestSpecialty(sd_num, select_option, dm_date, m_date);
			
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
			request.setAttribute("count", count);
	
		}
		else if(major.equals("major2") && (!select_option.equals(""))){ // 부전공버튼을 선택하고 특정 학과명 선택했을 경우
			    // 부전공 버튼 클릭
			List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList(); // DB에서 꺼내온 학과 리스트를 DTO객체에 저장
			request.setAttribute("DepartmentList", DepartmentList); // 학과명 리스트 저장 -> 뷰에서 출력할 때 이용
		
			long time = System.currentTimeMillis();
			Date m_date = new Date(time); // 부전공 신청날짜 값
			Date dm_date = null; // 복수전공 신청날짜 = null값
			
			int count = SpecialtyService.requestSpecialty(sd_num, select_option, dm_date, m_date);
			
			request.setAttribute("select_option", select_option);
			request.setAttribute("DepartmentList", DepartmentList);
			request.setAttribute("count", count);
		
		}
		
    	return "/LearningManagementSystem/student/Specialty.jsp";
	}
	
}
