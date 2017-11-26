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
alert("등록 하였습니다.");
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
									<h1 class="page-header">조회</h1>
								</div>
								<div class="col-lg-12 text-left">
									<div class="info-box">
										<div class="row"></div>
										<span class="info-box-icon bg-aqua">강의계획서 조회</span>

										<div class="info-box-content"></div>

									</div>
									<div class="console col-lg-8"></div>

								</div>
								<!-- 전체 form 시작 -->
								<form onsubmit='return planList_Check(this)'>
								<!-- 강의계획서 테이블 시작 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead>
												<!-- class="bg-aqua" -->
												<tr>
													<td class='td_color'>작성일자</td>
													<td><input type="text" class="form-control"
														id="CP_DATE" name='CP_DATE' value="${date}" readonly></td>
														<td class='td_color'>개설학년</td>
													<td><input type="text" class="form-control"
														id="CP_YEAR" name='CP_YEAR'></td>
														<td class='td_color'>개설학기</td>
													<td><input type="text" class="form-control"
														id="CP_SEMESTER" name='CP_SEMESTER' ></td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class='td_color'>교과목명</td>
													<td><div id='Subject_div'>
															<select class="form-control" name="Subject_option"
																id="Subject_option">
																<option value="선택">선택</option>

															</select>
														</div></td>
													<td class='td_color'>학수번호</td>
													<td colspan='3'><input type="text" class="form-control" id="S_NUM"
														name="S_NUM" readonly></td>
												</tr>
												<tr>
													<td class='td_color'>학점</td>
													<td><input type="text" class="form-control"
														id="S_CP_CREDITS" name="S_CP_CREDITS" readonly></td>
													<td class='td_color'>강의시간</td>
													<td colspan='3'><input type="text" class="form-control"
														id="CP_TIME" name="CP_TIME"></td>

												</tr>
												<tr>
													<td class='td_color'>개설학과</td>
													<td><select class="form-control"
														name="Department_option" id="Department_option">
															<!--onchange = "selectOnchange(this.value)  -->
															<option value="선택">선택</option>
															<option value="00">교양</option>
															<c:if test="${ProfessorData.d_num != null}">
															<option value="${ProfessorData.d_num}">${ProfessorData.d_name}</option>
															</c:if>

													</select></td>
													<td class='td_color'>강의실</td>
													<td colspan='3'><input type="text" class="form-control"
														id="CR_NUM" name="CR_NUM"></td>
												</tr>
												<tr>
													<td class='td_color'>담당교수</td>
													<td><input type="text" class="form-control"
														id="PF_NAME" name="PF_NAME" value='${ProfessorData.pf_name}'
														readonly></td>
														<input type='hidden' value='${ProfessorData.pf_num}' name='PF_NUM'>
													<td class='td_color'><div>e-mail</div></td>
													<td colspan='3'><div>
															<input type="text" class="form-control" id="PF_EMAIL" name="PF_EMAIL"
																value='${ProfessorData.pf_email}' readonly>
														</div></td>
												</tr>
												<tr>
													<td class='td_color'>이수구분</td>
													<td><input type="text" class="form-control"
														id="S_CP_DIVISION" name="S_CP_DIVISION" value='' readonly></td>
														<td class='td_color'>강의 최대인원</td><!--CP_MAX_NO  -->
													<td colspan='3'><input type="text" class="form-control"
														id="CP_MAX_NO" name="CP_MAX_NO"></td>




												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 테이블 끝 -->
								<!-- 강의계획서  교과목 개요 시작 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead>
												<!-- class="bg-aqua" -->
												<tr>
													<td class='td_color' colspan='4'>1.교과목 개요</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>
														<div class='divSize_h'>
															<textarea class='textAreaSize' id='CP_OUTLINE' name='CP_OUTLINE'></textarea>
														</div>
													</td>
												</tr>


											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 교과목 개요 끝 -->
								<!-- 강의계획서 교재 및 부교재 끝 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead>
												<!-- class="bg-aqua" -->
												<tr>
													<td class='td_color' colspan='4'>2.교재 및 부교재</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class='divSize_w'>교재</td>
													<td><div>
															<input type="text" class="form-control" id="CP_TEXTBOOK" name="CP_TEXTBOOK">
														</div></td>
												</tr>
												<tr>
													<td class='divSize_w'>부교재</td>
													<td><div>
															<input type="text" class="form-control" id="CP_SUB_TEXTBOOK" name="CP_SUB_TEXTBOOK">
														</div></td>
												</tr>
												<tr>
											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 교재 및 부교재 끝 -->
								<!-- 강의계획서 평가방법 끝 -->
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-bordered table-hover">
											<thead>
												<!-- class="bg-aqua" -->
												<tr>
													<td class='td_color' colspan='4'>3.평가방법</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class='divSize_w'><div>평가방법</div></td>
													<td><div>
															<input type="text" class="form-control" id="CP_VALUATION" name="CP_VALUATION">
														</div></td>
												</tr>	
											</tbody>
										</table>
									</div>
								</div>
								<!-- 강의계획서 평가방법 끝 -->
								<div class="col-lg-12 text-center">
									<input type="submit" class="btn btn-lg bg-aqua divSize_w"
										name="ClassPlan_Submitbutton" id="ClassPlan_Submitbutton"
										value="등록">
								</div>
								
								</form>
								<!-- 전체 form 끝 -->
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>



</body>

</html>
