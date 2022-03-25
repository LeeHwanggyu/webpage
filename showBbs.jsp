<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div id="nav"><%@ include file="menu_header.jsp" %></div>
    <div id="aside"><%@ include file="menu_left.jsp" %></div>
    <div id="section">
    <table align="left">
			<tr><td><a href="insertBbs.jsp">글 쓰기</a></td></tr>
		</table><br/>
<table border="1" align="center" width="450">
		<tr><th>글번호</th><th>글제목</th><th>작성자</th><th>작성일</th></tr>
		<c:forEach items="${BBSLIST }" var="bbs">
		<tr><td>${bbs.seqno }</td>
			<td><a href="bbsDetail.do?SEQNO=${bbs.seqno }">${bbs.title }</a></td>
			<td>${bbs.id }</td>
			<td>${bbs.bbs_date }</td></tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="bbsList.do?PAGE_NO=${page }">${page }</a>
	</c:forEach>
		
</div>
  </div>
</body>
</html>






