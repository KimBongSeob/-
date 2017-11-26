package action.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin.Service.SumDepartmentService;
import admin.Service.SumProfessorService;
import admin.Service.SumStudentService;
import admin.Service.SumSubjectService;



public class StatisticalChartAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {         
        
		int count = SumDepartmentService.getResult();
		request.setAttribute("count",count);
		
		int count1 = SumProfessorService.getResult();
		request.setAttribute("count1",count1);
		
		int count2 = SumStudentService.getResult();
		request.setAttribute("count2",count2);
		
		int count3 = SumSubjectService.getResult();
		request.setAttribute("count3",count3);
		
		return "/LearningManagementSystem/admin/StatisticalChart.jsp";//해당 뷰정보 리턴 - WebContent-하위경로부터!!
	}
}
