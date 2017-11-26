package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청 파라미터로 명령어를 전달하는 방식의 슈퍼 인터페이스
//매개변수로 받아온것 request에 저장 --> JSP(뷰)에서 이용가능 --> 뷰정보 리턴
public interface CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable;
}
