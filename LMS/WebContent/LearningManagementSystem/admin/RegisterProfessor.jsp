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
<script>
function writeSave() {
	   if (document.regist.pf_passwd.value == "") {
	      alert("비밀번호를 입력하세요.");
	      document.regist.pf_passwd.focus();
	      return false;
	   }

	   if (document.regist.pf_name.value == "") {
	      alert("이름을 입력하세요.");
	      document.regist.pf_name.focus();
	      return false;
	   }

	   if (document.regist.pf_jumin.value == "") {
	      alert("생년월일을 입력하세요.");
	      document.regist.pf_jumin.focus();
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
           <%--  //AllDepartment.do?select_option=${select_option} --%>
            <%-- <form method="post" name ="registerform" action="/LMS/LearningManagementSystem/admin/RegisterStudent.do?select_option=${select_option}" onsubmit="return writeSave()"> --%>
               <form method="post" name="regist" action="/LMS/LearningManagementSystem/admin/RegisterProfessor.do?select_option=${select_option}" onsubmit='return writeSave();'>
               
               <div class="table-responsive">
                  <table class="table table-bordered table-hover">
                     <thead>
                        <!-- class="bg-aqua" -->
                        <td class='info-box-icon bg-aqua text-center'>등록</td>                        
                        <span>
                           <tr>
                           <td class='td_color text-center'>학과명</td>
                           <td class='text-center'>${select_option}</td>
                           <input type='hidden' name='d_num' value='${d_num}'>
                           
                           </tr>                           
                           <tr>
                           <td class='td_color text-center'>교번</td>
                           <td class='text-center'>
                           <input type="text" size="10" maxlength="10" name="pf_num" value='${pf_num}' readonly>
                           </td>                           
                           </tr>

                           <tr>
                           <td class='td_color text-center'>비밀번호</td>
                           <td class='text-center'>
                           <input type="password" size="10" maxlength="10" name="pf_passwd">
                           </td>
                           
                           </tr>         
                           
                           <tr>
                           <td class='td_color text-center'>이름</td>
                           <td class='text-center'>
                           <input type="text" size="10" maxlength="10" name="pf_name">
                           </td>                           
                           </tr> 
                                             
                           <tr>
                           <td class='td_color text-center'>생년월일</td>
                           <td class='text-center'>
                           <input type="text" size="10" maxlength="10" name="pf_jumin">
                           </td>                           
                           </tr>                     
                        </span>
                     </tbody>
                  </table>
                  
               </div>
                <button type="submit" value="등록 " class="btn btn-lg bg-aqua">등록</button>
               </form>
               
            </div>
            
            <!-- 학적 테이블 끝 -->
</body>
</html>