<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="professor.Service.SelectSubjectNumService"%>
<%@ page import="subject.DTO.SubjectDataBean"%>
<%@ page import="java.util.ArrayList" %>
<%
	String select_value = request.getParameter("select_value");

	SubjectDataBean item = null;
	if(select_value.equals("선택")){}
	else{
		item = SelectSubjectNumService.getInstance().getItem(select_value);//학과로 검색
	}
	
	String result = "";

	result += "<select_num>"+item.getS_num()+"</select_num>";
	result += "<select_cp_division>"+item.getS_cp_division()+"</select_cp_division>";
	result += "<select_cp_credits>"+item.getS_cp_credits()+"</select_cp_credits>";
	
	
%>
<?xml version='1.0' encoding='UTF-8'?>
<select_check>
<%=result%>
</select_check>



