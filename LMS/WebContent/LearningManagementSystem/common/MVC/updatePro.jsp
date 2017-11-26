<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${check==1}">
	<meta http-equiv="Refresh"
		content="0;url=/LMS/LearningManagementSystem/common/MVC/list.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">
<script>
alert("비밀번호가 다릅니다.");
history.go(-1);
</script>
</c:if>
