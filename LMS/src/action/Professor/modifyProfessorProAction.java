package action.Professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import professor.Service.modifyProfessorInfoService;

public class modifyProfessorProAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(false);
			
			String id = (String) session.getAttribute("member");
			String pf_passwd = request.getParameter("pf_passwd");
			String pf_hpone = request.getParameter("pf_hpone");
			String pf_address = request.getParameter("pf_address");
			String pf_email = request.getParameter("pf_email");


			modifyProfessorInfoService ProfessorInfoService = modifyProfessorInfoService.getInstance();

			ProfessorInfoService.InfoUpdate(id, pf_passwd,pf_hpone,pf_address,pf_email);
			
			//request.setAttribute("count", new Integer(count));
	
	
		return "/LearningManagementSystem/professor/modifyProProfessor.jsp";
		
	}
}