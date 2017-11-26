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


<%@include file="/LearningManagementSystem/student/css_script.jsp"%>

</head>
<body>
	<c:if test="${count > 0}">
		<script>
			alert("수강신청 되었습니다.");
			opener.document.location.href='/LMS/LearningManagementSystem/Classrequest.do';
			self.close();
		</script>
	</c:if>
	<c:if test="${count == -2}">
		<script>
		alert("이미 수강신청하신 과목은 신청하실 수 없습니다.");
		self.close();
		</script>
	</c:if>
	<c:if test="${count == -1}">
		<script>
			alert("인원이 초과하였습니다.");
			self.close();
		</script>
	</c:if>
	<div class='row'>
		<div class="col-lg-12">
			<h1 class="page-header">조회</h1>
		</div>
		<div class="col-lg-12 text-left">
			<div class="info-box">
				<div class="row"></div>
				<span class="info-box-icon bg-aqua">강의계획서 조회</span>

				<div class="info-box-content"></div>

			</div>
			<div class="console col-lg-8"></div>

		</div>
		<!-- 전체 form 시작 -->
		<form name='c_form' id='c_form' onsubmit='return planList_Check(this)'>
			<!-- 강의계획서 테이블 시작 -->
			<div class="col-lg-12">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<!-- class="bg-aqua" -->
							<tr>
								<input type='hidden' id='CP_NUM' name='CP_NUM' value='${cp_num}'>
								<input type='hidden' id='SD_NUM' name='SD_NUM' value='${sd_num}'>
								<td class='td_color'>작성일자</td>
								<td><input type="text" class="form-control" id="CP_DATE"
									name='CP_DATE' value="${data.cp_date}" readonly></td>
								<td class='td_color'>개설학년</td>
								<td><input type="text" class="form-control" id="CP_YEAR"
									name='CP_YEAR' value="${data.cp_year}" readonly></td>
								<td class='td_color'>개설학기</td>
								<td><input type="text" class="form-control"
									id="CP_SEMESTER" name='CP_SEMESTER' value="${data.cp_semester}"
									readonly></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class='td_color'>교과목명</td>
								<td><input type="text" class="form-control"
									id="Subject_option" name='Subject_option'
									value="${data.s_name}" readonly></td>
								<td class='td_color'>학수번호</td>
								<td colspan='3'><input type="text" class="form-control"
									id="S_NUM" name="S_NUM" value="${data.s_num}" readonly></td>
							</tr>
							<tr>
								<td class='td_color'>학점</td>
								<td><input type="text" class="form-control"
									id="S_CP_CREDITS" name="S_CP_CREDITS"
									value="${data.s_cp_credits}" readonly></td>
								<td class='td_color'>강의시간</td>
								<td colspan='3'><input type="text" class="form-control"
									id="CP_TIME" name="CP_TIME" value="${data.cp_time}" readonly></td>

							</tr>
							<tr>
								<td class='td_color'>개설학과</td>
								<td><input type="text" class="form-control"
									id="Department_option" name="Department_option"
									value="${data.d_name}" readonly></td>

								<td class='td_color'>강의실</td>
								<td colspan='3'><input type="text" class="form-control"
									id="CR_NUM" name="CR_NUM" value="${data.cr_num}" readonly></td>
							</tr>
							<tr>
								<td class='td_color'>담당교수</td>
								<td><input type="text" class="form-control" id="PF_NAME"
									name="PF_NAME" value="${data.pf_name}" readonly></td>
								<td class='td_color'><div>e-mail</div></td>
								<td colspan='3'><div>
										<input type="text" class="form-control" id="PF_EMAIL"
											name="PF_EMAIL" value="${data.pf_email}" readonly>
									</div></td>
							</tr>
							<tr>
								<td class='td_color'>이수구분</td>
								<td><input type="text" class="form-control"
									id="S_CP_DIVISION" name="S_CP_DIVISION"
									value="${data.s_cp_division}" readonly></td>
								<td class='td_color'>강의 최대인원</td>
								<!--CP_MAX_NO  -->
								<td colspan='3'><input type="text" class="form-control"
									id="CP_MAX_NO" name="CP_MAX_NO" value="${data.cp_max_no}"
									readonly></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 강의계획서 테이블 끝 -->
			<!-- 강의계획서  교과목 개요 시작 -->
			<div class="col-lg-12">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<!-- class="bg-aqua" -->
							<tr>
								<td class='td_color' colspan='4'>1.교과목 개요</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class='divSize_h'>
										<textarea class='textAreaSize' id='CP_OUTLINE'
											name='CP_OUTLINE' readonly>${data.cp_outline}</textarea>
									</div>
								</td>
							</tr>


						</tbody>
					</table>
				</div>
			</div>
			<!-- 강의계획서 교과목 개요 끝 -->
			<!-- 강의계획서 교재 및 부교재 끝 -->
			<div class="col-lg-12">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<!-- class="bg-aqua" -->
							<tr>
								<td class='td_color' colspan='4'>2.교재 및 부교재</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class='divSize_w'>교재</td>
								<td><div>
										<input type="text" class="form-control" id="CP_TEXTBOOK"
											name="CP_TEXTBOOK" value="${data.cp_textbook}" readonly>
									</div></td>
							</tr>
							<tr>
								<td class='divSize_w'>부교재</td>
								<td><div>
										<input type="text" class="form-control" id="CP_SUB_TEXTBOOK"
											name="CP_SUB_TEXTBOOK" value="${data.cp_sub_textbook}"
											readonly>
									</div></td>
							</tr>
							<tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 강의계획서 교재 및 부교재 끝 -->
			<!-- 강의계획서 평가방법 끝 -->
			<div class="col-lg-12">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<!-- class="bg-aqua" -->
							<tr>
								<td class='td_color' colspan='4'>3.평가방법</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class='divSize_w'><div>평가방법</div></td>
								<td><div>
										<input type="text" class="form-control" id="CP_VALUATION"
											name="CP_VALUATION" value="${data.cp_valuation}" readonly>
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 강의계획서 평가방법 끝 -->
			<div class="col-lg-12 text-center">
				<input type="submit" class="btn btn-lg bg-aqua divSize_w"
					name="ClassPlan_Submitbutton" id="ClassPlan_Submitbutton"
					value="신청">
			</div>

		</form>
		<!-- 전체 form 끝 -->
	</div>
</body>
</html>