<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test='${count > 0}'>
<script>
alert("승인 완료 되었습니다.");
self.close();
</script>
</c:if>