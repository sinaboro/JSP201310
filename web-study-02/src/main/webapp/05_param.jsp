<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body>
	
	<form method="post" action="ParamServlet" name="frm">
		
		<label for=id>아이디 : </label>
		<input type ="text" name=id id=id><br> 
		
		<label for=age>나이 : </label>
		<input type ="text" name=age id=age><br>
		
		비밀번호 : <input type ="password" name=age><br>
		
		내용 : <textarea rows="3" cols="20"></textarea>
		
		<input type="submit" value="전송" onclick="return check()"> 
	</form>
	
	
	
	
	
	
	
	
</body>
</html>