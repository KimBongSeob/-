<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">
<%@include file="/LearningManagementSystem/admin/css_script.jsp"%>

<script>
function writeSave() {
	   if (document.registerform.sd_num.value == "") {
	      alert("학번을 입력하세요.");
	      documentregisterform.sd_num.focus();
	      return false;
	   }
	   if (document.registerform.sd_passwd.value == "") {
	      alert("비밀번호를 입력하세요.");
	      document.registerform.sd_passwd.focus();
	      return false;
	   }

	   if (document.registerform.sd_name.value == "") {
	      alert("이름을 입력하세요.");
	      document.registerform.content.focus();
	      return false;
	   }

	   if (document.registerform.sd_jumin.value == "") {
	      alert(" 생년월일을 입력하세요.");
	      document.registerform.sd_jumin.focus();
	      return false;
	   }
	}
</script>
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
						<h1 class="page-header">등록</h1>
					</div>
				</div>
				<!-- /.row -->
				<!-- 학적 테이블 시작 -->
				<div class="col-lg-6">


					<div class="table-responsive">
						<form method="post" name="regist"
							action="/LMS/LearningManagementSystem/RegisterDepartment.do">

							<table class="table table-bordered table-hover">
								<thead>
									<!-- class="bg-aqua" -->
									<tr>
									<td class='info-box-icon bg-aqua text-center'>등록</td>
									</tr>
									<tr>
										<td class='td_color text-center'>학과번호</td>
										<td class='text-center'><input type="text" size="10"
											maxlength="10" name="d_num" value='${d_num}' readonly></td>
									</tr>
									<tr>

										<td class='td_color text-center'>학과명</td>
										<td class='text-center'><input type="text" size="10" maxlength="10" name="d_name"></td>

									</tr>
								</tbody>
							</table>
					</div>
					<button type="submit" value="등록 " class="btn btn-lg bg-aqua">등록</button>
					</form>

				</div>

				<!-- 학적 테이블 끝 -->
</body>
</html>