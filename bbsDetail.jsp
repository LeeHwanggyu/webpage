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
   line-height: 600px;   
}
footer{align:center; background-color:black; color:white;
		height:100px; width: 960px; line-height: 100px;
		float: left;}
</style>
</head>
<body>
<script type="text/javascript">
	function check(frm){
		if(frm.TITLE.value ==''){alert("제목 입력해주세용!"); return false;}
		if(frm.CONTENT.value ==''){alert("글 내용을 작성해야 게시물이 작성됩니다!"); return false;}
		var c = confirm("이대로 작성할래요?");
		if(c == false) return false;
	}
</script>
<div id="wrap">
    <div id="header">중고 의류 플랫폼</div>
    <div id="nav" ><%@ include file="menu_header.jsp" %></div>
    <div id="aside"><%@ include file="menu_left.jsp" %></div>
    <div id="section" align="center">
    	<form action="bbsModify.do" method="post" onSubmit="return check(this)">
    		<table>
    			<tr><th>글 번호</th><td><input type="text" name="SEQNO"
    			value="${BBS.seqno }" readOnly="readOnly"/></td></tr>
    			<tr><th>작성 날짜</th><td><input type="text" name="REG_DATE"
    			value="${BBS.date }" readOnly="readOnly"/></td></tr>
    			<tr><th>작성자</th><td><input type="text" name="ID"
    			value="${BBS.id }" readOnly="readOnly"/></td></tr>
    			<tr><th>글 제목</th><td><input type="text" name="TITLE"
    			value="${BBS.title }" /></td></tr>
    			<tr><th>글 내용</th><td><input type="text" name="CONTENT"
    			value="${BBS.content }" /></td></tr>    
    			<tr><td colspan="2" align="center"><input type="submit" value="삭제" name="BTN"/>
    			<input type="submit" value="수정" name="BTN"/></td></tr>			
    		</table>
    	</form>
    </div>
  </div>

</body>
</html>
















