<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>

<meta charset="utf-8">

</head>
<body>
	<form action='/LMS/LearningManagementSystem/AdminLoaApprovalPro.do'>
		<center>
			<h1 class="page-header">학적변동</h1>
		  변동내용: <input type='text' name='src_value' value=''><input type='submit' class="btn btn-lg bg-aqua" value="확인">
		</center>
		<input type='hidden' name='select_option' value='${select_option}'>
		<input type='hidden' name='sd_num' value='${sd_num}'> <input
			type='hidden' name='re_loa_date' value='${re_loa_date}'>
			<input
			type='hidden' name='re_start_date' value='${re_start_date}'>
			<input
			type='hidden' name='check' value='${check}'>
			
	</form>
</body>
</html>