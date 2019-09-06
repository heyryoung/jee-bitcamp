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

<h1> 로그인</h1>

<%
%>


<form id = "login" action="<%=application.getContextPath()%>/member.do?">
<table border="3px;">
	<tr>
		<td>ID</td><td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td>PASSWORD</td><td><input type="text" name="pass"/></td>
	</tr>
	<tr>
		<td>전송</td><td><input type="submit" value="전송"/></td>
	</tr>
	<input type="hidden" value="login" name="action"/>
	<input type="hidden" value="exist_id" name="dest"/>
</table>
</form>
<script>
	$("#login").submit(function(){
		 location.assign('<%=request.getContextPath()%>/member.do?action=move&dest=login');
		alert("login");
	});	
	
</script>
</body>
</html>