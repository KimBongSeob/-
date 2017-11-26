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
		$(document).on(
				"change",
				"#Department_option",
				function() {
					var select_value = $("#Department_option").find(
							"option:selected").val();
					var url = "professor/check/Department_check.jsp";

					$("#s_num").attr("value","");
					$("#s_cp_division").attr("value","");
					$("#s_cp_credits").attr("value","");
					
					$.get(url, {
						"select_value" : select_value
					}, function(data) {
						$("#Subject_option").empty();
						$(data).find('item').each(
								function() {
									var item_text = $(this).find("select_data")
											.text();
									var item_num = $(this).find(
											"select_data_num").text();
									$("#Subject_option").append(
											"<option value='"+item_num+"'>"
													+ item_text + "</option>");
								});

						//$("#Subject_div").append("</select>");
						//var result_m = $(data).find("result").text();

						//$("#Subject_div").html("" + result_m);
						//console.log( data.name );
						//alert(data.result);
					});
				});

		$(document).on(
				"change",
				"#Subject_option",
				function() {
					var select_value = $("#Subject_option").find(
							"option:selected").val();
					var url = "professor/check/Subject_check.jsp";
					$("#S_NUM").attr("value","");
					$("#S_CP_DIVISION").attr("value","");
					$("#S_CP_CREDITS").attr("value","");

					$.get(url, {
						"select_value" : select_value
					}, function(data) {
						

						var num = $(data).find("select_num").text();
						var division = $(data).find("select_cp_division").text();
						var credits = $(data).find("select_cp_credits").text();
						$("#S_NUM").attr("value",num);
						$("#S_CP_DIVISION").attr("value",division);
						$("#S_CP_CREDITS").attr("value",credits);
					});

				});
		$(document).on(
				"click",
				".plan_search",
				function() {
					var id = $(this).attr("id");
					
					var url = "professor/check/Plan_search.jsp";
					
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
						
						if(CP_TIME == "null"){
							CP_TIME = "";
						}
						if(CR_NUM == "null"){
							CR_NUM = "";
						}
						if(PF_EMAIL == "null"){
							PF_EMAIL = "";
						}
						if(CP_SUB_TEXTBOOK == "null"){
							CP_SUB_TEXTBOOK = "";
						}
						
						$("#plan_div").load("professor/ClassPlanForm_sub.jsp", function() {
							
					          // 로딩이 완료되면 드롭다운을 감싸는 태그 요소를 화면에 표시함
					          $("#CP_NUM").attr("value", CP_NUM);
					          $("#CP_DATE").attr("value", CP_DATE);
					          $("#CP_YEAR").attr("value",CP_YEAR );
					          $("#CP_SEMESTER").attr("value",CP_SEMESTER );
					          $("#Subject_option").append(
										"<option value='"+S_NUM+"' selected>"
										+ S_NAME + "</option>");
					          $("#S_NUM").attr("value", S_NUM);
					          $("#S_CP_CREDITS").attr("value",S_CP_CREDITS );
					          $("#CP_TIME").attr("value", CP_TIME);
					          $("#D_NUM").attr("value",D_NUM );
					          $("#Department_option").append(
										"<option value='"+D_NUM+"' selected>"
										+ D_NAME + "</option>");
					          $("#CR_NUM").attr("value",CR_NUM );
					          $("#PF_NUM").attr("value",PF_NUM );
					          $("#PF_NAME").attr("value",PF_NAME );
					          $("#PF_EMAIL").attr("value",PF_EMAIL );
					          $("#S_CP_DIVISION").attr("value", S_CP_DIVISION);
					          $("#CP_MAX_NO").attr("value",CP_MAX_NO );
					          $("#CP_OUTLINE").val(CP_OUTLINE);
					          $("#CP_TEXTBOOK").attr("value", CP_TEXTBOOK);
					          $("#CP_SUB_TEXTBOOK").attr("value",CP_SUB_TEXTBOOK );
					          $("#CP_VALUATION").attr("value",CP_VALUATION );
					         
					          
					          
					          $(this).show();
					    });
					});
				});
		
		$(document).on(
				"click",
				".change_button",
				function() {
					alert($(this).prev().find("option:selected").val());
					var select_value = $(this).prev().find("option:selected").val();
					
					var cp_num = $("#cp_num").attr("value");
					var cr_num = $(this).attr("id");
					
					document.location.href='/LMS/LearningManagementSystem/professor/gradeChange.do?cr_num='+cr_num+'&g_sum='+select_value+'&cp_num='+cp_num;

		});

	});
</script>
<script type="text/javascript">
function planList_Check(list){
    if(!list.CP_YEAR.value){ // value값이 존재하지 않으면 false. 앞에 !를 만나 true가 되므로 안에 내용이 실행됨. 
      alert("개설학년을 입력하지 않으셨습니다.");
      list.CP_YEAR.focus();
      return false;
    }
    if(!list.CP_SEMESTER.value){
      alert("개설학기를 입력하지 않으셨습니다.");
      list.CP_SEMESTER.focus();
      return false;
    }
    if($("#Department_option").find("option:selected").val() =="선택"){//과번호
        alert("과를 선택하지  않으셨습니다.");
        return false;
    }
    if($("#Subject_option").find("option:selected").val() =="선택"){
        alert("과목을 입력하지 않으셨습니다.");
        list.CP_SEMESTER.focus();
        return false;
    }
    if(!list.CP_MAX_NO.value){ 
        alert("강의 최대인원을 입력하지 않으셨습니다.");
        list.CP_MAX_NO.focus();
        return false;
    }
    if(!list.CP_OUTLINE.value){
        alert("강의개요를 입력하지 않으셨습니다.");
        list.CP_OUTLINE.focus();
        return false;
    }
    if(!list.CP_TEXTBOOK.value){
        alert("교재를 입력하지 않으셨습니다.");
        list.CP_TEXTBOOK.focus();
        return false;
    }
    if(!list.CP_VALUATION.value){
        alert("평가방법을 입력하지 않으셨습니다.");
        list.CP_VALUATION.focus();
        return false;
    }
    
    
    
  }
</script>


</head>
<body>

</body>
</html>