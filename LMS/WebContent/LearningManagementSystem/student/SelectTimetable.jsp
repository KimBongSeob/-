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



</head>


<body>

	<div id="wrapper">


		<%@include file="/LearningManagementSystem/student/head.jsp"%>


		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">시간표 조회</h1>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
							
									<!-- 강의계획서 목록 시작 -->
									<div class="col-lg-12">
										<div class="table-responsive">
											<table class="table table-bordered table-hover text-center">
												<thead>
													<!-- class="bg-aqua" -->
															<tr>
														<td class='bg-aqua'>개설년도</td>
														<td class='bg-aqua'>개설학기</td>
														<td class='bg-aqua'>이수구분</td>
														<td class='bg-aqua'>이수학점</td>
														<td class='bg-aqua'>학수번호</td>
														<td class='bg-aqua'>교과목명</td>
														<td class='bg-aqua'>교수이름</td>
														<td class='bg-aqua'>강의시간/요일</td>
														<td class='bg-aqua'>강의 최대인원/현재인원</td>
														<td class='bg-aqua'>강의실번호</td>
														
													</tr>
												</thead>
												<tbody>

													<c:forEach var="list" items="${ClassRequestList}">
														<tr>
															<td>${list.cp_year}</td>
															<td>${list.cp_semester}</td>
															<td>${list.s_cp_division}</td>
															<td>${list.s_cp_credits}</td>
															<td>${list.s_num}</td>
															<td>${list.s_name}</td>
															<td>${list.pf_name}</td>
															<td>${list.cp_time}</td>
															<td>${list.cp_current_no}/${list.cp_max_no}</td>
															<td>${list.cr_num}</td>

															
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
																	

</body>

</html>