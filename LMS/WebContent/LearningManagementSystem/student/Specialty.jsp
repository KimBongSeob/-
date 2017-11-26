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

	<c:if test='${count > 0}'>
		<script>
			alert("신청 완료되었습니다.");
		</script>
	</c:if>
	<c:if test='${count == -1}'>
		<script>
			alert("이미 신청하였습니다.\n중복신청은 불가능 합니다.");
		</script>
	</c:if>
	<c:if test='${count == -2}'>
		<script>
			alert("해당 학과는 이미 가지고 있는 전공 입니다.\n 다른 학과를 선택해주세요.");
		</script>
	</c:if>
	<c:if test='${count == 0}'>
		<script>
			alert("이미 부전공이나 복수전공인 상태입니다.\n부전공이나 복수전공이 없는 학생만 신청 가능합니다.");
		</script>
	</c:if>
	<script>
		function writeSave(list) {
			if (list.select_option.value == "") {
				alert("학과를 선택해주세요.");
				return false;
			}
		}
	</script>
	<div id="wrapper">

		<!-- head 부분 -->
		<%@include file="/LearningManagementSystem/student/head.jsp"%>

		<!-- head 끝 -->
		<div id="page-wrapper">

			<div class="container-fluid">
				<!--         <div class="container-fluid"> -->

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">복수/부전공 신청</h1>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12 text-center">

						<!-- 학기선택 시작-->
						<div class="col-lg-12 text-left">
							<div class="info-box">
								<!-- <span class="info-box-icon bg-aqua">복수/부전공 신청</span> -->
								<span>복수/부전공 신청</span>

								<div class="form-group">
									<form class="form-group" onsubmit='return writeSave(this);'>
										<span class="info-box-text">
											<div class="col-lg-4 text-center">
												<div class="panel panel-default">
													<table class="table">
														<tr>
															<td class="info-box-icon bg-aqua">신청구분</td>

															<td><input type="radio" name="major" value="major1"
																checked>복수전공 <input type="radio" name="major"
																value="major2">부전공</td>

														</tr>

														<tr>
															<td class="info-box-icon bg-aqua">희망전공</td>
															<td><select class="form-control"
																name="select_option">
																	<option value="" selected>학과 선택</option>
																	<c:forEach var="list" items="${DepartmentList}" varStatus="status">
																	<c:if test='${status.count != 1}'>
																		<option value="${list.d_num}">${list.d_name}</option>
																	</c:if>
																		
																	</c:forEach>
															</select></td>
														</tr>
													</table>
												</div>
											</div>
										</span>

										<button type="submit" class="btn btn-lg bg-aqua">신청하기</button>

									</form>

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