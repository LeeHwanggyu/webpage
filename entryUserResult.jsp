<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.R > 0 }">
		<script type="text/javascript">
			alert("환영합니다 ><");
			location.href="home.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("회원가입 실패했어요 ㅠㅠ");
			location.href="home.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>






