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
	<h2>���� �ߺ� Ȯ��</h2>
	<form action="idCheck.do" name="frm">
	�� �� : <input type="text" name="MEMBER_ID" value="${ID }"/>
	<input type="submit" value="�ߺ� �˻�"/>
	</form>
<c:if test="${ ! empty DUP }">
${DUP }�� �̹� ��� ���Դϴ�.
</c:if>
<c:if test="${ empty DUP }">
${ID }�� ��� �����մϴ�. 
<input type="button" value="���" onClick="idOk()"/>
</c:if>
</div>
<script type="text/javascript">
function idOk(){
	//�ߺ��˻� ������ ���� �Ķ����(IDCHECKED)�� ���� �ִ´�.
	//IDCHECKED �Ķ���ʹ� �θ� JSP(userEntry.jsp)�� �ִ�. 
	//�θ� JSP�� ���� document->opener.document
	opener.document.frm.IDCHECKED.value = "OK";
	//������ �ԷµǴ� �Ķ����(ID)�� ��Ȱ��ȭ �Ѵ�.(�̹� �ߺ��˻縦 �����Ƿ�)
	opener.document.getElementById("memberId").readOnly= true;
	opener.document.frm.ID.value = document.frm.MEMBER_ID.value;
	//â�� �ݴ´�.
	self.close();
}
</script>
</body>
</html>












