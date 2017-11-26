<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="admin.Service.selectClassplanModifyService"%>
<%@ page import="classplan.DTO.ClassplanModifyDataBean"%>
<%@ page import="java.util.ArrayList" %>
<%
	String id = request.getParameter("id");

//String result ="";
 	ClassplanModifyDataBean data = selectClassplanModifyService.getInstance().getItem(id);
	
	String result = "";
	result += "<CP_NUM>"+data.getCp_num()+"</CP_NUM>";
	result += "<CP_DATE>"+data.getCp_date()+"</CP_DATE>";
	result += "<CP_YEAR>"+data.getCp_year()+"</CP_YEAR>";
	result += "<CP_SEMESTER>"+data.getCp_semester()+"</CP_SEMESTER>";
	result += "<S_NAME>"+data.getS_name()+"</S_NAME>";
	result += "<S_NUM>"+data.getS_num()+"</S_NUM>";
	result += "<S_CP_CREDITS>"+data.getS_cp_credits()+"</S_CP_CREDITS>";
	result += "<CP_TIME>"+data.getCp_time()+"</CP_TIME>";
	result += "<D_NUM>"+data.getD_num()+"</D_NUM>";
	result += "<D_NAME>"+data.getD_name()+"</D_NAME>";
	result += "<CR_NUM>"+data.getCr_num()+"</CR_NUM>";
	result += "<PF_NUM>"+data.getPf_num()+"</PF_NUM>";
	result += "<PF_NAME>"+data.getPf_name()+"</PF_NAME>";
	result += "<PF_EMAIL>"+data.getPf_email()+"</PF_EMAIL>";
	result += "<S_CP_DIVISION>"+data.getS_cp_division()+"</S_CP_DIVISION>";
	result += "<CP_MAX_NO>"+data.getCp_max_no()+"</CP_MAX_NO>";
	result += "<CP_OUTLINE>"+data.getCp_outline()+"</CP_OUTLINE>";
	result += "<CP_TEXTBOOK>"+data.getCp_textbook()+"</CP_TEXTBOOK>";
	result += "<CP_SUB_TEXTBOOK>"+data.getCp_sub_textbook()+"</CP_SUB_TEXTBOOK>";
	result += "<CP_VALUATION>"+data.getCp_valuation()+"</CP_VALUATION>"; 
%>
<?xml version='1.0' encoding='UTF-8'?>
<select_check><%=result%></select_check>



