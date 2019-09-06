<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<h1> 환영합니다</h1>


<table border="3px;">
	<tr>
		<td>로그인</td><td><input type="submit" value="LOGIN" id="login"/></td>
	</tr>
	<tr>
		<td>회원가입</td><td><a href="#" id="join_form">바로가기</a></td>
	</tr>
</table>

<script>
	$("#login").click(function(){
		 location.assign('<%=request.getContextPath()%>/customer.do?page=login');
		alert("login");
	});	
		$("#join_form").click(function(){
		alert("하이");
		 location.assign('<%=request.getContextPath()%>/customer.do?page=join');
	});
	
</script>
</body>
</html>