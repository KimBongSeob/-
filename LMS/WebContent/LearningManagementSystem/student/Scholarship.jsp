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
						<h1 class="page-header">장학금 조회</h1>
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
								aria-expanded="true">장학금 수혜 계좌조회</a></li>
							<li role="presentation" class=""><a href="#profile"
								id="profile-tab" role="tab" data-toggle="tab"
								aria-controls="profile" aria-expanded="false">장학금 수혜 내역 조회</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="home"
								aria-labelledby="home-tab">
								<div class="col-lg-3 col-md-6">
									<div class="panel panel-primary">
										<div class="panel-heading">
											<div class="row">
												<div class="col-xs-3">
													<i class="glyphicon glyphicon-usd fa-2x"></i>
												</div>
												<div class="col-xs-9">
													<div>장학금 수혜 계좌</div>
												</div>
											</div>
										</div>
										<a href="#">
											<div class="panel-footer">
												<span class="pull-left">은행 및 계좌번호</span> <span
													class="pull-right"><i
													class="fa fa-arrow-circle-right"></i></span>
												<div class="clearfix"></div>
											</div>
										</a>
									</div>
								</div>
								<div class="row">

									<div class="col-lg-8 text-center">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="form-group pull-left">
													<label>계좌은행:${accountData.sd_ac_name}</label><br> <label>계좌번호:${accountData.sd_ac_no}</label>

												</div>
											</div>
										</div>
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

																<c:choose>
																	<c:when test="${size == 0}">
																		<option value="전체조회">전체조회</option>
																	</c:when>
																	<c:when test="${size > 0}">
																		<option value="전체조회">전체조회</option>
																		<c:forEach var="list" items="${ScholarshipAllList}">
																			<option value="${list.list}">${list.year}년도
																				${list.grade}학년 ${list.semester}학기</option>
																		</c:forEach>
																	</c:when>

																</c:choose>
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
								<div class="col-lg-6">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead class="bg-aqua">
												<tr>
													<th>년도</th>
													<th>학년</th>
													<th>학기</th>
													<th>장학금명</th>
													<th>장학금액</th>
												</tr>
											</thead>
											<tbody>

												<c:choose>
													<c:when test="${select_option == '' || size == 0}">
														<tr>
															<td class="text-center" colspan="5">장학금 수혜 내역이 없습니다.</td>
														</tr>
													</c:when>
													<c:otherwise>
														<c:forEach var="list" items="${ScholarshipList}">
															<tr>
																<td>${list.year}</td>
																<td>${list.grade}</td>
																<td>${list.semester}</td>
																<td>${list.name}</td>
																<td>${list.sum}</td>
															</tr>
														</c:forEach>
													</c:otherwise>
												</c:choose>

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
								aria-expanded="false">장학금 수혜 계좌조회</a></li>
							<li role="presentation" class="active"><a href="#profile"
								id="profile-tab" role="tab" data-toggle="tab"
								aria-controls="profile" aria-expanded="true">장학금 수혜 내역 조회</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade" id="home"
								aria-labelledby="home-tab">
								<div class="col-lg-3 col-md-6">
									<div class="panel panel-primary">
										<div class="panel-heading">
											<div class="row">
												<div class="col-xs-3">
													<i class="glyphicon glyphicon-usd fa-2x"></i>
												</div>
												<div class="col-xs-9">
													<div>장학금 수혜 계좌</div>
												</div>
											</div>
										</div>
										<a href="#">
											<div class="panel-footer">
												<span class="pull-left">은행 및 계좌번호</span> <span
													class="pull-right"><i
													class="fa fa-arrow-circle-right"></i></span>
												<div class="clearfix"></div>
											</div>
										</a>
									</div>
								</div>
								<div class="row">

									<div class="col-lg-8 text-center">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="form-group pull-left">
													<label>계좌은행:${accountData.sd_ac_name}</label><br> <label>계좌번호:${accountData.sd_ac_no}</label>

												</div>
											</div>
										</div>
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

																<c:choose>
																	<c:when test="${size == 0}">
																		<option value="전체조회">전체조회</option>
																	</c:when>
																	<c:when test="${size > 0}">
																		<option value="전체조회">전체조회</option>
																		<c:forEach var="list" items="${ScholarshipAllList}">
																			<option value="${list.list}">${list.year}년도
																				${list.grade}학년 ${list.semester}학기</option>
																		</c:forEach>
																	</c:when>

																</c:choose>
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
								<div class="col-lg-6">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead class="bg-aqua">
												<tr>
													<th>년도</th>
													<th>학년</th>
													<th>학기</th>
													<th>장학금명</th>
													<th>장학금액</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${select_option == '' || size == 0}">
														<tr>
															<td class="text-center" colspan="5">장학금 수혜 내역이 없습니다.</td>
														</tr>
													</c:when>
													<c:otherwise>
														<c:forEach var="list" items="${ScholarshipList}">
															<tr>
																<td>${list.year}</td>
																<td>${list.grade}</td>
																<td>${list.semester}</td>
																<td>${list.name}</td>
																<td>${list.sum}</td>
															</tr>
														</c:forEach>
													</c:otherwise>
												</c:choose>

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
