<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">

    <title>학사관리 프로그램</title>
    <%@include file="/LearningManagementSystem/professor/css_script.jsp"%>
<%-- <b>글목록(전체 글:${count})</b> <!-- request객체의 속성 count값 --> --%>

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
                        <h1 class="page-header">게시판</h1>
                    </div>
                </div>
                <center>
		
		<table width="1000">
			<tr>
				<td align="right" bgcolor="${value_c}">
				<a href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/writeForm.do">글쓰기</a></td>
			</tr>
		</table>

		<c:if test="${count == 0}">
			<table width="700" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<table border="1" width="700" cellpadding="0" cellspacing="0"
				align="center">
				<tr height="30" bgcolor="${value_c}">
					<td align="center" width="50">No.</td>
					<td align="center" width="250">제 목</td>
					<td align="center" width="100">작성자</td>
					<td align="center" width="150">작성일</td>
					<td align="center" width="50">조회수</td>
				</tr>

				<c:forEach var="article" items="${articleList}"> <!-- ArrayList에 n번째 인덱스의 값을 하나씩 꺼내서 article변수에 저장 -->
					<tr height="30">
						<td align="center" width="50">
						<c:out value="${number}" /> 
						<c:set var="number" value="${number - 1}" />
						</td>
						<td width="250">
						<c:if test="${article.re_level > 0}"> <!-- 읽을 수 있는 프로퍼티명인지 확인. => getre_level()메소드 호출 -->
								<img src="images/level.gif" width="${5 * article.re_level}" height="16">
								<img src="images/re.gif">
							</c:if> 
							<c:if test="${article.re_level == 0}">
								<img src="images/level.gif" width="${5 * article.re_level}" height="16">
							</c:if> 
							<a href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/content.do?num=${article.num}&pageNum=${currentPage}">${article.subject}</a> 
								<c:if test="${article.readcount >= 20}">
								<img src="images/hot.gif" border="0" height="16">
							</c:if>
							</td>
							
						<td align="center" width="100">${article.writer}</td>
					
						
						<td align="center" width="150"> 
						<fmt:formatDate value="${article.reg_date}" type="date" dateStyle="short"/>
						</td>
						<td align="center" width="50">${article.readcount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<c:set var="pageCount"
				value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
			<c:set var="pageBlock" value="${10}" />
			<fmt:parseNumber var="result" value="${currentPage / 10}"
				integerOnly="true" />
			<c:set var="startPage" value="${result * 10 + 1}" />
			<c:set var="endPage" value="${startPage + pageBlock-1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			<c:if test="${startPage > 10}">
				<a href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/list.do?pageNum=${startPage - 10 }">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/list.do?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="/LMS/LearningManagementSystem/professor/commonProfessor/MVC/list.do?pageNum=${startPage + 10}">[다음]</a>
			</c:if>
		</c:if>

	<form>
		<select name="searchn">
		<option value="0">작성자</option>
		<option value="1">제목</option>
		<option value="2">내용</option>
		</select>

		<input type="text" name="search" size="15" maxlength="50" /> 
		<input type="submit" value="검색" />&nbsp;
		<input type="button" value="목록보기" OnClick="window.location='/LMS/LearningManagementSystem/professor/commonProfessor/MVC/list.do'">
	</form>
		<br></br>

	</center>
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