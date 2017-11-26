
package action.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.ProfessorDataBean;
import admin.Service.SelectProfessorPfnumService;

public class RegisterProfessorActionForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		// request.setCharacterEncoding("UTF-8");
		String select_option = request.getParameter("select_option");
		String d_num = request.getParameter("d_num");

		request.setAttribute("select_option", select_option);
		request.setAttribute("d_num", d_num);

		String pf_passwd = request.getParameter("pf_passwd");
		String pf_name = request.getParameter("pf_name");
		String pf_jumin = request.getParameter("pf_jumin");

		if (pf_passwd == null) {
			pf_passwd = "";
		}
		if (pf_name == null) {
			pf_name = "";
		}
		if (pf_jumin == null) {
			pf_jumin = "";
		}

		ProfessorDataBean data = SelectProfessorPfnumService.getInstance().getItem(d_num);

		String result = "";

		if (data.getPf_num() != null) {
			if (!data.getPf_num().equals("")) {
				String sub_pf_num = data.getPf_num().substring(2);
				int I_sub_pf_num = Integer.parseInt(sub_pf_num);
				I_sub_pf_num++;
				if (I_sub_pf_num < 10) {
					result = data.getPf_num().substring(0, 2);
					result += "0" + I_sub_pf_num;
				} else {
					result = data.getPf_num().substring(0, 2);
					result += I_sub_pf_num;
				}
			} else {
				d_num += "01";
				result = d_num;
			}
		} else {
			d_num += "01";
			result = d_num;
		}
		request.setAttribute("pf_num", result);
		return "/LearningManagementSystem/admin/RegisterProfessor.jsp";
	}

}
