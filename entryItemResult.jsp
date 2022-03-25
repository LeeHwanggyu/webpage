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
			alert("상품이 등록되었습니다.");
			location.href="home.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("등록 실패했습니다. 다시 시도해주세요.");
			location.href="home.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>













