package action.Student;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.DTO.RegisterDataBean;
import student.DTO.ReinstatementDataBean;
import student.DTO.StudentRegisterDataBean;
import student.Service.InsertReinstatementService;
import student.Service.SelectRegisterService;
import student.Service.SelectStudentRegisterService;
import student.Service.UpdateReinstatementService;
import student.reinstatement.Algorithm;

public class RegisterAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		int id = Integer.parseInt((String) session.getAttribute("member"));
		List<RegisterDataBean> Registerlist = SelectRegisterService.getInstance().getItem(id);
		
		request.setAttribute("RegisterlistSize", Registerlist.size());
		request.setAttribute("Registerlist", Registerlist);

		String Register_option1 = request.getParameter("Register_option1");
		String Register_option2 = request.getParameter("Register_option_details");
		String loa_date = request.getParameter("loa_date");
		String year_end = request.getParameter("year_end");
		String semester_end = request.getParameter("semester_end");

		ReinstatementDataBean item = new ReinstatementDataBean();

		//////////////////////////////

		if (Register_option1 == null) {
			Register_option1 = "";
		}

		if (Register_option2 == null) {
			Register_option2 = "";
		}
		if (loa_date == null) {
			loa_date = "";
		}
		if (year_end == null) {
			year_end = "";
		}
		if (semester_end == null) {
			semester_end = "";
		}
		if (!Register_option1.equals("")) {
			if (Register_option1.equals("휴학")) {
				if (Register_option2.equals("선택")) {

				} else {
					item = Algorithm.setItem(Algorithm.getCurrent_year(),Algorithm.getCurrent_semester(),
							Integer.parseInt(Register_option2));
					 int insert_check = InsertReinstatementService.getInstance().addItem(id, item.getLoa_end_year(),item.getLoa_end_semester());
					 if(insert_check == 1){
						 request.setAttribute("update_check", insert_check);
						 request.setAttribute("end_year", item.getLoa_end_year());
						 request.setAttribute("end_semester", item.getLoa_end_semester());
					 }
				}
			} else if (Register_option1.equals("복학")) {
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date_util = sdf.parse(loa_date);
				Date date = new Date(date_util.getTime());
				int update_check = UpdateReinstatementService.getInstance().setLoa(id, date);
				if (update_check == 1) {
					request.setAttribute("update_check", update_check);
				}

			} else if (Register_option1.equals("휴학연장")) {
				if (Register_option2.equals("선택")) {
				} else {
					SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date_util = sdf.parse(loa_date);
					Date date = new Date(date_util.getTime());

					item = Algorithm.setItem(Integer.parseInt(year_end),Integer.parseInt(semester_end),
							Integer.parseInt(Register_option2));
					
					int update_check = UpdateReinstatementService.getInstance().setLoaExtension(id, date,
							item.getLoa_end_year(), item.getLoa_end_semester());
					if (update_check == 1) {
						request.setAttribute("end_year", item.getLoa_end_year());
						request.setAttribute("end_semester", item.getLoa_end_semester());
						request.setAttribute("update_check", update_check);
					}
				}

			}
			
		}
		StudentRegisterDataBean StudentRegisterData = SelectStudentRegisterService.getInstance().getItem(id);
		request.setAttribute("StudentRegisterData", StudentRegisterData);
		return "/LearningManagementSystem/student/Register.jsp";
	}
}
