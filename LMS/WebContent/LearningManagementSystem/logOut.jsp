<%@ page contentType="text/html; charset=utf-8" %>
<%
session.invalidate(); // 세션 종료
response.sendRedirect("/LMS/LearningManagementSystem/login.jsp"); // 메인 화면으로 이동
%>