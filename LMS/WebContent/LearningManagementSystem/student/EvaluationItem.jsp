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
  
        <div class="col-lg-15">
                        <div class="table-responsive">
                        <form>
                            <table class="table table-bordered table-hover text-center" >
                                <thead class="bg-aqua">
                                    <tr align="center">
                                        <!-- <th>No.</th> -->
                                        <th width="500">문항내용</th>
                                        <th width="50">A</th>
                                        <th width="50">B</th>
                                        <th width="50">C</th>
                                        <th width="50">D</th>
                                        <th width="50">E</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr align="center">
                                        <%-- <td>${list.no}</td> --%>
                                        
                                        <tr class="text-left">
                                        <td>${EvalList.list_1}</td>
                                       <td><input type="radio" name="eval1" value="5"></td>
                                       <td><input type="radio" name="eval1" value="4"></td>
                                       <td><input type="radio" name="eval1" value="3"></td>
                                       <td><input type="radio" name="eval1" value="2"></td>
                                       <td><input type="radio" name="eval1" value="1"></td>
                                       </tr>
                                       
                                        <tr class="text-left">
                                        <td>${EvalList.list_2}</td>
                                       <td><input type="radio" name="eval2" value="5"></td>
                                       <td><input type="radio" name="eval2" value="4"></td>
                                       <td><input type="radio" name="eval2" value="3"></td>
                                       <td><input type="radio" name="eval2" value="2"></td>
                                       <td><input type="radio" name="eval2" value="1"></td>
                                        </tr>
                                        
                                        <tr class="text-left">
                                        <td>${EvalList.list_3}</td>
                                        <td><input type="radio" name="eval3" value="5"></td>
                                       <td><input type="radio" name="eval3" value="4"></td>
                                       <td><input type="radio" name="eval3" value="3"></td>
                                       <td><input type="radio" name="eval3" value="2"></td>
                                       <td><input type="radio" name="eval3" value="1"></td>
                                        </tr>
                                        
                                        <tr class="text-left">
                                        <td>${EvalList.list_4}</td>
                                        <td><input type="radio" name="eval4" value="5"></td>
                                       <td><input type="radio" name="eval4" value="4"></td>
                                       <td><input type="radio" name="eval4" value="3"></td>
                                       <td><input type="radio" name="eval4" value="2"></td>
                                       <td><input type="radio" name="eval4" value="1"></td>
                                        </tr>
                                        
                                        <tr class="text-left">
                                        <td>${EvalList.list_5}</td>
                                        <td><input type="radio" name="eval5" value="5"></td>
                                       <td><input type="radio" name="eval5" value="4"></td>
                                       <td><input type="radio" name="eval5" value="3"></td>
                                       <td><input type="radio" name="eval5" value="2"></td>
                                       <td><input type="radio" name="eval5" value="1"></td>
                                        </tr>
                                        
                                        <tr>
                                    </tr>
                                </tbody>
                                
                            </table>
                            <button type="submit" class="btn btn-lg bg-aqua">평가하기</button>
                            <input type="hidden" value="${cr_num}" name="cr_num">
                           
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