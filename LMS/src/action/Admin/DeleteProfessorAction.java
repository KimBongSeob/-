package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ProfessorDataBean;
import admin.Service.DeleteProfessorService;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectProfessorListService;

public class DeleteProfessorAction implements CommandAction {// 湲��궘�젣

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String select_option = request.getParameter("select_option");
		String pf_num = request.getParameter("pf_num");
		String pf_name = request.getParameter("pf_name");
		 DeleteProfessorService  ProfessorService =  DeleteProfessorService.getInstance();
		 int check = ProfessorService.deleteItemList(pf_num);
		 		request.setAttribute("select_option", select_option);
		 		
				request.setAttribute("pf_num", pf_num);
				request.setAttribute("pf_name", pf_name);
				request.setAttribute("check", check);
				


	return"/LearningManagementSystem/admin/deleteProfessor.jsp";// �빐�떦酉�
}}