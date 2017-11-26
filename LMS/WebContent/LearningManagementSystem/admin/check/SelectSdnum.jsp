<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="admin.Service.SelectStudentSdnumService"%>
<%@ page import="student.DTO.StudentDataBean"%>
<%
	String sd_num = request.getParameter("sdNum");
	StudentDataBean data = SelectStudentSdnumService.getInstance().getItem(sd_num);
 			
 			//request.setAttribute("count", count);
 			
	//ClassplanModifyDataBean data = checkService.getItem(CP_TIME, CR_NUM);
	String result = "";
	if(data.getSd_num() != 0){
		result = ""+data.getSd_num();
	}else{
		sd_num+="001";
		result=sd_num;
	}
	//result += "<CP_test>"+time+num+"</CP_test>";

%>
<?xml version='1.0' encoding='UTF-8'?>
<select_check>
<result><%=result%></result>
</select_check>




