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
                <a class="navbar-brand" href="/LMS/LearningManagementSystem/professor.do">성공대학교</a>
            </div>
            <!-- Top Menu Items -->
                  <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li>
                    <a href="/LMS/LearningManagementSystem/professor/noticeboard/list.do"><i class="glyphicon glyphicon-bullhorn"></i>&nbsp 공지사항 <b class="caret"></b></a>                  
                </li>
                 <li>
                    <a href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/list.do"><i class="fa fa-bell"></i>&nbsp 게시판 <b class="caret"></b></a>                    
                </li>
                
           
           
                
                <li class="dropdown">
                    <a href="/LMS/LearningManagementSystem/logOut.jsp"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                    
                </li>
            </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav" id="test">
                    <li>
                        <a href="/LMS/LearningManagementSystem/professor/PreModifyProfessor.do"><i class="fa fa-fw fa-edit"></i> 개인정보 </a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/professor/EcaluationForm.do"><i class="fa fa-fw fa-desktop"></i> 강의평가조회 </a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/professor/GradeForm.do"><i class="fa fa-fw fa-wrench"></i> 성적관리 </a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/professor/TimeTableForm.do"><i class="fa fa-fw fa-wrench"></i> 교수 시간표 조회 </a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/ClassPlan.do"><i class="glyphicon glyphicon-book"></i>&nbsp 강의계획서 관리 </a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
        
