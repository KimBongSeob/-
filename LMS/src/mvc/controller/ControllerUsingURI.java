package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class ControllerUsingURI extends HttpServlet {
	
	//명령어와 처리클래스가 매핑되어 있는 properties 파일을 읽어서 Map객체인 commandMap에 저장
    private Map commandMap = new HashMap(); //명령어와 명령어 처리 클래스를 쌍으로 저장, Map조상 HashMap자손클래스-일반적으로 조상타입으로 변수를선언한다-> 자손타입으로 여러객체를 들고올수있으니
    
    //명령어와 처리클래스가 매핑되어 있는 properties 파일은 Command.properties파일
    public void init(ServletConfig config) throws ServletException {
        String props = config.getInitParameter("propertyConfig");//web.xml에서 propertyConfig에 해당하는 init-param 의 값을 읽어옴//아직까진 문자열타입
        
        //properties파일(설정파일)의 경로        
        Properties pr = new Properties();//명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성
        
        
        FileInputStream f = null;
        try {
        	String path = config.getServletContext().getRealPath(props);
            f = new FileInputStream(path); //절대경로넣어줌.//Command.properties파일의 내용을 읽어옴
            pr.load(f);//Command.properties파일의 정보를  Properties객체에 저장
        } catch (IOException e) {
            throw new ServletException(e);
        } finally {
            if (f != null) try { f.close(); } catch(IOException ex) {}
        }
        //ketSet:key값 모아서 iterator로 한줄씩 열거
        Iterator keyIter = pr.keySet().iterator();//Iterator객체는 Enumeration객체를 확장시킨 개념의 객체, iterator로 컬렉션에 저장되어 있는 요소들을 읽어온다.
        while(keyIter.hasNext()) { //객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 저장된 객체에 접근
            String command = (String)keyIter.next(); //.next():객체의 요소(v값) 리턴.
            String className = pr.getProperty(command);
            try {
                Class commandClass = Class.forName(className);//해당 문자열을 클래스로 만든다.
                Object commandInstance = commandClass.newInstance();//해당클래스의 객체를 생성
                commandMap.put(command, commandInstance);// Map객체인 commandMap에 객체 저장
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }
    public void doGet(//get방식의 서비스 메소드 : 서블렛의 url패턴이 들어왔을때 실행 ex.<url-pattern>*.do</url-pattern> =====>맨첨에index.jsp의 list.do실행
        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response); //요청을 분석하고 맞는 모델을 찾아준후 포워딩까지 시켜준다.
    }

    protected void doPost(//post방식의 서비스 메소드
        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response); 
    }

    //시용자의 요청을 분석해서 해당 작업을 처리
    private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String view = null;
    CommandAction com=null;//요청에 맞는 model객체를 저장할 변수 선언
    
    try {
            String command = request.getRequestURI(); //웹브라우저가 요청한 URI(path)경로를 구한다. "MVC_board/MVC/list.do"
            if (command.indexOf(request.getContextPath()) == 0) { //MVC_board와 0번 인덱가 같다면?
                command = command.substring(request.getContextPath().length()); //그인덱스 다음부터 끝까지 잘라서 가져옴 "/MVC/list.do" ==> properties파일에 지정한 uri값과 똑같아야 한다.
            }
            com = (CommandAction)commandMap.get(command); //v:ListAction객체를 갖고오고 
            view = com.requestPro(request, response); //메서드실행-> 뷰에 경로 저장
        } catch(Throwable e) {
            throw new ServletException(e);
        }
        RequestDispatcher dispatcher =request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
