<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test='${count > 0}'>
<script type="text/javascript">
alert("과목을 등록하였습니다.");
</script>
</c:if>
<meta http-equiv="Refresh" content="0;url=/LMS/LearningManagementSystem/Subject.do?select_option=${d_num}">

