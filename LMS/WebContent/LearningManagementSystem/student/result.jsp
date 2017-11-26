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
						<h1 class="page-header">성적 조회</h1>
					</div>
				</div>
				<!-- /.row -->

				<%
  int check = Integer.parseInt(request.getParameter("check"));
  %>
				<%if(check==1){ %>
				<div class="row">
					<div class="col-lg-12 text-center">
						<ul id="myTab" class="nav nav-tabs" role="tablist">

							<li role="presentation" class="active"><a href="#home"
								id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
								aria-expanded="true">전체 성적 조회</a></li>
							<li role="presentation" class=""><a href="#profile"
								id="profile-tab" role="tab" data-toggle="tab"
								aria-controls="profile" aria-expanded="false">학기별 성적 조회</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="home"
								aria-labelledby="home-tab">
								<div class="col-lg-12 ">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead class="bg-aqua">
												<tr>
													<th>연도</th>
													<th>학기</th>
													<th>이수구분</th>
													<th>학수번호</th>
													<th>교과목명</th>
													<th>교수명</th>
													<th>이수학점</th>
													<th>성적</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${studentResultAll}">
													<tr>

														<td>${list.cp_year}</td>
														<td>${list.cp_semester}</td>
														<td>${list.s_cp_division}</td>
														<td>${list.s_num}</td>
														<td>${list.s_name}</td>
														<td>${list.pf_name}</td>
														<td>${list.s_cp_credits}</td>
														<c:choose>
															<c:when test="${list.g_sum == '' || list.g_sum == null}">
																<td>미입력</td>
															</c:when>
															<c:otherwise>
																<td>${list.g_sum}</td>
															</c:otherwise>
														</c:choose>
													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="profile"
								aria-labelledby="profile-tab">
								<!-- 학기선택 시작-->
								<div class="col-lg-12 text-left">
									<div class="info-box">
										<span class="info-box-icon bg-aqua">학기선택</span>

										<div class="info-box-content">
											<form>
												<span class="info-box-text">
													<div class="col-lg-4 text-center">
														<div class="panel panel-default">

															<select class="form-control" name="select_option">
																<option value="">학기선택</option>
																<c:forEach var="list" items="${yearlist}">
																	<option value="${list.cp_year},${list.cp_semester}">${list.cp_year}년도
																		${list.cp_semester}학기</option>
																</c:forEach>
															</select>

														</div>

													</div>
													<button type="submit" class="btn btn-lg bg-aqua">조회</button>
													<input type="hidden" name="check" value="2">
												</span>
											</form>
										</div>
									</div>
								</div>
								<!-- 학기선택 끝 -->
								<!-- 장학금명/장학금액 테이블 시작 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead class="bg-aqua">
												<tr>
													<th>연도</th>
													<th>학기</th>
													<th>이수구분</th>
													<th>학수번호</th>
													<th>교과목명</th>
													<th>교수명</th>
													<th>이수학점</th>
													<th>성적</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${studentResult}">
													<tr>
														<td>${list.cp_year}</td>
														<td>${list.cp_semester}</td>
														<td>${list.s_cp_division}</td>
														<td>${list.s_num}</td>
														<td>${list.s_name}</td>
														<td>${list.pf_name}</td>
														<td>${list.s_cp_credits}</td>
														<c:choose>
															<c:when test="${list.g_sum == '' || list.g_sum == null}">
																<td>미입력</td>
															</c:when>
															<c:otherwise>
																<td>${list.g_sum}</td>
															</c:otherwise>
														</c:choose>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<!-- 장학금명/장학금액 테이블 끝 -->

							</div>
						</div>
					</div>
				</div>
				<%}else if(check==2){ %>
				<div class="row">
					<div class="col-lg-12 text-center">
						<ul id="myTab" class="nav nav-tabs" role="tablist">

							<li role="presentation" class=""><a href="#home"
								id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
								aria-expanded="false">전체 성적 조회</a></li>
							<li role="presentation" class="active"><a href="#profile"
								id="profile-tab" role="tab" data-toggle="tab"
								aria-controls="profile" aria-expanded="true">학기별 성적 조회</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade" id="home"
								aria-labelledby="home-tab">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead class="bg-aqua">
												<tr>
													<th>연도</th>
													<th>학기</th>
													<th>이수구분</th>
													<th>학수번호</th>
													<th>교과목명</th>
													<th>교수명</th>
													<th>이수학점</th>
													<th>성적</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${studentResultAll}">
													<tr>
														<td>${list.cp_year}</td>
														<td>${list.cp_semester}</td>
														<td>${list.s_cp_division}</td>
														<td>${list.s_num}</td>
														<td>${list.s_name}</td>
														<td>${list.pf_name}</td>
														<td>${list.s_cp_credits}</td>
														<c:choose>
															<c:when test="${list.g_sum == '' || list.g_sum == null}">
																<td>미입력</td>
															</c:when>
															<c:otherwise>
																<td>${list.g_sum}</td>
															</c:otherwise>
														</c:choose>
													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane fade active in" id="profile"
								aria-labelledby="profile-tab">
								<!-- 학기선택 시작-->
								<div class="col-lg-12 text-left">
									<div class="info-box">
										<span class="info-box-icon bg-aqua">학기선택</span>

										<div class="info-box-content">
											<form>
												<span class="info-box-text">
													<div class="col-lg-4 text-center">
														<div class="panel panel-default">

															<select class="form-control" name="select_option">
																<option value="">학기선택</option>
																<c:forEach var="list" items="${yearlist}">
																	<option value="${list.cp_year},${list.cp_semester}">${list.cp_year}년도
																		${list.cp_semester}학기</option>
																</c:forEach>
															</select>

														</div>

													</div>
													<button type="submit" class="btn btn-lg bg-aqua">조회</button>
													<input type="hidden" name="check" value="2">
												</span>
											</form>
										</div>
									</div>
								</div>
								<!-- 학기선택 끝 -->
								<!-- 장학금명/장학금액 테이블 시작 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead class="bg-aqua">
												<tr>
													<th>연도</th>
													<th>학기</th>
													<th>이수구분</th>
													<th>학수번호</th>
													<th>교과목명</th>
													<th>교수명</th>
													<th>이수학점</th>
													<th>성적</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="list" items="${studentResult}">
													<tr>
														<td>${list.cp_year}</td>
														<td>${list.cp_semester}</td>
														<td>${list.s_cp_division}</td>
														<td>${list.s_num}</td>
														<td>${list.s_name}</td>
														<td>${list.pf_name}</td>
														<td>${list.s_cp_credits}</td>
														<c:choose>
															<c:when test="${list.g_sum == '' || list.g_sum == null}">
																<td>미입력</td>
															</c:when>
															<c:otherwise>
																<td>${list.g_sum}</td>
															</c:otherwise>
														</c:choose>

													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
								</div>
								<!-- 장학금명/장학금액 테이블 끝 -->
							</div>
						</div>
					</div>
				</div>
				<%} %>

			</div>
		</div>

		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->

	<!-- jQuery -->

</body>

</html>
