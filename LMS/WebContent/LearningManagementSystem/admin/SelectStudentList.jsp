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
    
    <%@include file="/LearningManagementSystem/admin/css_script.jsp"%>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<script type="text/javascript">
function check(){
alert("정상적으로 등록되었습니다.");
}
</script>

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
                        <h1 class="page-header">
                            학생 관리
                        </h1>
                    </div>
                </div>
                <!-- /.row -->


                <div class="row">
                    <div class="col-lg-12 text-center">
  
    <!-- 학기선택 시작-->
      <div class="col-lg-12 text-left">
          <div class="info-box">
            <span class="info-box-icon bg-aqua">학과선택</span>

            <div class="info-box-content">
            <form>
              <span class="info-box-text">
              <div class="col-lg-4 text-center">
                        <div class="panel panel-default">
                        
                                <select class="form-control" id= "select_option" name="select_option">
                                
                                <%-- <c:choose> --%>
                                 <%-- <c:when test="${size == 0}">
                                <option value="" selected>선택하세요.</option>
                                </c:when> --%>
                                <%-- <c:when test="${size > 0}"> --%>
                                <option value="" selected>선택하세요.</option>
                                <c:forEach var="list" items="${DepartmentList}" varStatus='status'>
                                <c:choose>
                                	<c:when test='${status.count == 1}'>
                               		 </c:when>
                               		<c:otherwise>
                           				<option value="${list.d_name},${list.d_num}">${list.d_name}</option>
                           			</c:otherwise>
                               		 
                                </c:choose>
                                </c:forEach>
                                <%-- </c:when> --%>
                                 
                                 <%-- </c:choose> --%>
                                </select>
                          
                          </div>
                          
                    </div>
                    
                    <button type="submit" class="btn btn-lg bg-aqua" OnClick="window.location='/LMS/LearningManagementSystem/admin/SelectStudentListCheck.do?sd_num=${list.sd_num}'">조회</button>
                    <!-- <input type="hidden" name="check" value="1"> -->
                    
                    <button type="button" id='submit_student_button' value="등록 " class="btn btn-lg bg-aqua" onclick="search_Check(<c:choose>
                           		<c:when test='${(select_option == null) || (select_option == "")}'>'',''</c:when>
                           		<c:otherwise>'${select_option}','${d_num}'</c:otherwise>
                           	</c:choose>)">등록</button> 
                    
                    </span>
                    </form>
                    
                    
                    
                    <!-- <input type="hidden" name="check" value="2"> -->
                    
                    
            </div>
          </div>
        </div>

        <!-- 학기선택 끝 -->
        <!-- 장학금명/장학금액 테이블 시작 -->
         
        <div class="col-lg-6">
                        <div class="table-responsive">
                          <form>
                            <table class="table table-bordered table-hover">
                                <thead class="bg-aqua">
                                    <tr>
                                        <!-- <th>No.</th> -->
                                        <th>학번</th>
                                        <th>이름</th>
                                        <th>생년월일</th>
                                        <th>조회</th>
                                        <th>삭제</th>
                                    </tr>
                                </thead>
                              
                                <tbody>
                                    <tr>
                                      
                                       <c:choose>
                                    <c:when test="${select_option == '' || size == 0}">
                                    <td class="text-center" colspan="5">조회결과가 없습니다.</td>
                                    </c:when>
                                    <c:otherwise>
                                    <c:forEach var="list" items="${StudentList}">
                                        <%-- <td>${list.no}</td> --%>
                                        <td>${list.sd_num}</td>
                                        <td>${list.sd_name}</td>
                                        <td>${list.sd_jumin}</td>
                                        
                                        <td><input type=button class="btn btn-lg bg-aqua" value="조회" OnClick="window.location='/LMS/LearningManagementSystem/admin/SelectStudentListCheck.do?sd_num=${list.sd_num}&select_option=${select_option},${d_num}'"></td>
                                    
                                        <td><button type="button" value="글삭제" class="btn btn-lg bg-aqua"	onclick="document.location.href='/LMS/LearningManagementSystem/admin/deleteStudent.do?sd_num=${list.sd_num}&select_option=${select_option},${d_num}'">삭제</button></td>
                                      
                                        <tr>
                                        </c:forEach>
                                        </c:otherwise>
                                        </c:choose>
                                    </tr>
                                    
                                </tbody>
                            </table>
                              </form>
                        </div>
                    </div>
                    <!-- 장학금명/장학금액 테이블 끝 -->
                    
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