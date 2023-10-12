<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>
<jsp:setProperty name="member" property="*"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력된 회원 정보</h2>
이름 : <jsp:getProperty property="name" name="member"/><br>
아이디 : <jsp:getProperty property="userid" name="member"/><br>
별명 : <jsp:getProperty property="nickname" name="member"/><br>
비빌번호 : <jsp:getProperty property="pwd" name="member"/><br>
이메일 : <jsp:getProperty property="email" name="member"/><br>
전화번호 : <jsp:getProperty property="phone" name="member"/><br>
<hr>
이름 : <%= member.getName() %>
아이디 : <%= member.getUserid() %>
</body>
</html>