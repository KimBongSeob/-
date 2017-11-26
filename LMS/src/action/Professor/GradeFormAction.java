package action.Professor;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import professor.DAO.Professor_All_DataBean;
import professor.Service.GradeService;
import professor.Service.ecaluationService;

public class GradeFormAction implements CommandAction {// 글 입력 폼 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
	       HttpSession session = request.getSession(false);
	       String id = (String) session.getAttribute("member");//로그인 정보 가져오기.

		String select_option = request.getParameter("select_option");

		if (select_option == null) {
			select_option = "";
			List<Professor_All_DataBean> getYearSemester = ecaluationService.getInstance()
					.getItemList(id);
			int size = 0;
			if( getYearSemester != null){
				size = getYearSemester.size();
			}

			request.setAttribute("getYearSemester", getYearSemester);
			request.setAttribute("size", size);

		}
		if (!select_option.equals("")) {
			

				List<Professor_All_DataBean> getYearSemester = ecaluationService.getInstance()
						.getItemList(id);
				
				
				StringTokenizer token = new StringTokenizer(select_option, ",");

				List list = GradeService.getInstance().getItemList(id, token.nextToken(), token.nextToken());

				int size = getYearSemester.size();
				
				request.setAttribute("size", size);
				request.setAttribute("list", list);
				request.setAttribute("getYearSemester", getYearSemester);
			
		}else{
			List<Professor_All_DataBean> getYearSemester = ecaluationService.getInstance()
					.getItemList(id);
			int size = 0;
			if( getYearSemester != null){
				size = getYearSemester.size();
			}

			request.setAttribute("getYearSemester", getYearSemester);
			request.setAttribute("size", size);

		}
		return "/LearningManagementSystem/professor/gradeForm.jsp";// 해당 뷰
	}
}
