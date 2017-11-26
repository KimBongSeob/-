<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		<%@include file="/LearningManagementSystem/admin/head.jsp"%>

		<!-- head 끝 -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">학생 관리 조회</h1>
					</div>
				</div>
				<!-- /.row -->

				<!-- 학적 테이블 시작 -->
				<div class="col-lg-6">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<!-- class="bg-aqua" -->
								<c:forEach var="list" items="${StudentList}">
									<tr>

										<td class='td_color'>학번</td>
										<td>${list.sd_num}</td>
										<td class='td_color'>학과</td>
										<td>${list.d_name}</td>
									</tr>
							</thead>
							<tbody>
								<tr>
									<td class='td_color'>이름</td>
									<td>${list.sd_name}</td>
									<td class='td_color'>학적상태</td>
									<td>${list.sd_re_loa}</td>
								</tr>
								<tr>
									<td class='td_color'>생년월일</td>
									<td colspan='3'>${list.sd_jumin}</td>

								</tr>
								<tr>
									<td class='td_color'>현재학년</td>
									<td>${list.sd_grade}</td>
									<td class='td_color'>이수학기</td>
									<td>${list.sd_semester}</td>
								</tr>
								<tr>
									<td class='td_color'>입학년월일</td>
									<td>${list.sd_start_date}</td>
									<td class='td_color'>졸업년월일</td>
									<td><c:choose>
											<c:when test="${list.sd_end_date == null}">
												<span>-</span>
											</c:when>
											<c:otherwise>
								${list.sd_end_date}
								</c:otherwise>
										</c:choose></td>
								</tr>
								<tr>
									<td class='td_color'>주소</td>
									<td colspan='3'>${list.sd_address}</td>

								</tr>
								</c:forEach>


								<tr>
									<td class='td_color' rowspan='${RegisterlistSize}'>학적변동</td>
									<!-- size만큼 아래로 늘림 -->
									<!-- 학적변동 for문 시작 -->
									<c:choose>
										<c:when test="${RegisterlistSize == 0}">
											<td colspan='3'>변동 내역이 없습니다.</td>
								</tr>
								</c:when>
								<c:otherwise>

									<c:forEach var='list' items='${Registerlist}'
										varStatus="status">
										<c:if test='${status.count == 1}'>
											<td>${list.src_date}</td>
											<td colspan='2'>${list.src_value}</td>
											</tr>
										</c:if>
										<c:if test='${status.count > 1}'>
											<tr>
												<td>${list.src_date}</td>
												<td colspan='2'>${list.src_value}</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:otherwise>
								</c:choose>

								<!-- 학적변동 for문 끝 -->
								<tr>
								<c:forEach var="list" items="${StudentList}">
									<td class='td_color'>부전공</td>
									<td><c:choose>
											<c:when test="${list.sub_type != '부전공'}">-</c:when>
											<c:otherwise>
											${list.sub_name}
											</c:otherwise>
										</c:choose></td>
									<td class='td_color'>복수전공</td>
									<td><c:choose>
											<c:when test="${list.sub_type != '복수전공'}">-</c:when>
											<c:otherwise>
											${list.sub_name}
											</c:otherwise>
										</c:choose></td>
									</c:forEach>	
								</tr>	
							</tbody>
						</table>
						<div colspan="4" class="pull-right">
						<!-- <input type=button class="btn btn-lg bg-aqua" value="수정"> -->
                		<input type=button class="btn btn-lg bg-aqua" value="목록" OnClick="window.location='/LMS/LearningManagementSystem/AllDepartmentStudent.do?select_option=${select_option}'">
                		</div>
					</div>
				</div>
				
				<!-- 학적 테이블 끝 -->
</body>
</html>