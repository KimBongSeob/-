<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/LMS/LearningManagementSystem/student.do">성공대학교</a>
            </div>
            <!-- Top Menu Items -->
          <ul class="nav navbar-right top-nav">
                <li>
                    <a href="/LMS/LearningManagementSystem/student/noticeboard/list.do"><i class="glyphicon glyphicon-bullhorn"></i>&nbsp 공지사항 <b class="caret"></b></a>                  
                </li>
                 <li>
                    <a href="/LMS/LearningManagementSystem/common/MVC/list.do"><i class="fa fa-bell"></i>&nbsp 게시판 <b class="caret"></b></a>                    
                </li>
                
            
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                 
                        <li class="divider"></li>
                        <li>
                            <a href="/LMS/LearningManagementSystem/logOut.jsp"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
            
            
                <ul class="nav navbar-nav side-nav" id="test">
                    <li class="">
                        <a href="/LMS/LearningManagementSystem/student.do"><i class="glyphicon glyphicon-user"></i>&nbsp 개인정보</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/Classrequest.do"><i class="fa fa-fw fa-calendar"></i>&nbsp 수강신청</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/Evaluation.do"><i class="glyphicon glyphicon-pencil"></i>&nbsp 강의평가</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/result.do"><i class="fa fa-fw fa-desktop"></i>&nbsp 성적조회</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#Register_target"><i class="glyphicon glyphicon-book"></i>&nbsp 학사/학적 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="Register_target" class="collapse">
                            <li>
                                <a href="/LMS/LearningManagementSystem/Register.do?check=1">휴학/복학/휴학연장 신청</a>
                            </li>
                            <li>
                                <a href="/LMS/LearningManagementSystem/Register.do?check=2">학적 조회</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#scholarship_target"><i class="glyphicon glyphicon-usd"></i>&nbsp 장학금조회 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="scholarship_target" class="collapse">
                            <li>
                                <a href="/LMS/LearningManagementSystem/Scholarship.do?check=1">장학금 수혜 계좌조회</a>
                            </li>
                            <li>
                                <a href="/LMS/LearningManagementSystem/Scholarship.do?check=2">장학금 수혜 내역 조회</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="glyphicon glyphicon-link"></i>&nbsp 복수전공/부전공 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="/LMS/LearningManagementSystem/Specialty.do">복수/부전공 신청</a>
                            </li>
                            
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
