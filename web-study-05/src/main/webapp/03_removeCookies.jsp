<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("id", "");
	cookie.setMaxAge(0);
	response.addCookie(cookie);

	cookie = new Cookie("pwd", "1111111111");
	cookie.setMaxAge(0);
	response.addCookie(cookie);

	cookie = new Cookie("age", "1111111111");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>
	<h3>id 쿠키가 삭제되었습니다.</h3>
	<a href="02_getCookies.jsp"> 쿠키삭제를 확인하려면 클릭하세요.</a>
</body>
</html>