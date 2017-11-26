<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="admin.Service.Submit_checkService"%>
<%@ page import="classplan.DTO.ClassplanModifyDataBean"%>
<%@ page import="java.util.ArrayList" %>
<%
	String time = request.getParameter("time");
    String num = request.getParameter("num");

    //time+="%";
//String result ="";
 	Submit_checkService checkService = Submit_checkService.getInstance();
 			int count = checkService.getItem(time, num);
 			
 			//request.setAttribute("count", count);
 			
	//ClassplanModifyDataBean data = checkService.getItem(CP_TIME, CR_NUM);
	String result = "";
	result += "<CP_TIME>"+count+"</CP_TIME>";
	//result += "<CP_test>"+time+num+"</CP_test>";

%>
<?xml version='1.0' encoding='UTF-8'?>
<select_check>
<time><%=result%></time>
</select_check>



