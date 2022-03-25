<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   line-height: 50px;   
}
footer{align:center; background-color:black; color:white;
		height:100px; width: 960px; line-height: 100px;
		float: left;}
</style>
<link rel="stylesheet" href="./slider2.css">
</head>
<body>
<script type="text/javascript">
function check(f){
	if(f.NAME.value==''){alert("이름 써야됨니다."); return false;}
	if(f.PRICE.value==''){alert("가격도 써야됨니다."); return false;}
	else{
		if(isNaN(f.PRICE.value == '')){alert("가격은 숫자로 입력 부탁드릴게요!") return false;}
	}
	if(f.INFO.value==''){alert("정보도 써야됨니다."); return false;}
	var c = confirm("이게 맞아요?");
	if(c == false)return false;
}
</script>
  <div id="wrap">
    <div id="header">의류 정보</div>
    <div id="nav" ><%@ include file="menu_header.jsp" %></div>
    <div id="aside"><font color="black"><%@ include file="menu_left.jsp" %></font></div>
    <div id="section">
	   <form action="itemModify.do" method="post" onSubmit="return check(this)">
	   	<table>
	   		<tr><th>상품 번호</th><td><input type="text" name="PID"
	   		value="${DETAIL.pid }" readOnly="readOnly"/></td></tr>
	   		<tr><th>상품명</th><td><input type="text" name="NAME"
	   		value="${DETAIL.pname }"/></td></tr>
	   		<tr><th>가격</th><td><input type="text" name="PRICE"
	   		value="${DETAIL.price }"/></td></tr>
	   		<tr><th>상품 회사</th><td>
	   		<select name="COM">
	   			<c:forEach begin="1" end="${CNT }" var="i">
	   				<c:choose>
	   					<c:when test="${DETAIL.ccode == i }">
	   						<option value="${i }" selected>${NAMES[i-1] }</option>
	   					</c:when>
	   					<c:otherwise>
	   						<option value="${i }">${NAMES[i-1] }</option>
	   					</c:otherwise>
	   				</c:choose>
	   			</c:forEach>
	   		</select></td></tr>
	   		<tr><th>설명</th><td><textarea row="5" cols="40" name="INFO">
	   		${DETAIL.pinfo }</textarea></td></tr>
	   		<tr><td colspan="2" align="center">
	   				<input type="submit" value="삭제" name="BTN"/>
	   				<input type="submit" value="수정" name="BTN"/></td></tr>
	   	</table>
	   </form>
<footer>
이황규 과제
</footer>
	</div>
</div>
</body>
</html>