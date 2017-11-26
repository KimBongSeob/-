<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>학사관리 프로그램</title>


<!-- Bootstrap Core CSS -->
<link href="/LMS/LearningManagementSystem/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/LMS/LearningManagementSystem/css/sb-admin.css"
	rel="stylesheet">
<link href="/LMS/LearningManagementSystem/css/student_css.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="/LMS/LearningManagementSystem/css/plugins/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/LMS/LearningManagementSystem/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link href="/LMS/LearningManagementSystem/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css">



<!-- script -->


<script src="/LMS/LearningManagementSystem/js/student.js"></script>
<script src="/LMS/LearningManagementSystem/js/jquery.js"></script>
<script src="/LMS/LearningManagementSystem/js/bootstrap.min.js"></script>
<script
	src="/LMS/LearningManagementSystem/js/plugins/morris/raphael.min.js"></script>
<script
	src="/LMS/LearningManagementSystem/js/plugins/morris/morris.min.js"></script>
<script
	src="/LMS/LearningManagementSystem/js/plugins/morris/morris-data.js"></script>

<script
	src="/LMS/LearningManagementSystem/js/plugins/flot/jquery.flot.js"></script>
<script
	src="/LMS/LearningManagementSystem/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script
	src="/LMS/LearningManagementSystem/js/plugins/flot/jquery.flot.resize.js"></script>
<script
	src="/LMS/LearningManagementSystem/js/plugins/flot/jquery.flot.pie.js"></script>
<script src="/LMS/LearningManagementSystem/js/plugins/flot/flot-data.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<script>
	$(function() {
		
		$(document).on("click", ".plan_search", function() {
			var id = $(this).attr("id");
			var url = "admin/check/Plan_search.jsp";
			$.get(url, {
				"id" : id
			}, function(data) {
				var CP_NUM = $(data).find("CP_NUM").text();
				var CP_DATE = $(data).find("CP_DATE").text();
				var CP_YEAR = $(data).find("CP_YEAR").text();
				var CP_SEMESTER = $(data).find("CP_SEMESTER").text();
				var S_NAME = $(data).find("S_NAME").text();
				var S_NUM = $(data).find("S_NUM").text();
				var S_CP_CREDITS = $(data).find("S_CP_CREDITS").text();
				var CP_TIME = $(data).find("CP_TIME").text();
				var D_NUM = $(data).find("D_NUM").text();
				var D_NAME = $(data).find("D_NAME").text();
				var CR_NUM = $(data).find("CR_NUM").text();
				var PF_NUM = $(data).find("PF_NUM").text();
				var PF_NAME = $(data).find("PF_NAME").text();
				var PF_EMAIL = $(data).find("PF_EMAIL").text();
				var S_CP_DIVISION = $(data).find("S_CP_DIVISION").text();
				var CP_MAX_NO = $(data).find("CP_MAX_NO").text();
				var CP_OUTLINE = $(data).find("CP_OUTLINE").text();
				var CP_TEXTBOOK = $(data).find("CP_TEXTBOOK").text();
				var CP_SUB_TEXTBOOK = $(data).find("CP_SUB_TEXTBOOK").text();
				var CP_VALUATION = $(data).find("CP_VALUATION").text();

				if (CP_TIME == "null") {
					CP_TIME = "";
				}
				if (CR_NUM == "null") {
					CR_NUM = "";
				}
				if (PF_EMAIL == "null") {
					PF_EMAIL = "";
				}
				if (CP_SUB_TEXTBOOK == "null") {
					CP_SUB_TEXTBOOK = "";
				}

				$("#plan_div").load("admin/ClassPlanForm_sub.jsp", function() {
					// 로딩이 완료되면 드롭다운을 감싸는 태그 요소를 화면에 표시함
					$("#CP_NUM").attr("value", CP_NUM);
					$("#CP_DATE").attr("value", CP_DATE);
					$("#CP_YEAR").attr("value", CP_YEAR);
					$("#CP_SEMESTER").attr("value", CP_SEMESTER);
					$("#S_NAME").attr("value", S_NAME);

					$("#S_NUM").attr("value", S_NUM);
					$("#S_CP_CREDITS").attr("value", S_CP_CREDITS);
					$("#CP_TIME").attr("value", CP_TIME);
					$("#D_NUM").attr("value", D_NUM);
					$("#D_NAME").attr("value", D_NAME);

					$("#CR_NUM").attr("value", CR_NUM);
					$("#PF_NUM").attr("value", PF_NUM);
					$("#PF_NAME").attr("value", PF_NAME);
					$("#PF_EMAIL").attr("value", PF_EMAIL);
					$("#S_CP_DIVISION").attr("value", S_CP_DIVISION);
					$("#CP_MAX_NO").attr("value", CP_MAX_NO);
					$("#CP_OUTLINE").val(CP_OUTLINE);
					$("#CP_TEXTBOOK").attr("value", CP_TEXTBOOK);
					$("#CP_SUB_TEXTBOOK").attr("value", CP_SUB_TEXTBOOK);
					$("#CP_VALUATION").attr("value", CP_VALUATION);

					alert("목록을 불러왔습니다.");
					$(this).show();

				});

			});
		});

		$(document).on("click", ".ClassPlan_Submit", function() {
			var time = $("#CP_TIME").val();
			var num = $("#CR_NUM").val();

			var url = "admin/check/submit_check.jsp";
			$.get(url, {
				"time" : time,
				"num" : num
			}, function(data) {
				var time = $(data).find("CP_TIME").text();
				//var test = $(data).find("CP_test").text();

				//0에서 -> 1 아니면 -1로 set
				$("#check_button").attr("value", time);
				if (time == 1) {
					alert("수업 등록이 가능합니다.");
					list.CP_SEMESTER.focus();
					return false;
				}
				if (time == -1) {
					alert("수업 등록이 불가능합니다.");
					list.CP_TIME.focus();
					return false;
				}

				//if(1) count 0보다 크면 중복된 값 alert
				//else(0) count가 0 이면 없는 값 -> 성공. alert
				//alert("성공"+time+num);
			});
		});
		$(document).on("change", "#studentDateSelectbox", function() {
			var value = $(this).find("option:selected").attr("value");
			var sdNum = value+$("#d_num").val();
			
				var url = "/LMS/LearningManagementSystem/admin/check/SelectSdnum.jsp";
				//sd_num
			$.get(url, {
				"sdNum" : sdNum
			}, function(data) {
				var sd_num = $(data).find("result").text();
				$("#sd_num").attr("value",sd_num);
			}); 
		});
		$(document).on("change", "#subjectDateSelectbox", function() {
			var value = $(this).find("option:selected").attr("value");
			
			
				var url = "/LMS/LearningManagementSystem/admin/check/SelectSnum.jsp";
				//sd_num
			$.get(url, {
				"s_num" : value
			}, function(data) {
				var s_num = $(data).find("result").text();
				$("#s_num").attr("value",s_num);
			}); 
		});
	});
</script>


<script type="text/javascript">
	function planList_Check(list) {

		if (!list.CP_SEMESTER.value) {
			alert("개설학기를 입력하지 않으셨습니다.");
			list.CP_SEMESTER.focus();
			return false;
		}
		if (!list.CP_TIME.value) {
			alert("강의시간을 입력하지 않으셨습니다.");
			list.CP_TIME.focus();
			return false;
		}
		if (!list.CR_NUM.value) {
			alert("강의실을 입력하지 않으셨습니다.");
			list.CR_NUM.focus();
			return false;
		}

		if (list.check_button.value == 0) {
			alert("중복검사를 먼저 해주세요.");
			return false;
		} else if (list.check_button.value == -1) {
			alert("수업등록이 불가능 합니다.");
			return false;
		}
	}
</script>
<script type="text/javascript">
	function search_Check(select_value,d_num) {
		
		if ((!select_value) || (!d_num)) {
			alert("과를 먼저 조회해주세요.");
		}else{
			document.location.href='/LMS/LearningManagementSystem/admin/RegisterStudentForm.do?select_option='+select_value+'&d_num='+d_num;
		}
	}
	function search_Check2(select_value,d_num) {
		
		if ((!select_value) || (!d_num)) {
			alert("과를 먼저 조회해주세요.");
		}else{
			document.location.href='/LMS/LearningManagementSystem/admin/RegisterProfessorForm.do?select_option='+select_value+'&d_num='+d_num;
		}
	}
</script>
<script type="text/javascript">
	function subject_Check(d_num) {
		
		if(!d_num) {
			alert("과를 먼저 조회해주세요.");
		}else{
			document.location.href='/LMS/LearningManagementSystem/SubjectForm.do?d_num='+d_num;
		}
	}
</script>



</head>
<body>

</body>
</html>