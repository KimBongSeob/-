package action.commonStudent;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import action.CommandAction;
import board.DAO.LMSDBBean;
import board.DTO.Mvc_BoardDataBean;
import pds.file.FileSaveHelper;

public class WriteProAction implements CommandAction {// 입력된 글 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		
			
		Mvc_BoardDataBean article = new Mvc_BoardDataBean();
		HttpSession session = request.getSession(false);
		String member = (String)session.getAttribute("member");
		article.setWriter(member);
		////////////////////
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // SC_BAD_REQUEST : 강제로 400 에러 발생시킴 
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> items = upload.parseRequest(request); 
		// 파일 업로드 요청 처리를 받아 크기에 따라서 임시 디렉토리에 메모리나 임시파일로 업로드 시켜놓고, 모든 파라미터는 file item객체로 저장하고 리스트에 저장한다.

		

		Iterator<FileItem> iter = items.iterator(); // 순차적으로 객체를 꺼내서 탐색
		while (iter.hasNext()) {
			FileItem item = iter.next();
			if (item.isFormField()) { // 업로드된 파일이 파일형태인지 다른 폼형태인지 체크. 업로드된 파일이 다른 폼형태일 경우
				String name = item.getFieldName(); // FileItem객체의 파라미터 이름 꺼낸다
				if(name.equals("subject")){
					String value = item.getString();
					value = new String(value.getBytes("8859_1"),"utf-8");
					article.setSubject(value);
				}else if(name.equals("filename")){
					String value = item.getString();
					article.setFilename(value);
				}else if(name.equals("content")){
					String value = item.getString();
					value = new String(value.getBytes("8859_1"),"utf-8");
					article.setContent(value);
				}
				else if(name.equals("passwd")){
					String value = item.getString();
					article.setPasswd(value);
				}else if(name.equals("num")){
					String value = item.getString();
					article.setNum(Integer.parseInt(value));
				}
				else if(name.equals("ref")){
					String value = item.getString();
					article.setRef(Integer.parseInt(value));
				}else if(name.equals("re_step")){
					String value = item.getString();
					article.setRe_step(Integer.parseInt(value));
				}else if(name.equals("re_level")){
					String value = item.getString();
					article.setRe_level(Integer.parseInt(value));
				}
			} else { // 업로드된 파일이 파일 형태일 경우
				String name = item.getFieldName();
				if (name.equals("filename")) {
					String realPath = FileSaveHelper.save("c:\\pds", item.getInputStream()); 
					// 파일을 저장할 경로와 파일의 내용을 읽어올수 있는 InputStream객체를 들고 save()메소드를 호출한다.
					article.setFilename(item.getName()); // 파일의 실제 이름
					article.setFilesize(item.getSize()); // 파일의 실제 사이즈
					article.setRealpath(realPath); // 파일의 실제 경로
				}
			}
		}		
	// DB에 저장하는 작업insertArticle(Mvc_BoardDataBean article)
//	   Mvc_BoardDataBean article = new Mvc_BoardDataBean();// 데이터처리 빈
		
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		LMSDBBean dbPro = LMSDBBean.getInstance();// DB처리
		dbPro.insertArticle(article);

		return "/LearningManagementSystem/student/commonStudent/MVC/writePro.jsp";
	}
}



