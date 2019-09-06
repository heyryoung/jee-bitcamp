<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>하이하이하이</title>
</head>
<body>

<div>
<ol><h2>로그인</h2></ol>
<form action="<%=application.getContextPath()%>/customer.do?" id="join_form" >
<ol>아이디<input type="text"/ id="user_id" name ="id"></ol>
<ol>비밀번호<input type="password" id="user_pw" name="pass"/></ol>
<ol>주민번호<input type="password" id="user_ssn" name="ssn"/></ol>
<ol>이름<input type="password" id="user_name"/ name="name"></ol>
<ol>신용도<input type="password" id="user_credit" name="credit"/></ol>
<ol><input type="submit" value="전송" id="test" /></ol>
<input type="hidden" id="user_credit" name="action" value="join"/>
<input type="hidden" id="user_credit" name="page" value="login"/>
<!-- 
// id, pw, name, ssn, credit
 -->

<script>
$('#join_form').submit(function(){
	alert("ddd");
});
</script>

</form>

</div>

</body>
</html>