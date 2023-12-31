<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"타이타닉", "시네마 천국", "혹성 탈출", "킹콩"};
	request.setAttribute("movieList", movieList);
%>

<c:forEach var="movie" items="${movieList}">
	${movie} <br>
</c:forEach>
<hr>

<c:forEach var="movie" items="${movieList}" varStatus="status">
	<%-- ${status.index} &nbsp;&nbsp; --%>
	${status.count} &nbsp;&nbsp;
	${movie} <br>
</c:forEach>
<hr>

<c:forEach var="movie" items="${movieList}" varStatus="status">
	<c:if test="${status.first}">
		${movie} <br>
	</c:if>
	<c:if test="${status.last}">
		${movie}
	</c:if> 
	
</c:forEach>


</body>
</html>