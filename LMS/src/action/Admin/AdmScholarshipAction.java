package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.SelectAvgGradeMaxService;
import student.DTO.DepartmentDataBean;
import student.DTO.StudentDataBean;
import student.Service.SelectDepartmentService;


public class AdmScholarshipAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String Department_option = request.getParameter("Department_option");
		String Year_option = request.getParameter("Year_option");
		String Grade_option = request.getParameter("Grade_option");
		String Semester_option = request.getParameter("Semester_option");
		
		if(Year_option == null){
			Year_option = "";
		}
		if(Grade_option == null){
			Grade_option = "";
		}
		if(Semester_option == null){
			Semester_option = "";
		}
		
		if (Department_option == null) {// 맨 처음
			Department_option = "";
			List<DepartmentDataBean> Departmentlist = SelectDepartmentService.getInstance().getItemList();

			request.setAttribute("size", Departmentlist.size());
			request.setAttribute("Departmentlist", Departmentlist);

		}
		if (!Department_option.equals("")) {

			if (!Department_option.equals("선택")) {
				List<DepartmentDataBean> Departmentlist = SelectDepartmentService.getInstance().getItemList();

				request.setAttribute("size", Departmentlist.size());
				request.setAttribute("Departmentlist", Departmentlist);

				List<StudentDataBean> studentList = SelectAvgGradeMaxService.getInstance().getItemList(Year_option, Semester_option, Department_option, Integer.parseInt(Grade_option));

				request.setAttribute("Year_option", Year_option);
				request.setAttribute("Semester_option", Semester_option);
				request.setAttribute("Department_option", Department_option);
				request.setAttribute("Grade_option", Grade_option);
				request.setAttribute("studentListSize", studentList.size());
				request.setAttribute("studentList", studentList);

			} else if (Department_option.equals("선택")) {
				List<DepartmentDataBean> Departmentlist = SelectDepartmentService.getInstance().getItemList();

				request.setAttribute("size", Departmentlist.size());
				request.setAttribute("Departmentlist", Departmentlist);
			}
		}

		return "/LearningManagementSystem/admin/AdmScholarship.jsp";
	}
}