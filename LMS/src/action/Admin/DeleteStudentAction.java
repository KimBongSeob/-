package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.Service.DeleteStudentService;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectStudentListService;
import student.DTO.StudentDataBean;

public class DeleteStudentAction implements CommandAction {// 湲��궘�젣

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String select_option = request.getParameter("select_option");
		int sd_num = Integer.parseInt(request.getParameter("sd_num"));
		String sd_name = request.getParameter("sd_name");
		 DeleteStudentService  StudentService =  DeleteStudentService.getInstance();
		 int check = StudentService.deleteItemList(sd_num);
		 		request.setAttribute("select_option", select_option);
		 		
				request.setAttribute("sd_num", sd_num);
				request.setAttribute("sd_name", sd_name);
				request.setAttribute("check", check);
				


	return"/LearningManagementSystem/admin/deleteStudent.jsp";// �빐�떦酉�
}}