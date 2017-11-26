<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.sendRedirect("/LMS/professor/noticeboard/list.do"); //get방식 //post는 method에 지정했을 경우만
	%>
	<!-- /부터 시작하면 첫번째 경로가 됨.프로젝트 이름 
	 	./로 시작하면 현재경로
	 	../로 시작하면 상위폴더 -->
</body>
</html>