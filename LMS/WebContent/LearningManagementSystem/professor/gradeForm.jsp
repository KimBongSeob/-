<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>학사관리시스템</title>

<!-- Bootstrap Core CSS -->
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

		<!-- head �κ� -->
		<%@include
			file="/LearningManagementSystem/professor/head_professor.jsp"%>

		<!-- head �� -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">성적관리</h1>
					</div>
				</div>
				<!-- /.row -->
				<div class="col-lg-6 text-left">
					<div class="info-box">
						<span class="info-box-icon bg-aqua">학기선택</span>

						<div class="info-box-content">
							<!-- 박스옆text -->
							<form>
								<span class="info-box-text">
									<div class="col-lg-7 text-center">
										<div class="panel panel-default">

											<select class="form-control" name="select_option">
											<c:choose>
                                 			<c:when test="${size == 0}">
                               				 <option value="">학기선택</option>
                               				 </c:when>
                               				 <c:when test="${size > 0}">
												<option value="">학기선택</option>
												<c:forEach var="list" items="${getYearSemester}">
													<option value="${list.cp_year},${list.cp_semester}">${list.cp_year}년도&nbsp;${list.cp_semester}학기</option>
												</c:forEach>
												</c:when>
                               				  </c:choose>				
											</select>
										</div>
									</div>
									<button type="submit" class="btn btn-lg bg-aqua">조회</button>
								</span>
							</form>
						</div>
					</div>
				</div>
				<!-- �������� ���̺� ���� -->
				<div class="col-lg-11">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead class="bg-aqua">
								<tr>
									<th>학수번호</th>
									<th>개설년도</th>
									<th>개설학기</th>
									<th>구분</th>
									<th>교과목이름</th>
									<th>강의요일 및 시간</th>
									<th>강의실</th>
									<th>학점조회</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${list}">								
									<tr>
										<td>${list.cp_num}</td>
										<td>${list.cp_year}</td>
										<td>${list.cp_semester}</td>
										<td>${list.s_cp_division}</td>
										<td>${list.s_name}</td>
										<td>${list.cp_time}</td>
										<td>${list.cr_num}</td>
										<%-- <th><button onclick="javascript:location.href='GradePro.do?cp_num=${list.cp_num}'">조회</button></th> --%>
										<!-- <td><button type="submit">조회</button> -->
										<%-- <td><button type="button" onclick="document.location.href='/LMS/LearningManagementSystem/professor/gradePro.do?pf_num=${list.pf_num}?cp_num=${list.cp_num}'">조회</button></td> --%>
										<td><input type=button value="조회" OnClick="window.location='/LMS/LearningManagementSystem/professor/gradePro.do?cp_num=${list.cp_num}'"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
					</div>
				</div>
				<!-- �������� ���̺� �� -->

			</div>
		</div>

		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->

	<!-- jQuery -->

</body>
</html>
