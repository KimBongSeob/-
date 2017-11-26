package action.Admin;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.updateLoaApprovalService;

public class AdminLoaApprovalProAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// select_option=${select_option}&sd_num=${list.sd_num}&re_loa_date=${list.re_loa_date}
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		
		String sd_num = request.getParameter("sd_num");
		
		String src_value = request.getParameter("src_value");
		int check = Integer.parseInt(request.getParameter("check"));

		
		if (check == 1) {
			String select_option = request.getParameter("select_option");
			String re_loa_date = request.getParameter("re_loa_date");
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date_util = sdf.parse(re_loa_date);
			Date date = new Date(date_util.getTime());
			
			int count = updateLoaApprovalService.getInstance().setItem(Integer.parseInt(sd_num), date, date, src_value);
			request.setAttribute("count", count);
			request.setAttribute("select_option", select_option);
		}else if (check == 2) {
			String select_option2 = request.getParameter("select_option2");
			String re_start_date = request.getParameter("re_start_date");
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date_util = sdf.parse(re_start_date);
			Date date = new Date(date_util.getTime());
			
			int count = updateLoaApprovalService.getInstance().setItem_B(Integer.parseInt(sd_num), date, date, src_value);
			request.setAttribute("count", count);
			request.setAttribute("select_option2", select_option2);
		}

		// 복학일 때 처리 해야됨
		return "/LearningManagementSystem/admin/AdminLoaApprovalPro.jsp";// 해당
																			// 뷰정보
																			// 리턴
																			// -
																			// WebContent-하위경로부터!!
	}
}