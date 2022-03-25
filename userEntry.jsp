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
<link rel="stylesheet" href="./slider2.css">
</head>
<body>
<script type="text/javascript">
function check(f){
 	if(f.IDCHECKED.value == ''){alert("중복검사를 해주세요."); return false;}
	if(f.NAME.value == ''){alert("이름을 입력하세요."); return false;}
	if(f.ID.value == ''){alert("계정을 입력하세요."); return false;}
	if(f.ADDR.value == ''){alert("주소를 입력하세요."); return false;}
	if(f.PWD.value == ''){alert("암호를 입력하세요."); return false;}
	if(f.PWD.value != f.CFN.value){
		alert("암호가 일치하지 않습니다."); return false;
	}
	if(f.TEL.value == ''){alert("연락처를 입력하세요."); return false;}
	if( ! f.GENDER[0].checked && ! f.GENDER[1].checked){
		alert("성별을 선택하세요."); return false;
	}
	var c = confirm("입력한 내용이 맞습니까?");
	if(c == false) return false;
}
function idCheck(){
	if(document.frm.ID.value == ''){alert("계정을 입력하세요."); return;}
	var url = "idCheck.do?MEMBER_ID="+document.frm.ID.value;
	window.open(url,"_idcheck_","width=845,height=300");
}
</script>
  <div id="wrap">
    <div id="header">중고 의류 플랫폼</div>
    <div id="nav" ><%@ include file="menu_header.jsp" %></div>
    <div id="aside"><font color="black"><%@ include file="menu_left.jsp" %></font></div>
    <div id="section">
	   <form action="userEntry.do" method="post" name="frm" onSubmit="return check(this)">
	<input type="hidden" name="IDCHECKED"/>
<table>
	<tr><th>성 함</th><td><input type="text" name="NAME"/></td></tr>
	<tr><th>아이디</th><td><input type="text"  name="ID" id="memberId"/>
		<input type="button" value="중복검사" onClick="idCheck()"/></td></tr>
	<tr><th>어드레스</th><td><input type="text" name="ADDR"/></td></tr>
	<tr><th>패스워드</th><td><input type="password" name="PWD"/></td></tr>
	<tr><th>패스워드 확인</th><td><input type="password" name="CFN"/></td></tr>
	<tr><th>휴대전화</th><td><input type="text" name="TEL"/></td></tr>
	<tr><th>성 별</th><td>남자<input type="radio" name="GEN" value="남자"/>
		여자<input type="radio" name="GENDER" value="여자"/></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="확인" />
		<input type="reset" value="취소" /></td></tr>
</table>
</form>
	</div>
</div>
</body>
</html>