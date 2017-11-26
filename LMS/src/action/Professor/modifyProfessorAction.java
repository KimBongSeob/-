package action.Professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import professor.DTO.ProfessorDataBean;
import professor.Service.modifyProfessorService;

public class modifyProfessorAction implements CommandAction {//글목록 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");
		


		ProfessorDataBean ProfessorModifyData = modifyProfessorService.getInstance().getItem(id);
		request.setAttribute("ProfessorModifyData", ProfessorModifyData);
		return "/LearningManagementSystem/professor/modifyProfessor.jsp";
	}
}
