<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로드북 페이지로 이동</h1>
	<%-- <%= request.getParameter("name") %><br>
	<%= request.getParameter("age") %><br> --%>
	
	<%
		response.sendRedirect("http://www.naver.co.kr");
	%>
</body>
</html>