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
						<h1 class="page-header">통계</h1>
					</div>
				</div>
				<!-- /.row -->

				<!-- 학적 테이블 시작 -->
				<div class="col-lg-6">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<!-- class="bg-aqua" -->
								
								<td class='info-box-icon bg-aqua text-center'>전체 통계</td>								
								<span>
									<tr>
									<td class='td_color text-center'>전체 학생 수</td>
									<td class='td_color text-center'>전체 교수 수</td>
									<td class='td_color text-center'>전체 학과 수</td>
									<td class='td_color text-center'>전체 과목 수</td>
									</tr>
									
									<tr>
									<td class='text-center'>${count2}</td>
									<td class='text-center'>${count1}</td>
									<td class='text-center'>${count}</td>
									<td class='text-center'>${count3}</td>
									</tr>							
								</span>
							</tbody>
						</table>
						
					</div>
				</div>
				
				<!-- 학적 테이블 끝 -->
</body>
</html>