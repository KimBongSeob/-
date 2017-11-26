<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">

<title>게시판</title>
<%@include file="/LearningManagementSystem/professor/css_script.jsp"%>
<script src="script.js"></script>  

<body>
 <div id="wrapper">
        <!-- Navigation -->
<%@include file="/LearningManagementSystem/professor/head_professor.jsp"%>

        <div id="page-wrapper">

            <div class="container-fluid">
              <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">글 수정</h1>
                    </div>
                </div>

	<center>
		<b>글수정</b> <br>
		<form method="post" name="writeform"
			action="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/updatePro.do?pageNum=${pageNum}"
			onsubmit="return writeSave()">
			<table width="700" border="1" cellspacing="0" cellpadding="0"
				align="center">
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">이 름</td>
					<td align="left" width="330"><input type="text" size="10"
						maxlength="10" name="writer" value="${article.writer}"> <input
						type="hidden" name="num" value="${article.num}"></td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">제 목</td>
					<td align="left" width="330"><input type="text" size="40"
						maxlength="50" name="subject" value="${article.subject}"></td>
				</tr>
				
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">내 용</td>
					<td align="left" width="330"><textarea name="content"
							rows="13" cols="40">${article.content}</textarea></td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">비밀번호</td>
					<td align="left" width="330"><input type="password" size="8"
						maxlength="12" name="passwd"></td>
				</tr>
				<tr>
					<td colspan=2 bgcolor="${value_c}" align="center"><input
						type="submit" value="글수정"> <input type="reset"
						value="다시작성"> <input type="button" value="목록보기"
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
