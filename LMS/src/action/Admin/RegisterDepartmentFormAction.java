package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ProfessorDataBean;
import admin.Service.RegisterProfessorService;
import admin.Service.SelectDepartmentMaxService;
import admin.Service.SelectProfessorListService;

public class RegisterDepartmentFormAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		DepartmentDataBean d_num = SelectDepartmentMaxService.getInstance().getItem();

		String result = "";
		if (d_num.getD_num() != null) {
			if (!d_num.getD_num().equals("")) {
				String sub_d_num = d_num.getD_num();
				int I_sub_d_num = Integer.parseInt(sub_d_num);
				I_sub_d_num++;
				if (I_sub_d_num < 10) {
					result += "0" + I_sub_d_num;
				} else {
					result += I_sub_d_num;
				}
			} else {
				result = "00";
			}
		} else {
			result = "00";
		}

		request.setAttribute("d_num", result);
		return "/LearningManagementSystem/admin/RegisterDepartment.jsp";// 해당
																		// 뷰정보
																		// 리턴 -
																		// WebContent-하위경로부터!!
	}
}
