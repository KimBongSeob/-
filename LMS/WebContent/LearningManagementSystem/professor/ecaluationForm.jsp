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

<title>학사관리 시스템</title>

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

		<!-- head 부분 -->
		<%@include
			file="/LearningManagementSystem/professor/head_professor.jsp"%>

		<!-- head 끝 -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">강의평가</h1>
					</div>
				</div>
				<!-- /.row -->

				<!-- 학기선택 시작-->
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
				<!-- 학기선택 끝 -->
				<!-- 장학금명/장학금액 테이블 시작 -->
				<div class="col-lg-12">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead class="bg-aqua">
								<tr>
									<th>개설년도</th>
									<th>개설학기</th>
									<th>주관학과</th>
									<th>학수번호</th>
									<th>과목명</th>
									<th>학점</th>
									<th>평가조회</th>
								</tr>
							</thead>
							<tbody>
									<c:choose>
									<c:when test="${select_option == ''}">
                                    <td class="text-center" colspan="5">개설년도,학기를 선택해주세요.</td>
                                    </c:when>
                                    <c:otherwise>
									<c:forEach var="list" items="${Ecaluationlist}">
									<tr>
										<td>${list.cp_year}</td>
										<td>${list.cp_semester}</td>
										<td>${list.d_name}</td>
										<td>${list.s_num}</td>
										<td>${list.s_name}</td>
										<td>${list.s_cp_credits}</td>
										<td><input type="button" value="조회" onclick="window.open('/LMS/LearningManagementSystem/professor/EcaluationPro.do?cp_num=${list.cp_num}','window팝업','width=500, height=200,left=700, top=400, menubar=no, location=no, resizable=no, status=no, toolbar=no');"></td>
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

		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->

	<!-- jQuery -->

</body>
</html>
