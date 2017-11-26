package action.Admin;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ReinstatementDataBean;
import admin.DTO.SubspecialtyDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectReinstatementService;
import admin.Service.SelectSubspecialtyBfService;
import admin.Service.UpdateSubspecialtyService;
import admin.Service.updateLoaApprovalService;


public class AdminSpecialtyProAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		
		String sd_num = request.getParameter("sd_num");
		String sp_no = request.getParameter("sp_no");
		String d_sub_num = request.getParameter("d_sub_num");
		int check = Integer.parseInt(request.getParameter("check"));

		
		if (check == 1) {
			String select_option = request.getParameter("select_option");
			int count = UpdateSubspecialtyService.getInstance().setItem(Integer.parseInt(sd_num), Integer.parseInt(sp_no),d_sub_num);
			request.setAttribute("count", count);
			request.setAttribute("select_option", select_option);
		}else if (check == 2) {
			String select_option2 = request.getParameter("select_option2");
			int count = UpdateSubspecialtyService.getInstance().setItem_B(Integer.parseInt(sd_num), Integer.parseInt(sp_no),d_sub_num);
			request.setAttribute("count", count);
			request.setAttribute("select_option2", select_option2);
		}
		

		
		///////////LearningManagementSystem/AdminSpecialtyPro.do
		return "/LearningManagementSystem/admin/AdminSpecialtyPro.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
