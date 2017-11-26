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
						<h1 class="page-header">과 관리</h1>
					</div>
				</div>
				<!-- /.row -->
				<span class="info-box-icon bg-aqua">과 목록</span>
				<form>
				<span class="info-box-icon bg-white">&nbsp</span>
				<span class="info-box-icon bg-white">&nbsp</span>
				<input type="button" class="btn btn-lg bg-aqua" value='등록' onclick="document.location.href='/LMS/LearningManagementSystem/admin/RegisterDepartmentForm.do'">


				<div class="row">
					<div class="col-lg-12 text-center">

						<!-- 장학금명/장학금액 테이블 시작 -->

						<div class="col-lg-6">
							<div class="table-responsive">
								
									<table class="table table-bordered table-hover">
										<thead class="bg-aqua">
											<tr>
												<!-- <th>No.</th> -->
												<th>과번호</th>
												<th>과이름</th>
												<th>삭제</th>
											</tr>
										</thead>

										<tbody>
											<tr>


												<c:forEach var="list" items="${DepartmentList}">
													<%-- <td>${list.no}</td> --%>
													<td>${list.d_num}</td>
													<td>${list.d_name}</td>
													<td><button type="button" value="글삭제"
															class="btn btn-lg bg-aqua"
															onclick="document.location.href='/LMS/LearningManagementSystem/admin/deleteDepartment.do?d_num=${list.d_num}'">삭제</button></td>

													<tr>
												</c:forEach>
											</tr>

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