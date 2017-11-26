package action.Professor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import professor.Service.Pre_modifyService;

public class PreModifyProAction implements CommandAction {// 글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		//HttpSession session = request.getSession(false);
		//int sd_num = Integer.parseInt((String)session.getAttribute("sd_num"));
		
		
		String pf_num = request.getParameter("username"); // ex)201101001
		//String sd_num = request.getParameter("username");
		String pf_passwd = request.getParameter("password"); // 입력된 비밀번호 (201101001)

		String result = "";
	
			int check = Pre_modifyService.getInstance().professorCheck(pf_num, pf_passwd);

			if (check == 1) {
				//session.setAttribute("member",sd_num);
				request.setAttribute("pf_num", pf_num);
				request.setAttribute("result_link", "/LearningManagementSystem/professor/modifyProfessor.do");
			} else if (check == 0) {
				result = "비밀번호가 맞지 않습니다.";
			} else {
				result = "아이디가 맞지 않습니다.";}
				request.setAttribute("result", result);
				
		return "/LearningManagementSystem/professor/PreModifyProProfessor.jsp";
		}
	}


