<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String result = (String)request.getAttribute("result");
String result_link = (String)request.getAttribute("result_link");
%>

<%if(!result.equals("")){
out.println("<script>alert('"+result+ "');</script>");
out.println("<script>document.location.href='/LMS/LearningManagementSystem/PreModify.do';</script>");
}else{
	response.sendRedirect("/LMS"+result_link);
}%>