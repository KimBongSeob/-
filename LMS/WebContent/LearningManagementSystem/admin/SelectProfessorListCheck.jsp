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
						<h1 class="page-header">교수 관리 조회</h1>
					</div>
				</div>
				<!-- /.row -->

				<!-- 학적 테이블 시작 -->
				<div class="col-lg-6">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<!-- class="bg-aqua" -->
								<c:forEach var="list" items="${ProfessorList}">
									<tr>

										<td class='td_color'>교번</td>
										<td>${list.pf_num}</td>
										<td class='td_color'>학과</td>
										<td>${list.d_name}</td>
									</tr>
							</thead>
							<tbody>
								<tr>
									<td class='td_color'>이름</td>
									<td>${list.pf_name}</td>
									<td class='td_color'>생년월일</td>
									<td colspan='3'>${list.pf_jumin}</td>
									<%-- <td class='td_color'></td>
									<td>${list.pf_re_loa}</td> --%>
								</tr>
								<tr>
									<td class='td_color'>연락처</td>
									<td colspan='3'>${list.pf_hpone}</td>

								</tr>
								<tr>
									<td class='td_color'>이메일</td>
									<td>${list.pf_email}</td>
									<td class='td_color'>주소</td>
									<td>${list.pf_address}</td>
								</tr>
					
									</c:forEach>	
								</tr>	
							</tbody>
						</table>
						<div colspan="4" class="pull-right">
	<!-- 					<input type=button class="btn btn-lg bg-aqua" value="수정"> -->
                		<input type=button class="btn btn-lg bg-aqua" value="목록" OnClick="window.location='/LMS/LearningManagementSystem/AllDepartmentProfessor.do?select_option=${select_option}'">
                		</div>
					</div>
				</div>
				
				<!-- 학적 테이블 끝 -->
</body>
</html>