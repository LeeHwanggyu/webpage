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
   line-height: 600px;
   float: left;
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
    <div id="section"><strong><p>중고거래에 발생할 수 있는 불안감을 해소할 수 있도록 도움을 주는 회사입니다.</p></strong></div>
  </div>
</body>
</html>