<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"/>

<h2>저장된 정보 출력하기</h2>
이름 : <%=member.getName() %><br>
아이디  : <%=member.getUserid() %><br>

<h2>정보 변경후  정보 출력하기</h2>
<%
	member.setName("전수빈");
	member.setUserid("test02");
%>
이름 : <%=member.getName() %><br>
아이디  : <%=member.getUserid() %><br>
</body>
</html>