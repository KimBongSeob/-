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

<script type="text/javascript">
      $(function() {
    	  
        // 기본적으로 1depth의 드롭다운을 로드함
        $("#Register_option1").load("student/text/data.jsp #Register_option1-1", function() {
          // 로딩이 완료되면 드롭다운을 감싸는 태그 요소를 화면에 표시함
          $(this).show();
        });

        // 드롭다운은 body상에 없으므로 이벤트를 "미리"정의해 놓아야 한다.
        // 1depth에 대한 change 이벤트 정의
         $(document).on("change", "#Register_option1> select", function() {
          // 1dpeth가 변경되므로 2,3depth는 초기화.
          $("#Register_option2").empty().hide();
          $(".console").hide();
          $(".submit_button").empty().hide();

          // 선택된 항목이 지시하는 하위 카테고리 페이지의 URL얻기
          var target = $(this).find("option:selected").attr("data-target");
          var selector = "student/text/data.jsp " + target;

          // 다음 항목 로드
          $("#Register_option2").load(selector, function() {
            $(this).show();
          });
          
        });
      });
      
</script>
<script type="text/javascript">
    $(document).on("click", "#Register_option_button1", function() {
			/** id속성이 "egister_option3"인 요소에 대한 "Register_option1"이벤트 정의 */
				// 사용자 입력값 얻어오기
				var select_value = $("#Register_option1-1").find("option:selected").val();	
				var url = "student/check/check.jsp";
				
				$.get(url, {
					"select_value" : select_value
				}, function(data) {
					/** XML 데이터를 읽어왔을 때, 이 함수의 파라미터는 XML-DOM형태이며,
					 *  데이터를 추출하는 방법은 $.ajax()함수와 동일하다.*/
					// 데이터 로드에 성공한 경우 XML에서 "result"태그의 값을 추출
					var result_m = $(data).find("result").text();
					var check_request = $(data).find("check_request").text();
					var check_select = $(data).find("check_select").text();
					var loa_date = $(data).find("loa_date").text();
					var year_end = $(data).find("year_end").text();
					var semester_end = $(data).find("semester_end").text();

					$(".submit_button").empty().hide();
				
					$(".console").html("<h4 class='text-center'>"+result_m+"</h4>");
					$(".hidden_item").html("<input type='hidden' name='loa_date' value='"+loa_date+"'><input type='hidden' name='semester_end' value='"+semester_end+"'><input type='hidden' name='year_end' value='"+year_end+"'>");

					$(".console").show();
					if(check_request==1){
						if(check_select == 1){

							$(".submit_button").load("student/text/data.jsp #Register_option_button2", function() {
								$(".submit_button").show();
							});
							
							
						}else if(check_select == 2){
							$(".submit_button").load("student/text/data.jsp #Register_optionList", function() {
								$(".submit_button").show();
							});
							
						}
					}
					
				});  

		});
    
	
		
    
    $(document).on("click", ".plan_search", function() {
			var id = $(this).attr("id");
////////////화면 open
			var cw=screen.availWidth;     //화면 넓이
			var ch=screen.availHeight;    //화면 높이

			var sw=640;    //띄울 창의 넓이
			var sh=540;    //띄울 창의 높이
			

			var ml=(cw-sw)/2;      
			var mt=(ch-sh)/2;         
			var num = $("#sd_num").attr("value");
			
			var test = window.open('/LMS/LearningManagementSystem/ClassrequestOpen.do?cp_num='+id+"&sd_num="+num,'강의계획서','width='+sw+',height='+sh+',top='+mt+',left='+ml+',resizable=no,scrollbars=yes');
///////////// 화면 end
			
			
    });
    $(document).on("click", "#Classbasket_button", function() {
    	$("#Register1").attr("class","");
    	$("#Register2").attr("class","");
    	$("#Register3").attr("class","active")
    	$("#Register-tab1").attr("aria-expanded", "false");
    	$("#Register-tab2").attr("aria-expanded", "false");
    	$("#Register-tab3").attr("aria-expanded", "true"); 
    	
    	
/*     	$("Register-tab1").css("class","");
    	$("Register-tab2").css("class","");
    	$("Register-tab1").css("aria-expanded", "false");
    	$("Register-tab2").css("aria-expanded", "false");

    	$("Register-tab3").css("class","active");
    	$("Register-tab3").css("aria-expanded", "true"); */
    	
    	
    	
    	
		
		
});
			
    
    
    </script>



</head>
<body>

</body>
</html>