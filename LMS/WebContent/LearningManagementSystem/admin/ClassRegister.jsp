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
								aria-controls="tab1" aria-expanded="true">수업등록</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="tab1"
								aria-labelledby="Register-tab1"></div>

							<div class='row'>
								<div class="col-lg-12">
									<h1 class="page-header">수업등록</h1>
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
											</form>

										</div>


									</div>


								</div>

							</div>
							<div class='row'>
								<!-- 강의계획서  교과목 개요 시작 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead class="bg-aqua text-center">
												<tr>
													<!-- <th>No.</th> -->
													<th>No.</th>
													<th>과목명</th>
													<th>이수구분</th>
													<th>담당교수명</th>
													<th>강의 계획서 확인</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${select_option == null}">
														<tr>
															<td class="text-center" colspan="5">조회결과가 없습니다.</td>
														</tr>
													</c:when>
													<c:otherwise>
														<c:forEach var="list" items="${SubjectList}" varStatus="status">
															<tr>
																<td>${status.count}</td>
																<td>${list.s_cp_division}</td>
																<td>${list.s_name}</td>
																<td>${list.pf_name}</td>
																<td><input class='plan_search btn btn-lg bg-aqua' type="button"
																	 id="${list.cp_num}"
																	value="조회하기"></td>
															</tr>
														</c:forEach>
													</c:otherwise>
												</c:choose>

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
