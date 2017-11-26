<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>

<html>
<head>

    <meta charset="utf-8">
    
    <%@include file="/LearningManagementSystem/admin/css_script.jsp"%>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

<c:if test="${id_size == 9}">
<%@include file="/LearningManagementSystem/student/head.jsp"%>
</c:if>
<c:if test="${id_size == 4}">
<%@include file="/LearningManagementSystem/professor/head_professor.jsp"%>
</c:if>
<c:if test="${id_size == 5}">
<%@include file="/LearningManagementSystem/admin/head.jsp"%>
</c:if>
        <!-- head 부분 -->
        
        
        <!-- head 끝 -->
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                       공지사항
                        </h1>
                    </div>
                </div>
                <!-- /.row -->


                <div class="row">
                    <div class="col-lg-12 text-center">
  
<!--
a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	
}

a:active {
	text-decoration: underline;
}

a:hover {
	text-decoration: underline;
	background-image: url('text_dottdeline.gif');
	background-repeat: repeat-x;
	background-position: 50% 100%;
}
-->
</style>
<style>
<!--
@font-face {
	font-family: 굴림;
	src: url();
}

body, td, a, div, p, pre, input, textarea {
	font-family: 굴림;
	font-size: 9pt;
}
-->
</style>
</head>

<body bgcolor="${bodyback_c}">
	<center>
		<b>글내용 보기</b> <br>
		<form>
			<table width="700" border="1" cellspacing="0" cellpadding="0"
				align="center">
				<tr height="30">
					<td align="center" width="125" bgcolor="${value_c}">글번호</td>
					<td align="center" width="125" align="center">${article.num}</td>
					<td align="center" width="125" bgcolor="${value_c}">조회수</td>
					<td align="center" width="125" align="center">${article.readcount}</td>
				</tr>
				<tr height="30">
					<td align="center" width="125" bgcolor="${value_c}">작성자</td>
					<%-- <td align="center" width="125" align="center">${article.writer}</td> --%>
					<td align="center" width="125" align="center"> ${sessionScope.member} </td>
					<td align="center" width="125" bgcolor="${value_c}">작성일</td>
					<td align="center" width="125" align="center">${article.reg_date}</td>
				</tr>
				<tr height="30">
					<td align="center" width="125" bgcolor="${value_c}">글제목</td>
					<td align="center" width="375" align="center" colspan="3">${article.subject}</td>
				</tr>
				<tr>
					<td align="center" width="125" bgcolor="${value_c}">글내용</td>
					<td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
				</tr>
				<tr height="30">
					<td colspan="4" bgcolor="${value_c}" align="right"><input
						type="button" value="글수정"
						onclick="document.location.href='/LMS/LearningManagementSystem/admin/noticeboard/updateForm.do?num=${article.num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="글삭제"
						onclick="document.location.href='/LMS/LearningManagementSystem/admin/noticeboard/deleteForm.do?num=${article.num}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="글목록"
						onclick="document.location.href='/LMS/LearningManagementSystem/admin/noticeboard/list.do?pageNum=${pageNum}'">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>