package action.Admin;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.DTO.RegisterDataBean;
import admin.DTO.ReinstatementDataBean;
import admin.DTO.StudentRegisterDataBean;
import admin.Service.InsertReinstatementService;
import admin.Service.SelectStudentListCheckService;
import admin.Service.SelectStudentListRegisterService;
import admin.Service.UpdateReinstatementService;
import admin.reinstatement.Algorithm;



public class SelectStudentListCheckAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {   
    	
    	int sd_num = Integer.parseInt(request.getParameter("sd_num"));
    	String select_option = request.getParameter("select_option");
    	request.setAttribute("select_option", select_option);
		List<StudentRegisterDataBean> StudentList = SelectStudentListCheckService.getInstance().getItemList(sd_num);		
		request.setAttribute("StudentList", StudentList);
		
		List<RegisterDataBean> Registerlist = SelectStudentListRegisterService.getInstance().getItemList(sd_num);
		request.setAttribute("Registerlist", Registerlist);
		request.setAttribute("RegisterlistSize", Registerlist.size());

		
        return "/LearningManagementSystem/admin/SelectStudentListCheck.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
        
        //호출했던 ControllerUsingURI
    }
}

