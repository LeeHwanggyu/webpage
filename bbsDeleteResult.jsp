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
			alert("삭제 완료~");
			location.href="bbsList.do";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("삭제 실패~");
			location.href="bbsList.do";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>













