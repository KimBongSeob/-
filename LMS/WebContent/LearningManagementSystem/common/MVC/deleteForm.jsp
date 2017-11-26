<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">

<title>게시판</title>
<%@include file="/LearningManagementSystem/student/css_script.jsp"%>
<script src="script.js"></script>


</script>
</head>

<body>
 <div id="wrapper">
        <!-- Navigation -->
        <c:if test="${id_size == 9}">
<%@include file="/LearningManagementSystem/student/head.jsp"%>
</c:if>
<c:if test="${id_size == 4}">
<%@include file="/LearningManagementSystem/professor/head_professor.jsp"%>
</c:if>
<c:if test="${id_size == 5}">
<%@include file="/LearningManagementSystem/admin/head.jsp"%>
</c:if>

        <div id="page-wrapper">

            <div class="container-fluid">
              <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">글 삭제</h1>
                    </div>
                </div>

	<center>
		<b>글삭제</b> <br>
		<form method="POST" name="delForm"
			action="/LMS/LearningManagementSystem/common/MVC/deletePro.do?pageNum=${pageNum}"
			onsubmit="return deleteSave()">
			<table border="1" align="center" cellspacing="0" cellpadding="0" width="500">
				<tr height="30">
					<td align=center bgcolor="${value_c}"><b>비밀번호를 입력해 주세요.</b></td>
				</tr>
				<tr height="30">
					<td align=center>비밀번호 : <input type="password" name="passwd"
						size="8" maxlength="12"> <input type="hidden" name="num"
						value="${num}"></td>
				</tr>
				<tr height="30">
					<td align=center bgcolor="${value_c}"><input type="submit"
						value="글삭제"> <input type="button" value="글목록"
						onclick="document.location.href='/LMS/LearningManagementSystem/common/MVC/list.do?pageNum=${pageNum}'">
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