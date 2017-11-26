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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script>
	function clearText(field){
  		 
		    if (field.defaultValue == field.value) field.value = '';
		    else if (field.value == '') field.value = field.defaultValue;
		 
		}
    function checkIt() {
        var userinput = eval("document.userinput");
              
        if(!userinput.sd_passwd.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.sd_passwd.value != userinput.sd_passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
      
        if(!userinput.sd_hpone.value) {
            alert("휴대폰 번호를 입력하세요");
            return false;
        }
        if(!userinput.sd_address.value) {
            alert("주소를 입력하세요");
            return false;
        }
        if(!userinput.sd_email.value) {
            alert("e-mail를 입력하세요");
            return false;
        }
     /*   if(!userinput.jumin1.value  || !userinput.jumin2.value )
        {
            alert("주민등록번호를 입력하세요");
            return false;
        }*/
    }

</script>
</head>

<body>

	<div id="wrapper">

		<!-- head 부분 -->
		<%@include file="/LearningManagementSystem/student/head.jsp"%>

		<!-- head 끝 -->
		<div id="page-wrapper">
		  <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            개인정보
                        </h1>
                    </div>
                </div>
		<!-- 학적 테이블 시작 -->
								<div class="col-lg-6">
									<div class="table-responsive">
									<form method="post" name ="userinput"  action="/LMS/LearningManagementSystem/modifyPro.do" onsubmit="return checkIt()">
										<table class="table table-bordered table-hover">
											<thead ><!-- class="bg-aqua" -->
												<tr>
													<td class='td_color'>이름</td>
													<td>${StudentModifyData.sd_name}</td>
													</tr>
												<tr>
													<td class='td_color'>학번</td>
													<td>${StudentModifyData.sd_num}</td>
												</tr>
											</thead>
											<tbody>
												<tr>	
													<td class='td_color'>비밀번호</td>
													<td><input type='password' name ="sd_passwd" value="" ></td>
												</tr>
												<tr>
													<td class='td_color'>비밀번호확인</td>
													<td colspan='3'><input type='password' name ="sd_passwd2" ></td>
													
												</tr>
												<tr>
													<td class='td_color'>생년월일</td>
													<td>${StudentModifyData.sd_jumin}</td>
												</tr>
												<tr>	
													<td class='td_color'>휴대폰번호</td>
													<td> <input type="text" name="sd_hpone" size="40" maxlength="30" value="${StudentModifyData.sd_hpone}" onFocus="clearText(this)" onBlur="clearText(this)"></td>
												</tr>
									
												<tr>
													<td class='td_color'>주소</td>
													<td colspan='3'> <input type="text" name="sd_address" size="40" maxlength="30" value="${StudentModifyData.sd_address}" onFocus="clearText(this)" onBlur="clearText(this)"></td>
													
												</tr> 
												<tr>
													<td class='td_color'>E-MAIL</td>
													<td colspan='3'>
													<input type="text" name="sd_email" size="40" maxlength="30" value="${StudentModifyData.sd_email}" onFocus="clearText(this)" onBlur="clearText(this)">
													</td>
													
												</tr>
												<tr>
     											 <td colspan="3" align="center" >
     											  <input type="submit" name="modify" value="수 정완료" class="bg-aqua"><!-- 업데이트값 다 업데이트하고 버튼 누르면 -->
       											
      											</td>
  												  </tr>
											</tbody>
											
										</table>
										</form>
									</div>
								</div>
								<!-- 학적 테이블 끝 -->
									</div>
									
</body>
</html>