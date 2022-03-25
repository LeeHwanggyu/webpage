<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
  <div id="wrap">
    <div id="header">중고 의류 플랫폼</div>
    <div id="nav" ><%@ include file="menu_header.jsp" %></div>
    <div id="aside"><font color="black"><%@ include file="menu_left.jsp" %></font></div>
    <div id="section">
			<table>
					<tr><th>상품 번호</th><th>상품 이름</th><th>상품 가격</th></tr>
					<c:forEach items="${ITS }" var="item">
					<tr><td>${item.pid}</td>
						<td><a href="itemDetail.do?PID=${item.pid}">${item.pname}</a></td>
						<td><fmt:formatNumber
								groupingUsed="true">${item.price}</fmt:formatNumber></td></tr>
					</c:forEach>
				</table>
				<c:forEach begin="1" end="${TP }" var="page">
					<a href="selectItems.do?PAGE_NUM=${page }">${page }</a>
				</c:forEach>
</div>
</div>
</body>
</html>






