<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	if(f.NAME.value == ''){alert("이름을 입력하세요."); return false;}
	if(f.PRICE.value == ''){alert("가격을 입력하세요."); return false;}
	else {
		if(isNaN(f.PRICE.value)){alert("가격은 숫자로 입력하세요."); return false;}
	}
	if(f.INFO.value == ''){alert("설명을 입력하세요."); return false;}
	var c = confirm("입력한 내용이 맞습니까?");
	if(c == false) return false;
}
</script>
	    <form action="entryItemDo.do" method="post" onSubmit="return check(this)">
		<table>
			<tr><th>상품번호</th><td><input type="text" name="PID" value="${PID }"
				readOnly="readOnly"/></td></tr>
			<tr><th>상품이름</th><td><input type="text" name="NAME"/></td></tr>
			<tr><th>가 격</th><td><input type="text" name="PRICE"/></td></tr>
			<tr><th>판매자명</th><td>
			<select name="COMPANY">
			<c:forEach begin="1" end="${SIZE}" var="i">
				<option value="${i }">${COMS[i - 1] }</option>
			</c:forEach>
			</select>
			</td></tr>
			<tr><th>설 명</th><td><textarea rows="5" cols="40" 
				name="INFO"></textarea></td></tr>
			<tr><td colspan="2" align="center"><input type="submit" value="등록"/>
				<input type="reset" value="취소"/></td></tr>
		</table>
		</form>
    </div>
  </div>
</body>
</html>
