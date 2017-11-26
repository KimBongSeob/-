package action.commonProfessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;


public class LoginAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {          
        return "/LearningManagementSystem/login.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}


	