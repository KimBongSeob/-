<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>
<body>

<c:if test="${count > 0}">
		<script>
			alert("수강신청 되었습니다.");
			document.location.href='/LMS/LearningManagementSystem/Classrequest.do';
		</script>
	</c:if>
	<c:if test="${count == -2}">
		<script>
		alert("이미 수강신청하신 과목은 신청하실 수 없습니다.");
		document.location.href='/LMS/LearningManagementSystem/Classrequest.do';
		</script>
	</c:if>
	<c:if test="${count == -1}">
		<script>
			alert("인원이 초과하였습니다.");
			document.location.href='/LMS/LearningManagementSystem/Classrequest.do';
		</script>
	</c:if>
</body>
</html>