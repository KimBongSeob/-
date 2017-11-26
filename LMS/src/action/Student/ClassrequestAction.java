package action.Student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import classplan.DTO.ClassplanDataBean;
import professor.Service.SelectD_ClassplanService;
import student.DTO.DepartmentDataBean;
import student.Service.SelectClassRequestClassplanService;
import student.Service.SelectClassbasketClassplanService;
import student.Service.SelectDepartmentService;



public class ClassrequestAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");// 로그인 정보 가져오기.
		int size = 0;
		String Department_option = request.getParameter("Department_option");
		
		int select = 1;
		
		if(request.getParameter("select") != null){
			select = Integer.parseInt(request.getParameter("select"));
		}
		
		request.setAttribute("select", select);

		
		
		request.setAttribute("sd_num", id);

		if (Department_option == null) {// 맨 처음
			Department_option = "";
			List<DepartmentDataBean> Departmentlist = SelectDepartmentService.getInstance().getItemList();

			size = Departmentlist.size();
			request.setAttribute("size", size);
			request.setAttribute("Departmentlist", Departmentlist);
			

		}
		if (!Department_option.equals("")) {
			
			if (!Department_option.equals("선택")) {
				List<DepartmentDataBean> Departmentlist = SelectDepartmentService.getInstance().getItemList();

				size = Departmentlist.size();
				request.setAttribute("size", size);
				request.setAttribute("Departmentlist", Departmentlist);

				List<ClassplanDataBean> ClassplanList = SelectD_ClassplanService.getInstance()
						.getItemList(Department_option);

				request.setAttribute("ClassplanListSize", ClassplanList.size());
				request.setAttribute("ClassplanList", ClassplanList);

			}else if(Department_option.equals("선택")){
				List<DepartmentDataBean> Departmentlist = SelectDepartmentService.getInstance().getItemList();

				size = Departmentlist.size();
				request.setAttribute("size", size);
				request.setAttribute("Departmentlist", Departmentlist);
			}
		}
		////////// 수강신청한 강의계획서들 출력
		List<ClassplanDataBean> ClassRequestList = SelectClassRequestClassplanService.getInstance().getItemList(id);

		request.setAttribute("ClassRequestList", ClassRequestList);
		
		List<ClassplanDataBean> ClassbasketList = SelectClassbasketClassplanService.getInstance().getItemList(id);

		request.setAttribute("ClassbasketList", ClassbasketList);
		
		return "/LearningManagementSystem/student/Classrequest.jsp";// 해당 뷰정보 리턴
																	// -
																	// WebContent-하위경로부터!!

		// 호출했던 ControllerUsingURI
	}
}
