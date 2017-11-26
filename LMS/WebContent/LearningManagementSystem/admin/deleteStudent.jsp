<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><head></head>
<body>
<c:if test ='${check>0}'>
<meta http-equiv="Refresh" content="0;url=/LMS/LearningManagementSystem/AllDepartmentStudent.do?select_option=${select_option}">
</c:if>
</body>
<script>
alert("학생정보가 삭제되었습니다.");
</script>
</html>
