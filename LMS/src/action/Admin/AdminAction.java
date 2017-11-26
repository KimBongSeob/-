package action.Admin;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import board.DAO.LMSDBBean;
import noticeboard.DAO.NoticeboardDao;



public class AdminAction implements CommandAction {


	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("member");// 로그인 정보 가져오기.
		
		request.setAttribute("id_size",id.length());
		
		String pageNum = request.getParameter("pageNum");// �럹�씠吏� 踰덊샇

		if (pageNum == null) {
			pageNum = "1";
		}
		
		String search = request.getParameter("search");
		int searchn = 0;
		
		if(search == null){
			search = "";
		}else{
			searchn = Integer.parseInt(request.getParameter("searchn"));
		}
		
		int pageSize = 5;// �븳 �럹�씠吏��쓽 湲��쓽 媛쒖닔
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;// �븳 �럹�씠吏��쓽 �떆�옉湲� 踰덊샇
		int endRow = currentPage * pageSize;// �븳 �럹�씠吏��쓽 留덉�留� 湲�踰덊샇
		int count = 0;
		int number = 0;

		List articleList = null;
		NoticeboardDao dbPro = NoticeboardDao.getInstance();// DB�뿰�룞
		
		
		if(search.equals("") || search == null)
			count = dbPro.getArticleCount();// �쟾泥� 湲��쓽 �닔
		else
			count = dbPro.getArticleCount(searchn,search);

		if (count > 0) {
			if(search.equals("") || search == null){
			articleList = dbPro.getArticles(startRow, endRow);// �쁽�옱 �럹�씠吏��뿉 �빐�떦�븯�뒗 湲� 紐⑸줉
		    }else{
			articleList = dbPro.getArticles(startRow, endRow, searchn, search);
		    }
		}else {
			articleList = Collections.EMPTY_LIST;
		}
		

		number = count - (currentPage - 1) * pageSize;// 湲�紐⑸줉�뿉 �몴�떆�븷 湲�踰덊샇
		// �빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦 view�뿉�꽌 �궗�슜�븷 �뜲�씠�꽣�뒗 �쟾遺� request/session�뿉 ���옣
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
							//c:foreach items=
		
		///////////////////
		

		LMSDBBean BoardDao = LMSDBBean.getInstance();// DB연동
		
		List articleList2 = null;
		if(search.equals("") || search == null)
			count = BoardDao.getArticleCount();// 전체 글의 수
		else
			count = BoardDao.getArticleCount(searchn,search);

		if (count > 0) {
			if(search.equals("") || search == null){
				articleList2 = BoardDao.getArticles(startRow, endRow);// 현재 페이지에 해당하는 글 목록
		    }else{
		    	articleList2 = BoardDao.getArticles(startRow, endRow, searchn, search);
		    }
		}else {
			articleList2 = Collections.EMPTY_LIST;
		}
		
		int number2 = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		
		// 해당 뷰에서 사용할 속성 // view에서 사용할 데이터는 전부 request/session에 저장
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count2", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number2", new Integer(number2));
		request.setAttribute("articleList2", articleList2);
		return "/LearningManagementSystem/admin/index.jsp";// �빐�떦 酉� view�젙蹂� /webcontent �븯�쐞 寃쎈줈遺��꽣 吏��젙�빐以�.
	}
}