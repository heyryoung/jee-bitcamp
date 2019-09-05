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
<ol><h2>통장 개설</h2></ol>
<form action="<%=application.getContextPath()%>/account.do" id="account_form" >
<ol>입금액<input type="text"/ id="money" name ="money"></ol>
<ol><input type="submit" value="전송" id="test" /></ol>

<!-- 
// id, pw, name, ssn, credit
 -->

<script>
$('#account_form').submit(function(){
	alert("통장테스트");
});
</script>

</form>

</div>

</body>
</html>