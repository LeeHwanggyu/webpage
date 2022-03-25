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
		height:100px; width: 760px; line-height: 100px;}

</style>
<link rel="stylesheet" href="./slider2.css">
</head>
<body>
  <div id="wrap">
    <div id="header">중고 의류 정보</div>
    <div id="nav" ><%@ include file="menu_header.jsp" %></div>
    <div id="aside"><font color="black"><%@ include file="menu_left.jsp" %></font></div>
    <div id="section">
	   <div class="slider">
    <input type="radio" name="slide" id="slide1" checked>
    <input type="radio" name="slide" id="slide2">
    <input type="radio" name="slide" id="slide3">
    <input type="radio" name="slide" id="slide4">
    <input type="radio" name="slide" id="slide5">
    <ul id="imgholder" class="imgs">
    
        <li><img src="./img/0.jpg"></li>
        <li><img src="./img/01.jpg"></li>
        <li><img src="./img/02.jpg"></li>
        <li><img src="./img/03.jpg"></li>
        <li><img src="./img/04.jpg"></li>
    </ul>
    <div class="bullets">
        <label for="slide1">&nbsp;</label>
        <label for="slide2">&nbsp;</label>
        <label for="slide3">&nbsp;</label>
        <label for="slide4">&nbsp;</label>
        <label for="slide5">&nbsp;</label>
    </div>
</div>
<footer>
이황규 과제
</footer>
	</div>
</div>
</body>
</html>