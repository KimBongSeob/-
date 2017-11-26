
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:if test='${count > 0}'>
<script type="text/javascript">
alert("수정되었습니다.");
history.go(-1);
</script>
</c:if> 

<html>

</html>

<!-- out.println("<script>alert('"+result+ "');</script>");
out.println("<script>document.location.href='/LMS/LearningManagementSystem/login.do';</script>"); -->