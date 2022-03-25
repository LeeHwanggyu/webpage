<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.R == 'NOID' }">
		<script type="text/javascript">
			alert("잘못된 계정입니다.");
			location.href="home.jsp";
		</script>
	</c:when>
	<c:when test="${param.R == 'NOPWD' }">
		<script type="text/javascript">
			alert("암호를 확인해주세요.");
			location.href="home.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("환영합니다");
			location.href="home.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>







