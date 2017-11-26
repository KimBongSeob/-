<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>

<meta charset="utf-8">

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
		<%@include file="/LearningManagementSystem/professor/head_professor.jsp"%>

		<!-- head 끝 -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">성공대학교에 오신 것을 환영합니다.</h1>
					</div>
				</div>
				<!-- /.row -->


				<div class="row">
					<div class="col-lg-5 text-center">
						<center>
							<span style='font-size: 35px;'>NOTICE</span>
							<!-- 변수 선언되어 있지않으니까 속성에서 찾음 . request에 담겨있음. -->
							<table style='float: right;'>

								<tr>
									<td align="right" bgcolor="${value_c}"><a
										href="/LMS/LearningManagementSystem/professor/noticeboard/list.do">More</a></td>
									<!-- /프로젝트 명부터 properties의 key값과 같아야함. -->
								</tr>
							</table>

							<c:if test="${count == 0}">
								<table border="1" cellpadding="0" cellspacing="0">
									<tr>
										<td align="center">게시판에 저장된 글이 없습니다.</td>
									</tr>
								</table>
							</c:if>

							<c:if test="${count > 0}">
								<table border="1" cellpadding="0" cellspacing="0" align="center">
									<tr height="30" bgcolor="${value_c}">
										<td align="center" width="50">No.</td>
										<td align="center" width="250">제 목</td>
										<td align="center" width="100">작성자</td>


									</tr>

									<c:forEach var="article" items="${articleList}">
										<!-- arraylist넘겨줘서 처음부터 끝까지 출력함 -->
										<tr height="30">
											<td align="center" width="50"><c:out value="${number}" />
												<c:set var="number" value="${number - 1}" /></td>
											<td align="center" width="50"><a
												href="/LMS/LearningManagementSystem/professor/noticeboard/content.do?num=${article.num}&pageNum=${currentPage}">
													${article.subject}</a> <c:if test="${article.readcount >= 20}">
													<img src="images/hot.gif" border="0" height="16">
												</c:if></td>
											<td align="center" width="50">${article.writer}</td>

										</tr>
									</c:forEach>
								</table>
							</c:if>



						</center>
					</div>
					
					<div class="col-lg-5 text-center">
						<span style='font-size: 35px;'>BOARD</span>
						<table style='float: right'>
							<tr>
								<td align="right" bgcolor="${value_c}"><a
									href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/list.do">More</a></td>
							</tr>
						</table>

						<c:if test="${count2 == 0}">
							<table border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td align="center" width="50">No.</td>
									<td align="center" width="250">제 목</td>
									<td align="center" width="100">작성자</td>
								</tr>
								<tr>
									<td align="center" colspan='3'>게시판에 저장된 글이 없습니다.</td>
								</tr>
							</table>
						</c:if>

						<c:if test="${count2 > 0}">
							<table border="1" cellpadding="0" cellspacing="0" align="center">
								<tr height="30" bgcolor="${value_c}">
									<td align="center" width="50">No.</td>
									<td align="center" width="250">제 목</td>
									<td align="center" width="100">작성자</td>
									
								</tr>

								<c:forEach var="article" items="${articleList2}">
									<!-- ArrayList에 n번째 인덱스의 값을 하나씩 꺼내서 article변수에 저장 -->
									<tr height="30">
										<td align="center" width="50"><c:out value="${number2}" />
											<c:set var="number2" value="${number2 - 1}" /></td>
										<td width="250"><c:if test="${article.re_level > 0}">
												<!-- 읽을 수 있는 프로퍼티명인지 확인. => getre_level()메소드 호출 -->
												<img src="images/level.gif" width="${5 * article.re_level}"
													height="16">
												<img src="images/re.gif">
											</c:if> <c:if test="${article.re_level == 0}">
												<img src="images/level.gif" width="${5 * article.re_level}"
													height="16">
											</c:if> <a
											href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/content.do?num=${article.num}&pageNum=${currentPage}">${article.subject}</a>
											<c:if test="${article.readcount >= 20}">
												<img src="images/hot.gif" border="0" height="16">
											</c:if></td>

										<td align="center" width="100">${article.writer}</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
					</div>
				</div>

				
</body>
</html>