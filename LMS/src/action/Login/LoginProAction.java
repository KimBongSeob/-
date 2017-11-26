package action.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import student.Service.LoginService;

public class LoginProAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		HttpSession session = request.getSession(false);

		int job = Integer.parseInt(request.getParameter("job"));

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String result = "";

		if (job == 1) { // 학생 로그인일 경우
			int check1 = LoginService.getInstance().studentCheck(username, password);

			if (check1 == 1) {
				session.setAttribute("member",username);
				request.setAttribute("result_link", "/LearningManagementSystem/student.do");
			} else if (check1 == 0) {
				result = "비밀번호가 맞지 않습니다.";
			} else {
				result = "아이디가 맞지 않습니다.";
			}
		}
		if (job == 2) { // 교수 로그인일 경우

			int check2 = LoginService.getInstance().professorCheck(username, password);

			if (check2 == 1) {
				session.setAttribute("member", username);
				request.setAttribute("result_link", "/LearningManagementSystem/professor.do");
			} else if (check2 == 0) {
				result = "비밀번호가 맞지 않습니다.";

			} else {
				result = "아이디가 맞지 않습니다.";

			}
		}
		if (job == 3) { // 교직원 로그인일 경우
			if (username.equals("admin") && password.equals("123")) {
				session.setAttribute("member", username);
				request.setAttribute("result_link", "/LearningManagementSystem/admin.do");
			} else {
				result = "아이디나 비밀번호가 일치하지 않습니다.";
			}
		}

		//
		request.setAttribute("result", result);
		return "/LearningManagementSystem/loginPro.jsp";// 해당 뷰정보 리턴 -
														// WebContent-하위경로부터!!

		// 호출했던 ControllerUsingURI
	}
}
