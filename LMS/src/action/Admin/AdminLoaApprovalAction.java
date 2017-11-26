package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ReinstatementDataBean;
import admin.Service.SelectAllDepartmentService;
import admin.Service.SelectReinstatementService;

public class AdminLoaApprovalAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// request.setCharacterEncoding("UTF-8");
		SelectAllDepartmentService AllDepartmentService = SelectAllDepartmentService.getInstance();
		List<DepartmentDataBean> DepartmentList = AllDepartmentService.getItemList();
		request.setAttribute("DepartmentList", DepartmentList);
		// select_option=${select_option}&sd_num=${list.sd_num}&re_loa_date=${list.re_loa_date}

		//////////////
		int check = Integer.parseInt(request.getParameter("check"));
		
		String sd_num = request.getParameter("sd_num");
		
		request.setAttribute("sd_num", sd_num);
		if (check == 1) {
			String re_loa_date = request.getParameter("re_loa_date");
			request.setAttribute("re_loa_date", re_loa_date);
			request.setAttribute("check", check);
			
		} else if (check == 2) {
			String re_start_date = request.getParameter("re_start_date");
			request.setAttribute("re_start_date", re_start_date);
			request.setAttribute("check", check);
		}

		if (check == 1) {
			String select_option = request.getParameter("select_option");
			request.setAttribute("select_option", select_option);
			if (!select_option.equals("")) {
				List<ReinstatementDataBean> ReinstatementList = SelectReinstatementService.getInstance()
						.getItemList(select_option);

				request.setAttribute("ReinstatementList", ReinstatementList);
				request.setAttribute("DepartmentList", DepartmentList);

			}
		}else if (check == 2) {
			String select_option2 = request.getParameter("select_option2");
			request.setAttribute("select_option2", select_option2);
			if (!select_option2.equals("")) {
				 List<ReinstatementDataBean> ReinstatementList_B =
				 SelectReinstatementService.getInstance().getItemList_B(select_option2);

				request.setAttribute("ReinstatementList_B", ReinstatementList_B);
				request.setAttribute("DepartmentList", DepartmentList);

			}
			
			
		}

		return "/LearningManagementSystem/admin/AdminLoaApproval.jsp";// 해당 뷰정보
																		// 리턴 -
																		// WebContent-하위경로부터!!
	}
}
