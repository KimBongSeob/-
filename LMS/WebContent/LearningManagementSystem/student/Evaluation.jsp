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

</head>

<body>

    <div id="wrapper">

        <!-- head 부분 -->
        <%@include file="/LearningManagementSystem/student/head.jsp"%>
        
        <!-- head 끝 -->
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            강의평가
                        </h1>
                    </div>
                </div>
                <!-- /.row -->


                <div class="row">
                    <div class="col-lg-12 text-center">
  
        <div class="col-lg-6">
                        <div class="table-responsive">
                        <form>
                            <table class="table table-bordered table-hover">
                                <thead class="bg-aqua">
                                    <tr>
                                        <!-- <th>No.</th> -->
                                        <th>교과목명</th>
                                        <th>담당교수</th>
                                        <th>학수번호</th>
                                        <th>강의시간</th>
                                        <th>강의평가</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                    <c:forEach var="list" items="${ClassList}">
                                        <%-- <td>${list.no}</td> --%>
                                        <td>${list.s_name}</td> <!-- from subject테이블 -->
                                        <td>${list.pf_name}</td> <!-- from professor테이블 -->
                                        <td>${list.s_num}</td> <!-- from subject테이블 -->
                                        <td>${list.cp_time}</td> <!-- from classplan테이블 -->
                                        <td><a href='/LMS/LearningManagementSystem/ClassEvaluation.do?cr_num=${list.cr_num}'><button type="button" class="btn btn-lg bg-aqua">평가하기</button></a></td>
                                        
                                        <tr>
                                        </c:forEach>
                                    </tr>
                                </tbody>
                            </table>
                            </form>
                        </div>
                    </div>
             
                    
    </div>
  </div>
                    </div>
                </div>
                </div>
    
 
            
            <!-- /.container-fluid -->

       
        <!-- /#page-wrapper -->
    <!-- /#wrapper -->

    <!-- jQuery -->

</body>

</html>