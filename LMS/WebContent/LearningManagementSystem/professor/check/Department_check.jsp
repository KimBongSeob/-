<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="professor.Service.SelectSubjectNameService"%>
<%@ page import="professor.Service.SelectSubjectRefinementNameService"%>
<%@ page import="subject.DTO.SubjectDataBean"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
	String select_value = request.getParameter("select_value");

	String id = (String) session.getAttribute("member");
	List<SubjectDataBean> itemList = new ArrayList<SubjectDataBean>();
	if(select_value.equals("선택")){}
	else if(select_value.equals("00")){
		itemList = SelectSubjectRefinementNameService.getInstance().getItemList("00");
	}else{
		itemList = SelectSubjectNameService.getInstance().getItemList(id);
	}
	
	
	String result = "<item>"+"<select_data>선택</select_data>"+"<select_data_num>선택</select_data_num>"+"</item>";
	for(int i=0;i<itemList.size();i++){
		SubjectDataBean item = itemList.get(i);
		result += "<item>";
		result += "<select_data>"+item.getS_name()+"</select_data>";
		result += "<select_data_num>"+item.getS_num()+"</select_data_num>";
		result += "</item>";
	}

	
%>
<?xml version='1.0' encoding='UTF-8'?>
<select_check>
<%=result%>
</select_check>



