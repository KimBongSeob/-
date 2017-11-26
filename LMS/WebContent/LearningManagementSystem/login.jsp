<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>학사관리 프로그램</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
 
    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
 
    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">
    
    <link href="css/login.css" rel="stylesheet">
 
    <script language="JavaScript" src="js/logincheck.js"></script>
   
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    
<!--     <script type="text/javascript">
    $(function() {
        $('#login-form-link').click(function(e) {
        	$("#login-form").delay(100).fadeIn(100);
     		$("#register-form").fadeOut(100);
    		$('#register-form-link').removeClass('active');
    		$(this).addClass('active');
    		e.preventDefault();
    	});
    	$('#register-form-link').click(function(e) {
    		$("#register-form").delay(100).fadeIn(100);
     		$("#login-form").fadeOut(100);
    		$('#login-form-link').removeClass('active');
    		$(this).addClass('active');
    		e.preventDefault();
    	});
    });
 
    </script> -->
    
<%    try{
   if(session.getAttribute("mem")==null){ %>
    
    <script type="text/javascript">
    function checkIt(){
        if(!document.myform.username.value){ // value값이 존재하지 않으면 false. 앞에 !를 만나 true가 되므로 안에 내용이 실행됨. 
          alert("이름을 입력하지 않으셨습니다.");
          document.myform.usename.focus();
          return false;
        }
        if(!document.myform.password.value){
          alert("비밀번호를 입력하지 않으셨습니다.");
          document.myform.password.focus();
          return false;
        }
      }
    </script>
    
</head>
<body>
<body onload="focusIt()">
<div class="container">
   <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-login">
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
            
              <form id="login-form" action="/LMS/LearningManagementSystem/loginPro.do" method="post" name="myform" role="form" style="display: block;" onSubmit="return checkIt()">
            
           <div class="form-group">  
           <span class="job_font">   
           <input type="radio" style="width:18px;height:18px" class="job_font" name="job" value="1" CHECKED id="job_student" />
           <label for="job_student">&nbsp;학부 &emsp; </label>
           <input type="radio" style="width:18px;height:18px" class="job_font" name="job" value="2" id="job_professor" />
           <label for="job_professor">&nbsp;교수&emsp;</label>
           <input type="radio" style="width:18px;height:18px" class="job_font" name="job" value="3" id="job_admin" />
           <label for="job_admin">&nbsp;교직원&emsp;</label>
           </span>
		   </div>
                  <div class="form-group">
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                  </div>
                  
                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                  </div>
                  
                  <div class="col-xs-6 form-group pull-left checkbox">
                    <input id="checkbox1" type="checkbox" name="remember">
                    <label for="checkbox1">Remember Me</label>   
                  </div>
                  <div class="col-xs-6 form-group pull-right">     
                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="로그인">
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
        <div class="panel-heading">
          <div class="row">
            <div class="col-xs-6 tabs">
              <a href="#" class="active" id="login-form-link"><div class="login">아이디 찾기</div></a>
            </div>
            <div class="col-xs-6 tabs">
              <a href="#" id="register-form-link"><div class="register">비밀번호 찾기</div></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<footer>
    <div class="container">
        <div class="col-md-10 col-md-offset-1 text-center">
        </div>   
    </div>
</footer>

<% }}catch(NullPointerException e){} %>
</body>
</html>