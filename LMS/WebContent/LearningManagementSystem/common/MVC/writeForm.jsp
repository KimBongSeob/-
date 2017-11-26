<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">


<title>게시판</title>
<%@include file="/LearningManagementSystem/student/css_script.jsp"%>
<script src="script.js"></script>
</head>
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
                        <h1 class="page-header">글쓰기</h1>
                    </div>
                </div>

<body>
	<center>
		
		<form method="post" name="writeform" action="/LMS/LearningManagementSystem/common/MVC/writePro.do" enctype="multipart/form-data" onsubmit="return writeSave()">

			<input type="hidden" name="num" value="${num}"> 
			<input type="hidden" name="ref" value="${ref}"> 
			<input type="hidden" name="re_step" value="${re_step}"> 
			<input type="hidden" name="re_level" value="${re_level}">
			

			
			<table width="700" border="1" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td align="right" colspan="2" bgcolor="${value_c}">
					<a href="/LMS/LearningManagementSystem/common/MVC/list.do"> 글목록</a></td>
				</tr>
				
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">작성자</td>
					<td width="330">
					${sessionScope.member}
					</td>
				</tr> 
				
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">제 목</td>
					<td width="330"><c:if test="${num == 0}">
							<input type="text" size="40" maxlength="50" name="subject"></td>
					</c:if>
					<c:if test="${num != 0}">
						<input type="text" size="40" maxlength="50" name="subject" value="[답변]">
						</td>
					</c:if>
				</tr>
				
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">첨부파일</td>
					<td><input type="file" name="filename"></td>
				</tr> 
				
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">내 용</td>
					<td width="330"><textarea name="content" rows="13" cols="40"></textarea>
					</td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c}" align="center">비밀번호</td>
					<td width="330">
					<input type="password" size="8" maxlength="12" name="passwd"></td>
				</tr>
				<tr>
					<td colspan=2 bgcolor="${value_c}" align="center">
					<input type="submit" value="글쓰기"> 
					<input type="reset" value="다시작성"> 
					<input type="button" value="목록보기" OnClick="window.location='/LMS/LearningManagementSystem/common/MVC/list.do'">
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
