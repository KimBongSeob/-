<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>

<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <%@include file="/LearningManagementSystem/student/css_script.jsp"%>
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
        <%@include file="/LearningManagementSystem/student/head.jsp"%>
        
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
  
<body bgcolor="${bodyback_c}">
	<center>
		<b>글목록(전체 글:${count})</b>
		<!-- 변수 선언되어 있지않으니까 속성에서 찾음 . request에 담겨있음. -->
		<table width="700">
			
		</table>

		<c:if test="${count == 0}">
			<table width="700" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<table border="1" width="700" cellpadding="0" cellspacing="0"
				align="center">
				<tr height="30" bgcolor="${value_c}">
					<td align="center" width="50">번 호</td>
					<td align="center" width="250">제 목</td>
					<td align="center" width="100">작성자</td>
					<td align="center" width="150">작성일</td>
					<td align="center" width="50">조 회</td>

				</tr>

				<c:forEach var="article" items="${articleList}">
					<!-- arraylist넘겨줘서 처음부터 끝까지 출력함 -->
					<tr height="30">
						<td align="center" width="50"><c:out value="${number}" /> 
						<c:set var="number" value="${number - 1}" />
						</td>
						<td align="center" width="50">	<a href="/LMS/LearningManagementSystem/student/noticeboard/content.do?num=${article.num}&pageNum=${currentPage}">
								${article.subject}</a> 
								<c:if test="${article.readcount >= 20}">
								<img src="images/hot.gif" border="0" height="16">
							</c:if></td>
						<td align="center" width="50">${article.writer}</td>
						<td align="center" width="150">
						<fmt:formatDate value="${article.reg_date}" type="date"
							dateStyle="short" />
						</td>
						<td align="center" width="50">${article.readcount}</td>
					
					</tr>
				</c:forEach>
			</table>
			</c:if>
		
		<c:if test="${count > 0}">
			<c:set var="pageCount"
				value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
			<c:set var="pageBlock" value="${10}" />
			<fmt:parseNumber var="result" value="${currentPage / 10}"
				integerOnly="true" />
			<c:set var="startPage" value="${result * 10 + 1}" />
			<c:set var="endPage" value="${startPage + pageBlock-1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			 <c:if test="${startPage > 10}">
				<a href="/LMS/LearningManagementSystem/student/noticeboard/list.do?pageNum=${startPage - 10 }">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/LMS/LearningManagementSystem/student/noticeboard/list.do?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="/LMS/LearningManagementSystem/student/noticeboard/list.do?pageNum=${startPage + 10}">[다음]</a>
			</c:if> 
		</c:if>
<form>
  <select name="searchn">
  <option value="0">작성자</option>
  <option value="1">제목</option>
  <option value="2">내용</option>
  </select>
  <input type="text" name="search" size="15" maxlength="50" /> 
  <input type="submit" value="검색" />&nbsp;
 <input type="button" value="목록보기" OnClick="window.location='/LMS/LearningManagementSystem/student/noticeboard/list.do'">
 </form>
  <br></br>
		
	</center>
</body>
</html>