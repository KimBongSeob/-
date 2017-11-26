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
                <a class="navbar-brand" href="/LMS/LearningManagementSystem/admin.do">성공대학교</a>
            </div>
            <!-- Top Menu Items -->
                  <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li>
                    <a href="/LMS/LearningManagementSystem/admin/noticeboard/list.do"><i class="glyphicon glyphicon-bullhorn"></i>&nbsp 공지사항 <b class="caret"></b></a>                  
                </li>
                 <li>
                    <a href="/LMS/LearningManagementSystem/common/MVC/list.do"><i class="fa fa-bell"></i>&nbsp 게시판 <b class="caret"></b></a>                    
                </li>
                
           
           
                
                <li class="dropdown">
                    <a href="/LMS/LearningManagementSystem/logOut.jsp"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                    
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
            
            
                <ul class="nav navbar-nav side-nav" id="test">
                    <li class="">
                        <a href="/LMS/LearningManagementSystem/AllDepartmentStudent.do"><i class="glyphicon glyphicon-user"></i>&nbsp 학생관리</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/AllDepartmentProfessor.do"><i class="fa fa-fw fa-calendar"></i>&nbsp 교수관리</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/AllDepartment.do"><i class="glyphicon glyphicon-pencil"></i>&nbsp 과등록</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/ClassRegister.do"><i class="glyphicon glyphicon-pencil"></i>&nbsp 수업등록</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/admin/StatisticalChart.do"><i class="fa fa-fw fa-desktop"></i>&nbsp 통계</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/AdmScholarship.do"><i class="glyphicon glyphicon-book"></i>&nbsp 장학금관리</a>
                    </li>
                    <li>
                        <a href="/LMS/LearningManagementSystem/AdminLoa.do"><i class="glyphicon glyphicon-book"></i>&nbsp 휴/복학 관리</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>