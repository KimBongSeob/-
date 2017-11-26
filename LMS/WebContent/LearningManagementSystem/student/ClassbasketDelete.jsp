<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>
<body>
<c:if test='${count > 0}'>
<script type="text/javascript">
alert("삭제되었습니다.");
document.location.href='/LMS/LearningManagementSystem/Classrequest.do';
</script>
</c:if> 
</body>
</html>