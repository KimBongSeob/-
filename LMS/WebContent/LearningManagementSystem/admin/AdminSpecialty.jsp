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
						<h1 class="page-header">부/복수전공 관리</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 text-center">
						<ul id="myTab" class="nav nav-tabs" role="tablist">
<c:if test='${select == 1}'>
							<li id='Register1' role="presentation" class="active"><a
								href="#tab1" id="Register-tab1" role="tab" data-toggle="tab"
								aria-controls="tab1" aria-expanded="true">부전공 관리</a></li>
							<li id='Register2' role="presentation" class=""><a
								href="#tab2" id="Register-tab2" role="tab" data-toggle="tab"
								aria-controls="tab2" aria-expanded="false">복수전공 관리</a></li>
</c:if>
<c:if test='${select == 2}'>
							<li id='Register1' role="presentation" class=""><a
								href="#tab1" id="Register-tab1" role="tab" data-toggle="tab"
								aria-controls="tab1" aria-expanded="false">부전공 관리</a></li>
							<li id='Register2' role="presentation" class="active"><a
								href="#tab2" id="Register-tab2" role="tab" data-toggle="tab"
								aria-controls="tab2" aria-expanded="true">복수전공 관리</a></li>
</c:if>
						</ul>

						<div id="myTabContent" class="tab-content">
						<c:if test='${select == 1}'>
							<div role="tabpanel" class="tab-pane fade active in" id="tab1"
								aria-labelledby="Register-tab1">
						</c:if>
						<c:if test='${select == 2}'>
							<div role="tabpanel" class="tab-pane fade" id="tab1"
								aria-labelledby="Register-tab1">
						</c:if>

								<div class='row'>
									<div class="col-lg-12 text-left">
										<h1 class="page-header">부전공 관리</h1>
									</div>
									<div class="col-lg-12 text-left">
										<div class="info-box">
											<span class="info-box-icon bg-aqua">과 검색</span>
											<div class="info-box-content">
												<form>
													<span class="info-box-text">
														<div class="col-lg-4 text-center">
															<div class="panel panel-default">

																<select class="form-control" name="select_option">

																	<%-- <c:choose> --%>
																	<%-- <c:when test="${size == 0}">
                                <option value="" selected>선택하세요.</option>
                                </c:when> --%>
																	<%-- <c:when test="${size > 0}"> --%>
																	<option value="" selected>선택하세요.</option>
																	<c:forEach var="list" items="${DepartmentList}">
																		<option value="${list.d_num}">${list.d_name}</option>
																	</c:forEach>

																</select>

															</div>

														</div>

														<button type="submit" class="info-box-btn btn-lg bg-aqua">검색</button>
														<!-- <input type="hidden" name="check" value="1"> -->

													</span>
													<!-- 강의계획서 목록 시작 -->
													<div class="col-lg-12 text-left">
														<div class="table-responsive">
															<table class="table table-bordered table-hover">
																<thead>
																	<!-- class="bg-aqua" -->
																	<tr>
																		<td class='bg-aqua'>학과</td>
																		<td class='bg-aqua'>학번</td>
																		<td class='bg-aqua'>이름</td>
																		<td class='bg-aqua'>부전공신청 학과</td>
																		<td class='bg-aqua'>부전공신청 날짜</td>
																		<td class='bg-aqua'></td>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach var="list" items="${SubspecialtyList}">
																		<tr>
																			<td>${list.d_name}</td>
																			<td>${list.sd_num}</td>
																			<td>${list.sd_name}</td>
																			<td>${list.d_sub_name}</td>
																			<td>${list.m_date}</td>
																			<td><input type=button class="btn btn-lg bg-aqua" value="승인" onclick="window.open('/LMS/LearningManagementSystem/AdminSpecialtyPro.do?select_option=${select_option}&sd_num=${list.sd_num}&sp_no=${list.sp_no}&d_sub_num=${list.d_sub_num}&check=1','window팝업','width=500, height=200,left=700, top=400, menubar=no, location=no, resizable=no, status=no, toolbar=no');"></td>
																		</tr>
																	</c:forEach>


																</tbody>
															</table>
														</div>
													</div>
													<!-- 강의계획서 목록 끝 -->
													<input type='hidden' id='select' name='select' value='1'>
												</form>


											</div>


										</div>


									</div>

								</div>
							</div>
							<c:if test='${select == 1}'>
							<div role="tabpanel" class="tab-pane fade" id="tab2"
								aria-labelledby="Register-tab2">
							</c:if>
							<c:if test='${select == 2}'>
							<div role="tabpanel" class="tab-pane fade active in" id="tab2"
								aria-labelledby="Register-tab2">
							</c:if>
								<div class='row'>
									<div class="col-lg-12 text-left">
										<h1 class="page-header">복수전공 관리</h1>
									</div>
									<div class="col-lg-12 text-left">
										<div class="info-box">
											<span class="info-box-icon bg-aqua">과 검색</span>
											<div class="info-box-content">
												<form>
													<span class="info-box-text">
														<div class="col-lg-4 text-center">
															<div class="panel panel-default">

																<select class="form-control" name="select_option2">
																	<option value="" selected>선택하세요.</option>
																	<c:forEach var="list" items="${DepartmentList}">
																		<option value="${list.d_num}">${list.d_name}</option>
																	</c:forEach>

																</select>

															</div>

														</div>

														<button type="submit" class="info-box-btn btn-lg bg-aqua">검색</button>
														<!-- <input type="hidden" name="check" value="1"> -->

													</span>
													<!-- 강의계획서 목록 시작 -->
													<div class="col-lg-12 text-left">
														<div class="table-responsive">
															<table class="table table-bordered table-hover">
																<thead>
																	<!-- class="bg-aqua" -->
																	<tr>
																		<td class='bg-aqua'>학과</td>
																		<td class='bg-aqua'>학번</td>
																		<td class='bg-aqua'>이름</td>
																		<td class='bg-aqua'>복수전공신청 학과</td>
																		<td class='bg-aqua'>복수전공신청 날짜</td>
																		<td class='bg-aqua'></td>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach var="list" items="${SubspecialtyList_B}">
																		<tr>
																			<td>${list.d_name}</td>
																			<td>${list.sd_num}</td>
																			<td>${list.sd_name}</td>
																			<td>${list.d_sub_name}</td>
																			<td>${list.dm_date}</td>
																			<td><input type=button class="btn btn-lg bg-aqua" value="승인" onclick="window.open('/LMS/LearningManagementSystem/AdminSpecialtyPro.do?select_option=${select_option}&sd_num=${list.sd_num}&sp_no=${list.sp_no}&d_sub_num=${list.d_sub_num}&check=2','window팝업','width=500, height=200,left=700, top=400, menubar=no, location=no, resizable=no, status=no, toolbar=no');"></td>
																		</tr>
																	</c:forEach>


																</tbody>
															</table>
														</div>
													</div>
													<!-- 강의계획서 목록 끝 -->
													<input type='hidden' id='select' name='select' value='2'>
												</form>


											</div>


										</div>


									</div>

								</div>
								
								</div>
						</div>
					</div>
				</div>
</body>
</html>