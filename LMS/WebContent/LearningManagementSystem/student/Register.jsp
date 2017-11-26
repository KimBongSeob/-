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
						<h1 class="page-header">학사/학적</h1>
					</div>
				</div>
				<!-- /.row -->

				<%
					int check = Integer.parseInt(request.getParameter("check"));
				%>
				<%
					if (check == 1) {
				%>
				<div class="row">
					<div class="col-lg-12">
						<ul id="myTab" class="nav nav-tabs" role="tablist">

							<li role="presentation" class="active"><a href="#tab1"
								id="Register-tab1" role="tab" data-toggle="tab"
								aria-controls="tab1" aria-expanded="true">휴학/복학/휴학연장 신청</a></li>
							<li role="presentation" class=""><a href="#tab2"
								id="Register-tab2" role="tab" data-toggle="tab"
								aria-controls="tab2" aria-expanded="false">학적 조회</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="tab1"
								aria-labelledby="Register-tab1">
								<div class="row">
											<div class="col-lg-12">
												<h1 class="page-header">학적변동 내역</h1>
											</div>
								</div>
								<form >
									<div class="row">
									<!-- 학적변동 테이블 시작 -->
										<div class="col-lg-12">
										
											<div class="table-responsive">
												<table class="table table-bordered table-hover">
													<thead class="bg-aqua">
														<tr>
															<th>No</th>
															<th>변동내용</th>
															<th>신청날짜</th>
															<th>학적변동날짜</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<c:choose>
																<c:when test="${RegisterlistSize == 0}">
																	<!--count 0이면  -->
																	<td class="text-center" colspan="5">변동 내역이 없습니다.</td>
																</tr>
																</c:when>
																<c:otherwise>
																	<c:forEach var="list" items="${Registerlist}"
																		varStatus="status">
																		<!--리스트 출력 -->
																		<td>${status.count}</td>
																		<td>${list.src_value}</td>
																		<td>${list.src_request_date}</td>
																		<td>${list.src_date}</td>
																		</tr>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														
													</tbody>
												</table>
											</div>
										</div>
										<!-- 학적변동 테이블 끝 -->
										<!-- 학적 ,학기 선택 시작-->

										<div class="col-lg-12 text-left">
											<div class="info-box">
												<div class="row">
													<div class="col-lg-12">
														<h1 class="page-header">학적변동신청</h1>
													</div>
												</div>
												<span class="info-box-icon bg-aqua">학적 선택</span>

												<div class="info-box-content">

													<span class="info-box-text">

														<div>
															<span class="col-lg-4 text-center"
																name="Register_option1" id="Register_option1"></span> <span
																class="col-lg-4 text-center" name="Register_option2"
																id="Register_option2"></span>
														</div> <input type="hidden" name="check" value="1">
													</span>

												</div>

											</div>
											<div class="console col-lg-8"></div>

										</div>
										


										<input type="hidden" name="check" value="1">
										<div class="submit_button col-lg-12 text-left"></div>
										<div class="hidden_item"></div>
										<input type='hidden' id='end_year' name='end_year' value='${end_year}'>
										<input type='hidden' id='end_semester' name='end_semester' value='${end_semester}'>
										<c:if test="${update_check == 1 && end_year != null }">
											<script>
											
												alert("휴학 신청 완료하였습니다. 휴학 만료는  "+document.getElementById("end_year").value+"학년도 "+document.getElementById("end_semester").value+"학기 이며,\n 관리자 승인 후 휴학이 완료됩니다.");
												//alert("신청 완료하였습니다.");
											</script>
										</c:if>
										<c:if test="${update_check == 1 && end_year == null }">
											<script>
											
												alert("복학 신청 완료하였습니다. \n 관리자 승인 후 복학 완료 됩니다.");
											</script>
										</c:if>
										<!-- 학기선택 끝 -->



									</div>

								</form>

							</div>

							<div role="tabpanel" class="tab-pane fade" id="tab2"
								aria-labelledby="Register-tab2">
								<!-- 학적 테이블 시작 -->
								<div class="col-lg-6">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead ><!-- class="bg-aqua" -->
												<tr>
													<td class='td_color'>학번</td>
													<td>${StudentRegisterData.sd_num}</td>
													<td class='td_color'>학과</td>
													<td>${StudentRegisterData.d_name}</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class='td_color'>이름</td>
													<td>${StudentRegisterData.sd_name}</td>
													<td class='td_color'>학적상태</td>
													<td>${StudentRegisterData.sd_re_loa}</td>
												</tr>
												<tr>
													<td class='td_color'>생년월일</td>
													<td colspan='3'>${StudentRegisterData.sd_jumin}</td>
													
												</tr>
												<tr>
													<td class='td_color'>현재학년</td>
													<td>${StudentRegisterData.sd_grade}</td>
													<td class='td_color'>이수학기</td>
													<td>${StudentRegisterData.sd_semester}</td>
												</tr>
												<tr>
													<td class='td_color'>입학년월일</td>
													<td>${StudentRegisterData.sd_start_date}</td>
													<td class='td_color'>졸업년월일</td>
													<td><c:choose>
																<c:when test="${StudentRegisterData.sd_end_date == null}"><span>-</span></c:when>
																<c:otherwise>
																${StudentRegisterData.sd_end_date}
																</c:otherwise>
															</c:choose></td>
												</tr>
												<tr>
													<td class='td_color'>주소</td>
													<td colspan='3'>${StudentRegisterData.sd_address}</td>
													
												</tr>
												<tr>
													<td class='td_color' rowspan='${RegisterlistSize}'>학적변동</td><!-- size만큼 아래로 늘림 -->
													<!-- 학적변동 for문 시작 -->
													<c:choose>
																<c:when test="${RegisterlistSize == 0}"><td colspan='3'>변동 내역이 없습니다.</td></tr></c:when>
																<c:otherwise>
																
													<c:forEach var='list' items='${Registerlist}' varStatus="status">			
													<c:if test='${status.count == 1}'>
													<td>${list.src_date}</td>
													<td colspan='2'>${list.src_value}</td>
													</tr>
													</c:if>
													<c:if test = '${status.count > 1}' >
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
													<td class='td_color'>부전공</td>
													<td><c:choose>
																<c:when test="${StudentRegisterData.sub_type != '부전공'}">-</c:when>
																<c:otherwise>
																${StudentRegisterData.sub_name}
																</c:otherwise>
															</c:choose></td>
													<td class='td_color'>복수전공</td>
													<td><c:choose>
																<c:when test="${StudentRegisterData.sub_type != '복수전공'}">-</c:when>
																<c:otherwise>
																${StudentRegisterData.sub_name}
																</c:otherwise>
															</c:choose></td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>
								<!-- 학적 테이블 끝 -->

							</div>
						</div>
					</div>
				</div>
				<%
					} else if (check == 2) {
				%>
				<div class="row">
					<div class="col-lg-12">
						<ul id="myTab" class="nav nav-tabs" role="tablist">

							<li role="presentation" class=""><a href="#tab1"
								id="Register-tab1" role="tab" data-toggle="tab"
								aria-controls="tab1" aria-expanded="false">휴학/복학/휴학연장 신청</a></li>
							<li role="presentation" class="active"><a href="#tab2"
								id="Register-tab2" role="tab" data-toggle="tab"
								aria-controls="tab2" aria-expanded="true">학적 조회</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade" id="tab1"
								aria-labelledby="Register-tab1">
								
								<div class="row">
											<div class="col-lg-12">
												<h1 class="page-header">학적변동 내역</h1>
											</div>
								</div>
								<!-- 전체 폼 시작-->
								<form>
									<div class="row">
									<!-- 학적변동 테이블 시작 -->
										<div class="col-lg-12">
										
											<div class="table-responsive">
												<table class="table table-bordered table-hover">
													<thead class="bg-aqua">
														<tr>
															<th>No</th>
															<th>변동내용</th>
															<th>신청날짜</th>
															<th>학적변동날짜</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<c:choose>
																<c:when test="${RegisterlistSize == 0}">
																	<!--count 0이면  -->
																	<td class="text-center" colspan="5">변동 내역이 없습니다.</td>
																</tr>
																</c:when>
																<c:otherwise>
																	<c:forEach var="list" items="${Registerlist}"
																		varStatus="status">
																		<!--리스트 출력 -->
																		<td>${status.count}</td>
																		<td>${list.src_value}</td>
																		<td>${list.src_request_date}</td>
																		<td>${list.src_date}</td>
																		</tr>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														
													</tbody>
												</table>
											</div>
										</div>
										<!-- 학적변동 테이블 끝 -->
										<!-- 학적 ,학기 선택 시작-->

										<div class="col-lg-12 text-left">
											<div class="info-box">
												<div class="row">
													<div class="col-lg-12">
														<h1 class="page-header">학적변동신청</h1>
													</div>
												</div>
												<span class="info-box-icon bg-aqua">학적 선택</span>

												<div class="info-box-content">

													<span class="info-box-text">

														<div>
															<span class="col-lg-4 text-center"
																name="Register_option1" id="Register_option1"></span> <span
																class="col-lg-4 text-center" name="Register_option2"
																id="Register_option2"></span>
														</div> <input type="hidden" name="check" value="1">
													</span>

												</div>

											</div>
											<div class="console col-lg-8"></div>

										</div>
										


										<input type="hidden" name="check" value="1">
										<div class="submit_button col-lg-12 text-left"></div>
										<div class="hidden_item"></div>

										<c:if test="${update_check == 1 && end_year != null }">
											<script>
											
												alert("휴학 신청 완료하였습니다. 휴학 만료는  "+document.getElementById("end_year").value+"학년도 "+document.getElementById("end_semester").value+"학기 이며,\n 관리자 승인 후 휴학이 완료됩니다.");
												//alert("신청 완료하였습니다.");
											</script>
										</c:if>
										<c:if test="${update_check == 1 && end_year == null }">
											<script>
											
												alert("복학 신청 완료하였습니다. \n 관리자 승인 후 복학 완료 됩니다.");
											</script>
										</c:if>
										<!-- 학기선택 끝 -->



									</div>

								</form>
								<!-- 전체 폼 끝-->
							</div>
							<div role="tabpanel" class="tab-pane fade active in" id="tab2"
								aria-labelledby="Register-tab2">
								
								<!-- 학적 테이블 시작 -->
								<div class="col-lg-6">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead ><!-- class="bg-aqua" -->
												<tr>
													<td class='td_color'>학번</td>
													<td>${StudentRegisterData.sd_num}</td>
													<td class='td_color'>학과</td>
													<td>${StudentRegisterData.d_name}</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class='td_color'>이름</td>
													<td>${StudentRegisterData.sd_name}</td>
													<td class='td_color'>학적상태</td>
													<td>${StudentRegisterData.sd_re_loa}</td>
												</tr>
												<tr>
													<td class='td_color'>생년월일</td>
													<td colspan='3'>${StudentRegisterData.sd_jumin}</td>
													
												</tr>
												<tr>
													<td class='td_color'>현재학년</td>
													<td>${StudentRegisterData.sd_grade}</td>
													<td class='td_color'>이수학기</td>
													<td>${StudentRegisterData.sd_semester}</td>
												</tr>
												<tr>
													<td class='td_color'>입학년월일</td>
													<td>${StudentRegisterData.sd_start_date}</td>
													<td class='td_color'>졸업년월일</td>
													<td><c:choose>
																<c:when test="${StudentRegisterData.sd_end_date == null}"><span>-</span></c:when>
																<c:otherwise>
																${StudentRegisterData.sd_end_date}
																</c:otherwise>
															</c:choose></td>
												</tr>
												<tr>
													<td class='td_color'>주소</td>
													<td colspan='3'>${StudentRegisterData.sd_address}</td>
													
												</tr>
												<tr>
													<td class='td_color' rowspan='${RegisterlistSize}'>학적변동</td><!-- size만큼 아래로 늘림 -->
													<!-- 학적변동 for문 시작 -->
													<c:choose>
																<c:when test="${RegisterlistSize == 0}"><td colspan='3'>변동 내역이 없습니다.</td></tr></c:when>
																<c:otherwise>
																
													<c:forEach var='list' items='${Registerlist}' varStatus="status">			
													<c:if test='${status.count == 1}'>
													<td>${list.src_date}</td>
													<td colspan='2'>${list.src_value}</td>
													</tr>
													</c:if>
													<c:if test = '${status.count > 1}' >
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
													<td class='td_color'>부전공</td>
													<td><c:choose>
																<c:when test="${StudentRegisterData.sub_type != '부전공'}">-</c:when>
																<c:otherwise>
																${StudentRegisterData.sub_name}
																</c:otherwise>
															</c:choose></td>
													<td class='td_color'>복수전공</td>
													<td><c:choose>
																<c:when test="${StudentRegisterData.sub_type != '복수전공'}">-</c:when>
																<c:otherwise>
																${StudentRegisterData.sub_name}
																</c:otherwise>
															</c:choose></td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>
								<!-- 학적 테이블 끝 -->
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>

			</div>
		</div>

		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->

	<!-- jQuery -->

</body>

</html>
