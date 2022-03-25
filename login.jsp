<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#wrap{
  width:960px; /*bootstrap : container (전체 화면 , width :960px)*/
  height:900px;
  margin:0px auto; /*가운데 정렬*/
  font-size:20px;
  text-align: center;
  border:1px solid 
}
#header{
  width:960px;
  height:100px;
  background-color: black;
  color:white;
  line-height: 100px;/*글자나 이미지 위치 정렬*/
  border:1px solid;
  font-size:48px;
  font-weight:bold;
}
#nav{
   width:960px;
   height:100px;
   background-color: grey;
   line-height: 100px;/*글자나 이미지 위치 정렬*/
}
#aside {
   width:200px;
   height:700px;
   line-height: 100px;
   marjin-left:50px;
   float: left;
}
#section{
   width:760px;
   height:700px;
     
}
footer{align:center; background-color:black; color:white;
		height:100px; width: 960px; line-height: 100px;
		float: left;}
</style>
</head>
<body>
<c:if test="${param.MSG == 'M' }">
	<script type="text/javascript">
		alert("게시물 삭제 수정은 회원만 가능해욥.");
	</script>
</c:if>
<c:if test="${param.MSG == 'Y' }">
	<script type="text/javascript">
		alert("게시글 게시는 회원만 됩니다.");
	</script>
</c:if>
<div id="wrap">
    <div id="header">중고 의류 플랫폼</div>
    <div id="nav" ><%@ include file="menu_header.jsp" %></div>
    <div id="aside"><%@ include file="menu_left.jsp" %></div>
    <div id="section" align="center">
    <form action="login.do" method="post">
	<table>
		<tr height="40"><th>사용자ID</th>
			<td><input type="text" name="ID"/></td></tr>
		<tr height="40"><th>암 호</th>
			<td><input type="password" name="PWD"/></td></tr>
	</table>
	<table>
		<tr><td align="center"><input type="submit" value="로그인"/></td>
			<td align="center"><input type="reset" value="취 소"/></td></tr>
	</table>
	</form></div>
  </div>

</body>
</html>
















