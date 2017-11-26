package action.commonProfessor;
import action.CommandAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DeleteFormAction implements CommandAction {// 글삭제 폼

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		// 해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));

		return "/LearningManagementSystem/professor/commonProfessor/MVC/deleteForm.jsp";// 해당뷰
	}
}