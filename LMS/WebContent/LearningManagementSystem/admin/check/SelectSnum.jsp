<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="admin.Service.SelectSubjectMaxService"%>
<%@ page import="admin.DTO.SubjectDataBean"%>
<%
	String s_num = request.getParameter("s_num");
	SubjectDataBean data = SelectSubjectMaxService.getInstance().getItem(s_num);
 			
 			//request.setAttribute("count", count);
 			
	//ClassplanModifyDataBean data = checkService.getItem(CP_TIME, CR_NUM);
	String result = "";
	if(data == null){
		result = s_num+"001";
	}else{
		String sub = data.getS_num().substring(2);
		int s_int = Integer.parseInt(sub);
		s_int++;
		String suffix = String.format("%03d", s_int); 
		result = data.getS_num().substring(0,2) + suffix;
	}
	//result += "<CP_test>"+time+num+"</CP_test>";

%>
<?xml version='1.0' encoding='UTF-8'?>
<select_check>
<result><%=result%></result>
</select_check>