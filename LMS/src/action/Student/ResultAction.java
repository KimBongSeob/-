package action.Student;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.DTO.ResultDataBean;
import student.Service.StudentResultService;

public class ResultAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		StudentResultService studentResultService = StudentResultService.getInstance();
		HttpSession session = request.getSession(false);
		int id = Integer.parseInt((String) session.getAttribute("member"));

		String select_option = request.getParameter("select_option");
		/* int size = 0; */

		List<ResultDataBean> studentResultAll = studentResultService.studentResultAll(id);

		/* size = studentResultAll.size(); */

		request.setAttribute("select_option", select_option);
		/* request.setAttribute("size", size); */
		request.setAttribute("studentResultAll", studentResultAll);

		if (select_option == null) {// 맨 처음

			List<ResultDataBean> yearlist = studentResultService.yearlist(id);

			/* size = yearlist.size(); */

			request.setAttribute("select_option", select_option);
			/* request.setAttribute("size", size); */
			request.setAttribute("yearlist", yearlist);
		} else {
			if (!select_option.equals("")) {
				List<ResultDataBean> yearlist = studentResultService.yearlist(id);

				/* size = yearlist.size(); */

				request.setAttribute("select_option", select_option);
				/* request.setAttribute("size", size); */
				request.setAttribute("yearlist", yearlist);

				StringTokenizer token = new StringTokenizer(select_option, ",");
				List<ResultDataBean> studentResult = studentResultService.studentResult(id, token.nextToken(),
						token.nextToken());
				/* size = studentResult.size(); */
				request.setAttribute("select_option", select_option);
				/* request.setAttribute("size", size); */
				request.setAttribute("studentResult", studentResult);
			}else{
				List<ResultDataBean> yearlist = studentResultService.yearlist(id);

				/* size = yearlist.size(); */

				request.setAttribute("select_option", select_option);
				/* request.setAttribute("size", size); */
				request.setAttribute("yearlist", yearlist);
			}

		}

		return "/LearningManagementSystem/student/result.jsp";// 해당 뷰정보 리턴 -
																// WebContent-하위경로부터!!

		// 호출했던 ControllerUsingURI
	}
}
