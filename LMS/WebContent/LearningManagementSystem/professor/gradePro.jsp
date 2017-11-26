pro

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

<%@include file="/LearningManagementSystem/professor/css_script.jsp"%>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<script>

if(self.name != 'reload') {
	self.name = 'reload';
	self.location.reload(true);
}
else self.name ='';

</script>




<body>

	<div id="wrapper">

		<!-- head ?κ? -->
		<%@include
			file="/LearningManagementSystem/professor/head_professor.jsp"%>

		<!-- head ?? -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">성적조회</h1>
					</div>
				</div>
				<!-- /.row -->
<form>

<input type='hidden' id='cp_num' name='cp_num' value='${cp_num}'>
				<!-- ???????? ????? ???? -->
				<div class="col-lg-8">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead class="bg-aqua">
								<tr>
									<th>학수번호</th>
									<th>개설학기</th>
									<th>구분</th>
									<th>교과목이름</th>
									<th>강의요일 및 시간</th>
									<th>강의실</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${getGradeProlist}">
									<tr>
										<td>${list.cp_num}</td>
										<td>${list.cp_semester}</td>
										<td>${list.s_cp_division}</td>
										<td>${list.s_name}</td>
										<td>${list.cp_time}</td>
										<td>${list.cr_num}</td>
									</tr>
									<input name="cp_num" type="hidden" value="${list.cp_num}">
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
				<div class="col-lg-8">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead class="bg-aqua">
								<tr>
									<th>학번</th>
									<th>이름</th>
									<th>학점</th>
									<th>수강신청번호</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${StudentGradelist}">
									<tr>
										<td>${list.sd_num}</td>
										<td>${list.sd_name}</td>
										<td>${list.g_sum}</td>
										<td>${list.cr_num}</td>
										<td><span style="float:left;"><select class="form-control" name="SdGrade" id='SdGrade'>
												<option value="">입력해주세요</option>
												<option value='4.5'>A+</option>
												<option value='4.0'>A0</option>
												<option value='3.5'>B+</option>
												<option value='3.0'>B0</option>
												<option value='2.5'>C+</option>
												<option value='2.0'>C0</option>
												<option value='1.5'>D+</option>
												<option value='1.0'>D0</option>
												<option value='0.5'>F</option>
										</select><input class='change_button' id='${list.cr_num}' type='button' value="수정"></span></td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
</form>
				<input type=button value="목록으로" class="btn btn-lg bg-aqua" onClick="history.back()">
				<!-- ???????? ????? ?? -->

			</div>
		</div>

		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->

	<!-- jQuery -->

</body>
</html>