<%@ page pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="board.DTO.Mvc_BoardDataBean"%>
<%@ page import="board.DAO.LMSDBBean"%>
<%@ page import="pds.file.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>


<%
	int num = Integer.parseInt(request.getParameter("num"));
	try {
		LMSDBBean dbPro = LMSDBBean.getInstance();// DB처리
		Mvc_BoardDataBean article = dbPro.getArticle(num);// 해당 글번호에 대한 해당 레코드

		// 헤더 정보 설정 부분은  이 상태로 고정하여 사용한다.
		// 응답 헤더 다운로드로 설정
		response.reset();

		String fileName = new String(article.getFilename().getBytes("utf-8"), "iso-8859-1"); // byte배열로 받아옴.
		response.setContentType("application/octet-stream"); // 화면은 그대로 다운로드가 진행됨.
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // 헤더정보의 이름, 헤더정보
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentLength((int) article.getFilesize());
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		FileDownloadHelper.copy(article.getRealpath(), response.getOutputStream());

		response.getOutputStream().close();
	} catch (PdsItemNotFoundException ex) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
%>