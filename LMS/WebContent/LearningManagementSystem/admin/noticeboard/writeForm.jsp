<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>

<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
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

        <!-- head 부분 -->
<c:if test="${id_size == 9}">
<%@include file="/LearningManagementSystem/student/head.jsp"%>
</c:if>
<c:if test="${id_size == 4}">
<%@include file="/LearningManagementSystem/professor/head_professor.jsp"%>
</c:if>
<c:if test="${id_size == 5}">
<%@include file="/LearningManagementSystem/admin/head.jsp"%>
</c:if>
        
        <!-- head 끝 -->
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                          공지사항 글쓰기
                        </h1>
                    </div>
                </div>
                <!-- /.row -->


                <div class="row">
                    <div class="col-lg-12 text-center">
  

<body bgcolor="${bodyback_c}">
	<center>
		<b>글쓰기</b> <br>
		<form method="post" name="writeform"
			action="/LMS/LearningManagementSystem/admin/noticeboard/writePro.do"
			onsubmit="return writeSave()">
			<input type="hidden" name="num" value="${num}">

			<table width="700" border="1" cellspacing="0" cellpadding="0"
				align="center">
				<tr>
					<td align="right" colspan="2" bgcolor="${value_c}"><a
						href="/LMS/LearningManagementSystem/admin/noticeboard/list.do"> 글목록</a></td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">작성자</td>
					<input type="hidden" name="writer" value="admin">
					<td width="330">${sessionScope.member}</td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">제 목</td>
					<td width="330"><c:if test="${num == 0}">
							<input type="text" size="40" maxlength="50" name="subject"></td>
					</c:if>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">내 용</td>
					<td width="330"><textarea name="content" rows="13" cols="40"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan=2 bgcolor="${value_c}" align="center"><input
						type="submit" value="글쓰기"> <input type="reset"
						value="다시작성"> <input type="button" value="목록보기"
						OnClick="window.location='/LMS/LearningManagementSystem/admin/noticeboard/list.do'">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>
