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
						<h1 class="page-header">수강신청</h1>
					</div>
				</div>
				
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<ul id="myTab" class="nav nav-tabs" role="tablist">

<c:if test='${select == 1}'>
							<li id='Register1' role="presentation" class="active"><a href="#tab1"
								id="Register-tab1" role="tab" data-toggle="tab"
								aria-controls="tab1" aria-expanded="true">개설과목 조회</a></li>
							<li id='Register2' role="presentation" class=""><a href="#tab2"
								id="Register-tab2" role="tab" data-toggle="tab"
								aria-controls="tab2" aria-expanded="false">수강신청 조회 및 삭제</a></li>
							<li id='Register3' role="presentation" class=""><a href="#tab3"
								id="Register-tab3" role="tab" data-toggle="tab"
								aria-controls="tab3" aria-expanded="false">과목담기</a></li>
							<li id='Register4' role="presentation" class=""><a href="#tab4"
								id="Register-tab4" role="tab" data-toggle="tab"
								aria-controls="tab4" aria-expanded="false">담은과목 조회 및 신청</a></li>
							<li id='Register5' role="presentation" class=""><a href="#tab5"
								id="Register-tab5" role="tab" data-toggle="tab"
								aria-controls="tab5" aria-expanded="false">담은과목 조회 및 삭제</a></li>
</c:if>
<c:if test='${select == 3}'>
							<li id='Register1' role="presentation" class=""><a href="#tab1"
								id="Register-tab1" role="tab" data-toggle="tab"
								aria-controls="tab1" aria-expanded="false">개설과목 조회</a></li>
							<li id='Register2' role="presentation" class=""><a href="#tab2"
								id="Register-tab2" role="tab" data-toggle="tab"
								aria-controls="tab2" aria-expanded="false">수강신청 조회 및 삭제</a></li>
							<li id='Register3' role="presentation" class="active"><a href="#tab3"
								id="Register-tab3" role="tab" data-toggle="tab"
								aria-controls="tab3" aria-expanded="true">과목담기</a></li>
							<li id='Register4' role="presentation" class=""><a href="#tab4"
								id="Register-tab4" role="tab" data-toggle="tab"
								aria-controls="tab4" aria-expanded="false">담은과목 조회 및 신청</a></li>
							<li id='Register5' role="presentation" class=""><a href="#tab5"
								id="Register-tab5" role="tab" data-toggle="tab"
								aria-controls="tab5" aria-expanded="false">담은과목 조회 및 삭제</a></li>
</c:if>

						</ul>
						<div id="myTabContent" class="tab-content">
						<c:if test='${select == 1}'>
							<div role="tabpanel" class="tab-pane fade active in" id="tab1"
								aria-labelledby="Register-tab1">
								</c:if>
								<c:if test='${select == 3}'>
							<div role="tabpanel" class="tab-pane fade" id="tab1"
								aria-labelledby="Register-tab1">
								</c:if>
								<div class="row">
									<div class="col-lg-12">
										<h1 class="page-header">개설과목 조회</h1>
									</div>
								</div>

								<div class='row'>
									<!-- 학기선택 시작-->
									<div class="col-lg-12 text-left">
										<div class="info-box">
											<span class="info-box-icon bg-aqua">과선택</span>

											<div class="info-box-content">
												<form>
													<span class="info-box-text">
														<div class="col-lg-4 text-center">
															<div class="panel panel-default">

																<select class="form-control" name="Department_option">

																	<c:choose>
																		<c:when test="${size == 0}">
																			<option value="선택">선택</option>
																		</c:when>
																		<c:when test="${size > 0}">
																			<option value="선택">선택</option>
																			<c:forEach var="list" items="${Departmentlist}">
																				<option value="${list.d_num}">${list.d_name}</option>
																				<!--value:과코드 , 내용:과이름 -->
																			</c:forEach>
																		</c:when>

																	</c:choose>
																</select>

															</div>

														</div>
														<button type="submit" class="btn btn-lg bg-aqua">조회</button>
													</span>
													<input type='hidden' id='select' name='select' value='1'>
												</form>
											</div>
										</div>
									</div>
									<!-- 학기선택 끝 -->
									<!-- 강의계획서 목록 시작 -->
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
														<td class='bg-aqua text-center'>조회</td>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="list" items="${ClassplanList}">
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

															<td><input class='plan_search' type="button"
																class="btn btn-lg bg-aqua" id="${list.cp_num}"
																value="조회하기"></td>
														</tr>
													</c:forEach>


												</tbody>
											</table>
										</div>
									</div>
									<!-- 강의계획서 목록 끝 -->
								</div>
							</div>

							<div role="tabpanel" class="tab-pane fade" id="tab2"
								aria-labelledby="Register-tab2">
								<div class="row">
									<div class="col-lg-12">
										<h1 class="page-header">수강신청 조회 및 삭제</h1>
									</div>
								</div>
								<div class='row'>
									<!-- 강의계획서 목록 시작 -->
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
														<td class='bg-aqua text-center'>수강신청 삭제</td>
													</tr>
												</thead>
												<tbody>

													<c:forEach var="list" items="${ClassRequestList}">
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

															<td><a
																href="/LMS/LearningManagementSystem/ClassrequestDelete.do?cp_num=${list.cp_num}"><input
																	type="button" class="btn btn-lg bg-aqua"
																	id="${list.cp_num}" value="삭제하기"></a></td>

														</tr>
													</c:forEach>

												</tbody>
											</table>
										</div>
									</div>
									<!-- 강의계획서 목록 끝 -->
								</div>


							</div>

								
								<c:if test='${select == 1}'>
							<div role="tabpanel" class="tab-pane fade" id="tab3"
								aria-labelledby="Register-tab3">
								</c:if>
								<c:if test='${select == 3}'>
							<div role="tabpanel" class="tab-pane fade active in" id="tab3"
								aria-labelledby="Register-tab3">
								</c:if>
							<div class="row">
								<div class="col-lg-12">
									<h1 class="page-header">과목담기</h1>
								</div>
							</div>

							<div class='row'>
								<!-- 학기선택 시작-->
								<div class="col-lg-12 text-left">
									<div class="info-box">
										<span class="info-box-icon bg-aqua">과선택</span>

										<div class="info-box-content">
											<form>
												<span class="info-box-text">
													<div class="col-lg-4 text-center">
														<div class="panel panel-default">

															<select class="form-control" name="Department_option">

																<c:choose>
																	<c:when test="${size == 0}">
																		<option value="선택">선택</option>
																	</c:when>
																	<c:when test="${size > 0}">
																		<option value="선택">선택</option>
																		<c:forEach var="list" items="${Departmentlist}">
																			<option value="${list.d_num}">${list.d_name}</option>
																			<!--value:과코드 , 내용:과이름 -->
																		</c:forEach>
																	</c:when>

																</c:choose>
															</select>

														</div>

													</div>
													<button id='Classbasket_button' type="submit" class="btn btn-lg bg-aqua">조회</button>
												</span>
												<input type='hidden' id='select' name='select' value='3'>
											</form>
										</div>
									</div>
								</div>
								<!-- 학기선택 끝 -->
								<!-- 강의계획서 목록 시작 -->
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
													<td class='bg-aqua text-center'>조회</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${ClassplanList}">
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

														<td><a
															href="/LMS/LearningManagementSystem/Classbasket.do?cp_num=${list.cp_num}"><input
																type="button" class="btn btn-lg bg-aqua"
																id="${list.cp_num}" value="과목담기"></a></td>
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 목록 끝 -->
								
							</div>
							<div class="row">
								<div class="col-lg-12">
									<h1 class="page-header">담은과목 조회</h1>
								</div>
							</div>
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
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${ClassbasketList}">
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
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
								</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tab4"
								aria-labelledby="Register-tab4">
						<!-- 강의계획서 목록 시작 -->
						<div class="row">
								<div class="col-lg-12">
									<h1 class="page-header">담은과목 조회 및 신청</h1>
								</div>
							</div>
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
													<td class='bg-aqua text-center'>담은과목 신청</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${ClassbasketList}">
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

														<td><a
															href="/LMS/LearningManagementSystem/ClassbasketInsert.do?cp_num=${list.cp_num}"><input
																type="button" class="btn btn-lg bg-aqua"
																id="${list.cp_num}" value="담은과목신청하기"></a></td>
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 목록 끝 -->
								
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tab5"
								aria-labelledby="Register-tab5">
						<!-- 강의계획서 목록 시작 -->
						<div class="row">
								<div class="col-lg-12">
									<h1 class="page-header">담은과목 조회 및 삭제</h1>
								</div>
							</div>
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
													<td class='bg-aqua text-center'>담은과목 삭제</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${ClassbasketList}">
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

														<td><a
															href="/LMS/LearningManagementSystem/ClassbasketDelete.do?cp_num=${list.cp_num}"><input
																type="button" class="btn btn-lg bg-aqua"
																id="${list.cp_num}" value="담은과목삭제하기"></a></td>
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 목록 끝 -->
								
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- /.container-fluid -->

	</div>
	<input type='hidden' id='sd_num' name='sd_num' value='${sd_num}'>

</body>

</html>
