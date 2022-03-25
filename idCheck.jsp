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
<div align="center">
	<h2>계정 중복 확인</h2>
	<form action="idCheck.do" name="frm">
	계 정 : <input type="text" name="MEMBER_ID" value="${ID }"/>
	<input type="submit" value="중복 검사"/>
	</form>
<c:if test="${ ! empty DUP }">
${DUP }는 이미 사용 중입니다.
</c:if>
<c:if test="${ empty DUP }">
${ID }는 사용 가능합니다. 
<input type="button" value="사용" onClick="idOk()"/>
</c:if>
</div>
<script type="text/javascript">
function idOk(){
	//중복검사 유무를 위한 파라미터(IDCHECKED)에 값을 넣는다.
	//IDCHECKED 파라미터는 부모 JSP(userEntry.jsp)에 있다. 
	//부모 JSP에 대한 document->opener.document
	opener.document.frm.IDCHECKED.value = "OK";
	//계정이 입력되는 파라미터(ID)를 비활성화 한다.(이미 중복검사를 했으므로)
	opener.document.getElementById("memberId").readOnly= true;
	opener.document.frm.ID.value = document.frm.MEMBER_ID.value;
	//창을 닫는다.
	self.close();
}
</script>
</body>
</html>












