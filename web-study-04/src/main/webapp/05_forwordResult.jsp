<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	
	forward방식으로 이동된 페이지<br>
	나이2 : ${age}
	이름 : <%= request.getAttribute("name") %>
	이름2 : ${name}
</body>
</html>