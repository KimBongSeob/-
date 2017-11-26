<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

    
<%    try{
   if(session.getAttribute("mem")==null){ %>
    
    <script type="text/javascript">
    function checkIt(){
 
        if(!document.myform.password.value){
          alert("비밀번호를 입력하지 않으셨습니다.");
          document.myform.password.focus();
          return false;
        }
      }
    </script>
    
</head>

<body onload="focusIt()">
 <div id="wrapper">
  <!-- head 부분 -->
        <%@include file="/LearningManagementSystem/student/head.jsp"%>
        
        <!-- head 끝 -->
        <div id="page-wrapper">
    <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-login">
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
            
              <form id="Pre_modifyform" action="/LMS/LearningManagementSystem/PreModifyPro.do?" method="post" name="myform" role="form" style="display: block;" onSubmit="return checkIt()">
      
                  <div class="form-group">
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="${member}" readonly>
                  </div>
                  
                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                  </div>
                  
                  
                  <div class="col-xs-6 form-group">     
                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login bg-aqua" value="로그인" >
                  </div>
              </form>
              
              <form id="register-form" action="#" method="post" role="form" style="display: none;">
                <h2>REGISTER</h2>
                  <div class="form-group">
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                    
                  </div>
                  <div class="form-group">
                    <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                  </div>
                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                  </div>
                  <div class="form-group">
                    <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
                  </div>
                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                      </div>
                    </div>
                  </div>
              </form>
            </div>
          </div>
        </div>
        </div>
        </div>
      </div>
    </div>
    </div>
<% }}catch(NullPointerException e){} %>
</body>
</html>