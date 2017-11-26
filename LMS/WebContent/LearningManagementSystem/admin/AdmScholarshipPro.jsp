<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>학사관리 시스템 - 장학금수여</title>
<%@include file="/LearningManagementSystem/professor/css_script.jsp"%>
</head>
<body>
<c:if test='${count > 0}'>
<script>
alert("장학금 수여 완료하였습니다.");
self.close();
</script>
</c:if>
	<form>
	<input type='hidden' name='sd_num' value='${sd_num}'>
	<input type='hidden' name='Year_option' value='${Year_option}'>
	<input type='hidden' name='Semester_option' value='${Semester_option}'>
	<input type='hidden' name='Grade_option' value='${Grade_option}'>
		<div>
			<span class="info-box-icon bg-aqua">장학금수여</span> <select
				class="form-control" name="AdmScholarship_option">
				<option value="A장학금/5000000">A장학금</option>
				<option value="B장학금/4000000">B장학금</option>
				<option value="C장학금/3000000">C장학금</option>
			</select>
			<span style='float:right;'><button type="submit" class="info-box-btn btn-lg bg-aqua">수여</button></span>
		</div>
	</form>
</body>
</html>