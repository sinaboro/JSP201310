<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>세션 정보를 얻어오는 메소드를 사용하기</h3>
<%
String id_str = session.getId();
long lastTime = session.getLastAccessedTime();
long creatTime=session.getCreationTime();
long timeUsed = (lastTime -  creatTime)/6000;
int inactvie = session.getMaxInactiveInterval()/60;
boolean b_new  =session.isNew();
%>

id : <%=session.getId() %> <br>
사용시간 : <%=timeUsed %> <br>
유효시간 : <%=inactvie %> <br>

세션이 새로 만들어졌나요?
<%
if(b_new)
	out.println("예!! 새로운 센션");
else
	out.println("아니요!! 기존 센션");
%>
</body>
</html>