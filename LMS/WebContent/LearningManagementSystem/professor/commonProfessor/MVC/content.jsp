<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta charset="utf-8">
<title>게시판</title>
<%@include file="/LearningManagementSystem/professor/css_script.jsp"%>
</head>

<body>
 <div id="wrapper">
        <!-- Navigation -->
<%@include file="/LearningManagementSystem/professor/head_professor.jsp"%>
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">게시판 내용</h1>
                    </div>
                </div>
	<center>
		<form>
			<table width="700" border="1" cellspacing="0" cellpadding="0"
				align="center">
				<tr height="30">
					<td align="center" width="80" bgcolor="${value_c}">글제목</td>
					<td align="center" width="375" align="center" colspan="3">${article.subject}</td>
				</tr>
				<tr height="30">
					<td align="center" width="80" bgcolor="${value_c}">작성자</td>
					<td align="center" width="80" align="center">${article.writer}</td>
				</tr>
				
				<tr>
					<td align="center" width="125" bgcolor="${value_c}">글내용</td>
					<td align="left" width="375" height="300" colspan="3">
					<pre>${article.content}</pre></td>
				</tr>	
								
				<tr height="30">
				<td align="center" width="80">첨부파일</td>
				<td align="center" width="375" colspan="3"><a href="download.jsp?num=${article.num}">${article.filename}</td>				
				</tr>
				
				<tr>
					<td colspan="4" bgcolor="${value_c}" align="right"><input
						type="button" value="글수정"
						onclick="document.location.href='/LMS/LearningManagementSystem/professor/commonProfessor/MVC/updateForm.do?num=${article.num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp; <input type="button" value="글삭제"
						onclick="document.location.href='/LMS/LearningManagementSystem/professor/commonProfessor/MVC/deleteForm.do?num=${article.num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp; <input type="button" value="답글쓰기"
						onclick="document.location.href='/LMS/LearningManagementSystem/professor/commonProfessor/MVC/writeForm.do?num=${article.num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
						&nbsp;&nbsp;&nbsp; <input type="button" value="글목록"
						onclick="document.location.href='/LMS/LearningManagementSystem/professor/commonProfessor/MVC/list.do?pageNum=${pageNum}'">
					</td>
				</tr>
			</table>
		</form>
		  </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/LMS/LearningManagementSystem/js/plugins/morris/raphael.min.js"></script>
    <script src="/LMS/LearningManagementSystem/js/plugins/morris/morris.min.js"></script>
    <script src="/LMS/LearningManagementSystem/js/plugins/morris/morris-data.js"></script>		
</body>
</html>
