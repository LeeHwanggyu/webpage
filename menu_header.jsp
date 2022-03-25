<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<table>
	<tr><td>
		<td><a href="home.jsp">■ 메인 페이지</a></td>
		<td><a href="userEntry.jsp">■ 회원가입</a><td>
		<td><a href="entryItem.do">■ 상품등록</a></td>
		<td><c:choose>
				<c:when test="${sessionScope.LOGIN != null }">
					<a href="logout.do">■ 계정 :<font color="blue"> ${sessionScope.LOGIN }</font> 로그아웃 하기</a>
				</c:when>
				<c:otherwise>
					<font color="red"><a href="login.jsp">■ 로그인 하기</a></font>
				</c:otherwise>
				
			</c:choose></td></tr>
</table>
