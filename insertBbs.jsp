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
		<script type="text/javascript">
function check(f){
	if(f.TITLE.value == ''){alert("제목을 입력하세요."); return false;}
	if(f.CONTENT.value == ''){alert("글 내용을 입력하세요."); return false;}
	var c = confirm("게시글을 등록하시겠습니까?");
	if(c == false) return false;
}
</script>
	<form action="bbsPost.do" method="post" onSubmit="return check(this)">
	<table>
		<tr><th>글 제목</th><td><input type="text" name="TITLE" 
			placeHolder="제목을 입력하세요."/></td></tr>
		<tr><th>글 내용</th><td><textarea rows="5" cols="50" name="CONTENT"
			placeHolder="글 내용을 입력하세요."></textarea></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="글 올리기"/>
			<input type="reset" value="취 소"/></td></tr>
	</table>
	</form>
</div>
  </div>
</body>
</html>




<!-- 3. 실행 스크립트 -->
