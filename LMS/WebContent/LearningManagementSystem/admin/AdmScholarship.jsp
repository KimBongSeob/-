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
		<%@include file="/LearningManagementSystem/admin/head.jsp"%>

		<!-- head 끝 -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">장학금 관리</h1>
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
								aria-controls="tab1" aria-expanded="true">장학금 관리</a></li>

						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="tab1"
								aria-labelledby="Register-tab1"></div>

							<div class='row'>
								<div class="col-lg-12">
									<h1 class="page-header">성적조회 및 장학금 수여</h1>
								</div>
								<div class="col-lg-12">
									<div class="info-box">
										<form method='post'>
											<span class="info-box-icon bg-aqua">성적조회</span>
											
											<div class="col-lg-2">
											<span class="info-box-icon bg-aqua">과</span>
												<select class="form-control" name="Department_option">

													<option value="선택">선택</option>
													<c:forEach var="list" items="${Departmentlist}">
														<option value="${list.d_num}">${list.d_name}</option>
														<!--value:과코드 , 내용:과이름 -->
													</c:forEach>

												</select>


											</div>
											
											<div class="col-lg-2">
											<span class="info-box-icon bg-aqua">학년도</span>
												<select class="form-control" name="Year_option">
													<option value="2017">2017</option>
													<option value="2016">2016</option>
												</select>
											</div>
											<div class="col-lg-2">
											<span class="info-box-icon bg-aqua">학년</span>
												<select class="form-control" name="Grade_option">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
												</select>
											</div>
											<div class="col-lg-2">
											<span class="info-box-icon bg-aqua">학기</span>
												<select class="form-control"
													name="Semester_option">
													<option value="1">1</option>
													<option value="2">2</option>
												</select>
											</div>
											<span class="info-box-icon bg-white">&nbsp</span>
											<div class="col-lg-2">
											
												<button type="submit" class="btn btn-lg bg-aqua">조회</button>
											</div>
										</form>
									</div>
								</div>
								<div class="console col-lg-8"></div>

							</div>
							<!-- 테이블 추가 -->
							<div class='row'>
								<!-- 과 선택 시작-->

								<!-- 과 선택 끝 -->
								<!-- 테이블 추가 끝 -->
							</div>
							<div class='row'>
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead>
												<!-- class="bg-aqua" -->
												<tr>
													<td class='bg-aqua'>No</td>
													<td class='bg-aqua'>과이름</td>
													<td class='bg-aqua'>학년</td>
													<td class='bg-aqua'>학번</td>
													<td class='bg-aqua'>이름</td>
													<td class='bg-aqua'>총학점평균</td>
													<td class='bg-aqua text-center'>수여</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${studentList}"
													varStatus="status">
													<tr>
														<td>${status.count}</td>
														<td>${list.d_name}</td>
														<td>${list.sd_grade}</td>
														<td>${list.sd_num}</td>
														<td>${list.sd_name}</td>
														<td>${list.s_sum}</td>
														<td><input class='plan_search btn btn-lg bg-aqua'
															type="button" id="" value="수여하기"
															onclick="window.open('/LMS/LearningManagementSystem/AdmScholarshipPro.do?sd_num=${list.sd_num}&Year_option=${Year_option}&Semester_option=${Semester_option}&Department_option=${Department_option}&Grade_option=${Grade_option}','window팝업','width=500, height=200,left=700, top=400, menubar=no, location=no, resizable=no, status=no, toolbar=no');"></td>
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
								</div>
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
