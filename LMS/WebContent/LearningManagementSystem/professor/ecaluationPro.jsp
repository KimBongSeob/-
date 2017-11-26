<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>학사관리 시스템</title>



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

				<!-- Page Heading -->

					<div class="col-lg-12">
<c:choose>
<c:when test="${gnum >= 20}">
<center>
<h1 class="page-header">평가점수는 ${gnum}점 입니다 </h1>
<h1 class="page-header">평가등급은 A점 입니다 </h1>
</center>
</c:when>
<c:when test="${gnum >= 15}">
<center>
<h1 class="page-header">평가점수는 ${gnum}점 입니다 </h1>
<h1 class="page-header">평가등급은 B점 입니다 </h1>
</center>
</c:when>
<c:when test="${gnum >= 10}">
<center>
<h1 class="page-header">평가점수는 ${gnum}점 입니다 </h1>
<h1 class="page-header">평가등급은 C점 입니다 </h1>
</center>
</c:when>
<c:when test="${gnum >= 5}">
<center>
<h1 class="page-header">평가점수는 ${gnum}점 입니다 </h1>
<h1 class="page-header">평가등급은 D점 입니다 </h1>
</center>
</c:when>
<c:when test="${gnum < 5}">
<center>
<h1 class="page-header">강의평가 없습니다 </h1>
</center>
</c:when>
</c:choose>

						
					</div>

				<!-- /.row -->

</body>
</html>
