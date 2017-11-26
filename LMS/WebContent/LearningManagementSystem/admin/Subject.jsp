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

<script type="text/javascript">
function check(){
alert("정상적으로 등록되었습니다.");
}
</script>

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
						<h1 class="page-header">과목관리</h1>
					</div>
				</div>
				<!-- /.row -->


				<div class="row">
					<div class="col-lg-12 text-center">

						<!-- 학기선택 시작-->
						<div class="col-lg-12 text-left">
							<div class="info-box">
								<span class="info-box-icon bg-aqua">학과선택</span>

								<div class="info-box-content">
									<form>
										<span class="info-box-text">
											<div class="col-lg-4 text-center">
												<div class="panel panel-default">

													<select class="form-control" id="select_option"
														name="select_option">

														<%-- <c:choose> --%>
														<%-- <c:when test="${size == 0}">
                                <option value="" selected>선택하세요.</option>
                                </c:when> --%>
														<%-- <c:when test="${size > 0}"> --%>
														<option value="" selected>선택하세요.</option>
														<c:forEach var="list" items="${DepartmentList}"
															varStatus='status'>
															<option value="${list.d_num}">${list.d_name}</option>
														</c:forEach>
														<%-- </c:when> --%>

														<%-- </c:choose> --%>
													</select>

												</div>

											</div>

											<button type="submit" class="btn btn-lg bg-aqua"
												OnClick="window.location='/LMS/LearningManagementSystem/admin/SelectStudentListCheck.do?sd_num=${list.sd_num}'">조회</button>
											<!-- <input type="hidden" name="check" value="1"> -->

											<button type="button" id='submit_student_button' value="등록 "
												class="btn btn-lg bg-aqua"
												onclick="subject_Check(<c:choose>
                           		<c:when test="${d_num == null || d_num == ''}">''</c:when>
                           		<c:otherwise>'${d_num}'</c:otherwise>
                           	</c:choose>)">등록</button>

										</span>
									</form>



									<!-- <input type="hidden" name="check" value="2"> -->


								</div>
							</div>
						</div>

						<!-- 학기선택 끝 -->
						<!-- 장학금명/장학금액 테이블 시작 -->

						<div class="col-lg-6">
							<div class="table-responsive">
								<form>
									<table class="table table-bordered table-hover">
										<thead class="bg-aqua">
											<tr>
												<!-- <th>No.</th> -->
												<th>학수번호</th>
												<th>이수구분</th>
												<th>학점</th>
												<th>과목이름</th>
												<th>삭제</th>
											</tr>
										</thead>

										<tbody>


											<c:choose>
												<c:when test="${select_option == '' || size == 0}">
													<tr>
														<td class="text-center" colspan="5">조회결과가 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
													<c:forEach var="list" items="${SubjectList}">
														<tr>
															<%-- <td>${list.no}</td> --%>
															<td>${list.s_num}</td>
															<td>${list.s_cp_division}</td>
															<td>${list.s_cp_credits}</td>
															<td>${list.s_name}</td>
															<td><button type="button" value="글삭제"
																	class="btn btn-lg bg-aqua"
																	onclick="document.location.href='/LMS/LearningManagementSystem/SubjectDelete.do?s_num=${list.s_num}&d_num=${d_num}'">삭제</button></td>

														</tr>
												</c:forEach>
												</c:otherwise>
											</c:choose>


										</tbody>
									</table>
								</form>
							</div>
						</div>
						<!-- 장학금명/장학금액 테이블 끝 -->

					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- /.container-fluid -->


	<!-- /#page-wrapper -->
	<!-- /#wrapper -->

	<!-- jQuery -->

</body>

</html>