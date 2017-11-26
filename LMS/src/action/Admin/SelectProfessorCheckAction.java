package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.ProfessorDataBean;
import admin.DTO.RegisterDataBean;
import admin.Service.SelectProfessorListCheckService;



public class SelectProfessorCheckAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {   
    	
    	String pf_num = request.getParameter("pf_num");
    	String select_option = request.getParameter("select_option");
    	request.setAttribute("select_option", select_option);
    			List<ProfessorDataBean> ProfessorList = SelectProfessorListCheckService.getInstance().getItemList(pf_num);		
		request.setAttribute("ProfessorList", ProfessorList);
		
		List<ProfessorDataBean> Registerlist = SelectProfessorListCheckService.getInstance().getItemList(pf_num);
		request.setAttribute("Registerlist", Registerlist);
		request.setAttribute("RegisterlistSize", Registerlist.size());


        return "/LearningManagementSystem/admin/SelectProfessorListCheck.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}

