<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.text.SimpleDateFormat"%>

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<%@include file="/LearningManagementSystem/professor/css_script.jsp"%>

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
		<%@include
			file="/LearningManagementSystem/professor/head_professor.jsp"%>

		<!-- head 끝 -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">강의계획서 관리</h1>
					</div>
				</div>
				<!-- /.row -->
<c:if test='${count > 0}'>
<script type="text/javascript">
alert("수정 되었습니다.");
</script>
</c:if>

				<div class="row">
					<div class="col-lg-12">
						<ul id="myTab" class="nav nav-tabs" role="tablist">

							<li role="presentation" class="active"><a href="#tab1"
								id="Register-tab1" role="tab" data-toggle="tab"
								aria-controls="tab1" aria-expanded="true">강의계획서 관리</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="tab1"
								aria-labelledby="Register-tab1"></div>

							<div class='row'>
								<div class="col-lg-12">
									<h1 class="page-header">목록</h1>
								</div>
								<div class="col-lg-12 text-left">
									<div class="info-box">
										<div class="row"></div>
										<span class="info-box-icon bg-aqua">강의계획서 목록</span>
										
										<div class="info-box-content"></div>
										<div style='float:right; top:-10px; margin-top:-5px;'>
										<form method='post' action='/LMS/LearningManagementSystem/ClassPlanForm.do'>
										<input type="submit" class="btn btn-lg bg-aqua"  value="등록하기">
										</form>
										</div>
									</div>
									<div class="console col-lg-8"></div>

								</div>

							</div>
							<div class='row'>
								<!-- 강의계획서  교과목 개요 시작 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead>
												<!-- class="bg-aqua" -->
												<tr>
													<td class='bg-aqua'>개설년도</td>
													<td class='bg-aqua'>개설학기</td>
													<td class='bg-aqua'>이수구분</td>
													<td class='bg-aqua'>이수학점</td>
													<td class='bg-aqua'>학수번호</td>
													<td class='bg-aqua'>교과목명</td>
													<td class='bg-aqua'>교수이름</td>
													<td class='bg-aqua'>강의시간/요일</td>
													<td class='bg-aqua'>강의 최대인원/현재인원</td>
													<td class='bg-aqua'>강의실번호</td>
													<td class='bg-aqua'>승인여부</td>
													<td class='bg-aqua text-center'>조회</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="list" items="${classplanDataList}">
												<tr>
													<td>${list.cp_year}</td>
													<td>${list.cp_semester}</td>
													<td>${list.s_cp_division}</td>
													<td>${list.s_cp_credits}</td>
													<td>${list.s_num}</td>
													<td>${list.s_name}</td>
													<td>${list.pf_name}</td>
													<td>${list.cp_time}</td>
													<td>${list.cp_current_no}/${list.cp_max_no}</td>
													<td>${list.cr_num}</td>
													<c:choose>
													<c:when test="${list.registration == 0}"><td>미등록</td></c:when>
													<c:otherwise><td>등록</td></c:otherwise>
												
													</c:choose>
													<td><input class='plan_search' type="button" class="btn btn-lg bg-aqua" id="${list.cp_num}" value="조회하기"></td>
												</tr>
											</c:forEach>


											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 교과목 개요 끝 -->
							</div>
							<div id='plan_div'></div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>



</body>

</html>
