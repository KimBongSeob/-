<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test='${count > 0}'>
		<script type="text/javascript">
			alert("담은 과목에 추가되었습니다.");
			document.location.href = '/LMS/LearningManagementSystem/Classrequest.do?select=3';
		</script>
	</c:if>
	<c:if test='${count == -1}'>
		<script type="text/javascript">
			alert("이미 담은 과목 입니다.");
			document.location.href = '/LMS/LearningManagementSystem/Classrequest.do?select=3';
		</script>
	</c:if>
</body>
</html>